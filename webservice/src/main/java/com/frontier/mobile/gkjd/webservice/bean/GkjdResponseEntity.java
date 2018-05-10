package com.frontier.mobile.gkjd.webservice.bean;

/**
 * 关口检定响应实体
 * 
 * @author 纪云行
 */
public class GkjdResponseEntity {
	/**
	 * 响应编码（0：失败 1：成功）
	 */
	private Integer RET_CODE;
	
	/**
	 * 响应消息
	 */
	private String RET_MSG;
	
	/**
	 * 响应数据
	 */
	private String PKG;
	
	public Integer getRetCode() {
		return RET_CODE;
	}

	public void setRetCode(Integer retCode) {
		RET_CODE = retCode;
	}

	public String getRetMsg() {
		return RET_MSG;
	}

	public void setRetMsg(String retMsg) {
		RET_MSG = retMsg;
	}

	public String getPkg() {
		return PKG;
	}

	public void setPkg(String pkg) {
		PKG = pkg;
	}
}