package com.frontier.mobile.gkjd.webservice.util;

import com.frontier.mobile.gkjd.webservice.bean.GkjdResponseEntity;

/**
 * 响应报文实体处理工具
 * 
 * @author 纪云行
 */
public class GkjdResponseEntityUtil {
	/**
	 * 成功
	 */
	private static final Integer SUCCESS = 1;
	
	/**
	 * 失败
	 */
	private static final Integer FAIL = 0;
	
	/**
	 * 确保自身不能被外部实例化
	 */
	private GkjdResponseEntityUtil() {}
	
	/**
	 * 包装成功响应
	 * 
	 * @param data 数据（接口响应信息）
	 * @return 响应JSON字符串
	 */
	public static GkjdResponseEntity wrapSuccessResp(String data) {
		return wrap(SUCCESS, null, data);
	}

	/**
	 * 包装失败响应
	 * 
	 * @param data 数据（异常信息）
	 * @return 响应JSON字符串
	 */
	public static GkjdResponseEntity wrapFailResp(String data) {
		return wrap(FAIL, data, null);
	}

	/**
	 * 统一包装消息
	 * 
	 * @param retCode 响应编码
	 * @param retMsg 响应消息
	 * @param data 响应数据
	 * @return 包装后的完整JSON字符串
	 */
	private static GkjdResponseEntity wrap(Integer retCode, String retMsg, String data) {
		GkjdResponseEntity responseEntity = new GkjdResponseEntity();
		responseEntity.setRetCode(retCode);
		responseEntity.setRetMsg(retMsg);
		responseEntity.setPkg(data);
		return responseEntity;
	}
}