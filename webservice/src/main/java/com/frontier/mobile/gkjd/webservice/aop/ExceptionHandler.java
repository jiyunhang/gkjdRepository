package com.frontier.mobile.gkjd.webservice.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.frontier.mobile.gkjd.common.GsonUtil;
import com.frontier.mobile.gkjd.service.exception.GkjdSystemException;
import com.frontier.mobile.gkjd.webservice.bean.RequestEntity;
import com.frontier.mobile.gkjd.webservice.exception.GkjdValidationException;
import com.frontier.mobile.gkjd.webservice.util.GkjdResponseEntityUtil;
import com.frontier.mobile.gkjd.webservice.util.ResponseEntityUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 异常拦截器
 * 
 * @author 纪云行
 */
@Slf4j
@Aspect
@Component
public class ExceptionHandler {
	/**
	 * 异常拦截处理
	 * 
	 * @param pjp 执行连接点
	 * @return 异常处理结果
	 */
	@Around("execution(* com.frontier.mobile.gkjd.webservice.*.*(..))")
	public Object handler(ProceedingJoinPoint pjp) {
		try {
			return pjp.proceed();
		} catch (Throwable e) {
			// 获取方法参数
			String json = (String) pjp.getArgs()[0];
			// 将参数反序列化成JavaBean
			RequestEntity requestEntity = GsonUtil.fromJson(json, RequestEntity.class);
			if (e instanceof GkjdValidationException) {
				log.error("关口检定校验异常，异常信息：{}", e.getMessage());
				return ResponseEntityUtil.wrapFailResp(requestEntity, e.getMessage());
			} else if (e instanceof GkjdSystemException) {
				log.error("关口检定系统异常，异常信息：{}", e.getMessage());
			} else if (e instanceof NumberFormatException) {
				log.error("关口检定运行时异常，异常信息：{}", e.getMessage());
				return ResponseEntityUtil.wrapSuccessResp(requestEntity,
						GkjdResponseEntityUtil.wrapFailResp("请求参数格式错误"));
			}
			return ResponseEntityUtil.wrapSuccessResp(requestEntity,
					GkjdResponseEntityUtil.wrapFailResp(e.getMessage()));
		}
	}
}