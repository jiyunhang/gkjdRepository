package com.frontier.mobile.gkjd.webservice.util;

import com.frontier.mobile.gkjd.common.GsonUtil;
import com.frontier.mobile.gkjd.common.Objects;
import com.frontier.mobile.gkjd.webservice.bean.GkjdResponseEntity;
import com.frontier.mobile.gkjd.webservice.bean.RequestEntity;
import com.frontier.mobile.gkjd.webservice.bean.ResponseEntity;
import com.google.common.base.Strings;

/**
 * 响应报文实体处理工具
 * 
 * @author 纪云行
 */
public class ResponseEntityUtil {
	/**
	 * 确保自身不能被外部实例化
	 */
	private ResponseEntityUtil() {}
	
	/**
	 * 包装成功响应
	 * 
	 * @param requestEntity 请求实体
	 * @param gkjdResponseEntity 关口检定业务响应实体
	 * @return 最终返回给终端的响应报文
	 */
	public static String wrapSuccessResp(RequestEntity requestEntity, GkjdResponseEntity gkjdResponseEntity) {
		return wrapResp(CommonCode.BUSI_SUCSESS, requestEntity, gkjdResponseEntity, null);
	}
	
	/**
	 * 包装失败响应（校验失败）
	 * 
	 * @param requestEntity 请求实体
	 * @param errorMsg 异常信息
	 * @return 最终返回给终端的响应报文
	 */
	public static String wrapFailResp(RequestEntity requestEntity, String errorMsg) {
		return wrapResp(CommonCode.BUSI_VALIDATION, requestEntity, null, errorMsg);
	}
	
	/**
	 * 包装响应
	 * 
	 * @param commonCode 响应代码
	 * @param requestEntity 请求实体
	 * @param gkjdResponseEntity 关口检定业务响应实体
	 * @param errorMsg 异常信息
	 * @return 最终返回给终端的响应报文
	 */
	private static String wrapResp(CommonCode commonCode, RequestEntity requestEntity,
			GkjdResponseEntity gkjdResponseEntity, String errorMsg) {
		ResponseEntity responseEntity = new ResponseEntity();
		responseEntity.setMod(requestEntity.getMod());
		responseEntity.setFun(requestEntity.getFun());
		responseEntity.setPkgType(requestEntity.getPkgType());
		switch (commonCode) {
		case BUSI_VALIDATION:
			responseEntity.setRet(CommonCode.BUSI_VALIDATION.getValue());
			break;
		case BUSI_SUCSESS:
			responseEntity.setRet(CommonCode.BUSI_SUCSESS.getValue());
			break;
		default:
			break;
		}
		if (!Strings.isNullOrEmpty(errorMsg)) {
			responseEntity.setMsg(errorMsg);
		}
		if (Objects.nonNull(gkjdResponseEntity)) {
			responseEntity.setPkg(gkjdResponseEntity);
		}
		return GsonUtil.toJsonString(responseEntity);
	}

	/**
	 * 响应代码
	 * 
	 * @author 纪云行
	 */
	private enum CommonCode {
		// 业务处理成功
		BUSI_SUCSESS("10"),
		// 业务校验异常
		BUSI_VALIDATION("11");
		String value;

		CommonCode(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}
}