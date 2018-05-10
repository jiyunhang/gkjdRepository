package com.frontier.mobile.gkjd.webservice;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.util.ReflectionUtils;

import com.frontier.mobile.gkjd.common.BeanConfig;
import com.frontier.mobile.gkjd.common.GsonUtil;
import com.frontier.mobile.gkjd.common.Objects;
import com.frontier.mobile.gkjd.service.exception.GkjdSystemException;
import com.frontier.mobile.gkjd.webservice.bean.GkjdResponseEntity;
import com.frontier.mobile.gkjd.webservice.bean.RequestEntity;
import com.frontier.mobile.gkjd.webservice.constant.Constant;
import com.frontier.mobile.gkjd.webservice.exception.GkjdValidationException;
import com.frontier.mobile.gkjd.webservice.util.ResponseEntityUtil;
import com.frontier.mobile.gkjd.webservice.util.SpringContextHolder;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.Sets;

import lombok.extern.slf4j.Slf4j;

/**
 * 关口检定WebService服务实现类
 * 
 * @author 纪云行
 */
@Slf4j
@WebService(targetNamespace = "http://platserver.mpbiffyx.frontier.com/")
public class GkjdWebServiceImpl implements GkjdWebService {
	/**
	 * 获取数据
	 * 
	 * @param json 终端请求报文
	 * @return 终端响应报文
	 */
	public String getData(@WebParam(name = "pkgData") String json) {
		// 将终端请求报文转换成请求实体类
		RequestEntity requestEntity = GsonUtil.fromJson(json, RequestEntity.class);
		// 报文基本校验
		validate(requestEntity);
		// 获取bean名称和对应方法名称
		String beanInfo = BeanConfig.getString(requestEntity.getFun());
		// bean名称
		String beanName = beanInfo.split("#")[0];
		// bean对应方法名称
		String methodName = beanInfo.split("#")[1];
		// 动态获取关口检定控制类
		Object controlBean = null;
		try {
			controlBean = SpringContextHolder.getBean(Class.forName(beanName));
		} catch (ClassNotFoundException e) {
			log.error("找不到类异常，异常信息：{}", e.getMessage());
			throw new GkjdSystemException(e.getMessage());
		}

		// 通过反射调用控制类具体业务方法
		Method method = null;
		GkjdResponseEntity gkjdResponseEntity = null;
		// 请求正文信息map
		Map<String, String> jsonMap = requestEntity.getPkg();
		// 业务数据为空
		if (jsonMap.isEmpty()) {
			method = ReflectionUtils.findMethod(controlBean.getClass(), methodName);
			method.setAccessible(true);
			gkjdResponseEntity = (GkjdResponseEntity) ReflectionUtils.invokeMethod(method, controlBean);
		} else {
			method = ReflectionUtils.findMethod(controlBean.getClass(), methodName, jsonMap.getClass());
			method.setAccessible(true);
			gkjdResponseEntity = (GkjdResponseEntity) ReflectionUtils.invokeMethod(method, controlBean, jsonMap);
		}
		// 返回最终响应报文
		return ResponseEntityUtil.wrapSuccessResp(requestEntity, gkjdResponseEntity);
	}

	/**
	 * 请求参数校验
	 * 
	 * @param requestEntity 请求参数实体
	 */
	private void validate(RequestEntity requestEntity) {
		Set<ErrorCodeEnum> errorCodeSet = Sets.newHashSet();
		if (Strings.isNullOrEmpty(requestEntity.getMod())) {
			errorCodeSet.add(ErrorCodeEnum.ERROR_01);
		} else {
			if (!Constant.GKJD_MOD.equals(requestEntity.getMod())) {
				errorCodeSet.add(ErrorCodeEnum.ERROR_02);
			}
		}
		if (Strings.isNullOrEmpty(requestEntity.getFun())) {
			errorCodeSet.add(ErrorCodeEnum.ERROR_03);
		}
		if (Strings.isNullOrEmpty(requestEntity.getPkgType())) {
			errorCodeSet.add(ErrorCodeEnum.ERROR_04);
		}
		if (Strings.isNullOrEmpty(requestEntity.getUsr())) {
			errorCodeSet.add(ErrorCodeEnum.ERROR_05);
		}
		if (Strings.isNullOrEmpty(requestEntity.getOrgNo())) {
			errorCodeSet.add(ErrorCodeEnum.ERROR_06);
		}
		if (Objects.isNull(requestEntity.getPkg())) {
			errorCodeSet.add(ErrorCodeEnum.ERROR_07);
		}
		if (!errorCodeSet.isEmpty()) {
			Set<String> errorMsgSet = Sets.newHashSet();
			Iterator<ErrorCodeEnum> iter = errorCodeSet.iterator();
			while (iter.hasNext()) {
				errorMsgSet.add(iter.next().getValue());
			}
			throw new GkjdValidationException(Joiner.on(",").join(errorMsgSet));
		}
		// 校验业务方法是否存在
		if (!BeanConfig.exist(requestEntity.getFun())) {
			throw new GkjdValidationException(ErrorCodeEnum.ERROR_08.getValue());
		}
	}

	/**
	 * 校验错误代码
	 * 
	 * @author 纪云行
	 */
	private enum ErrorCodeEnum {
		ERROR_01("模块号不能为空"), ERROR_02("关口检定模块编号不正确"), ERROR_03("功能号不能为空"), ERROR_04("操作类型不能为空"), ERROR_05(
				"用户编号不能为空"), ERROR_06("供电公司不能为空"), ERROR_07("业务报文不能为空"), ERROR_08("关口检定业务方法不存在");
		private String value;

		private ErrorCodeEnum(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}
}