package com.frontier.mobile.gkjd.webservice.bean;

/**
 * 终端响应实体
 * 
 * @author 纪云行
 */
public class ResponseEntity {
	/**
	 * 模块号
	 */
	private String MOD;
	
	/**
	 * 功能号
	 */
	private String FUN;
	
	/**
	 * 类型（0：业务操作 1：文件操作）
	 */
	private String PKG_TYPE;
	
	/**
	 * 响应编码
	 */
	private String RET;
	
	/**
	 * 消息
	 */
	private String MSG;
	
	/**
	 * 业务响应实体
	 */
	private GkjdResponseEntity PKG;
	
	public String getMod() {
		return MOD;
	}

	public void setMod(String mod) {
		MOD = mod;
	}

	public String getFun() {
		return FUN;
	}

	public void setFun(String fun) {
		FUN = fun;
	}

	public String getPkgType() {
		return PKG_TYPE;
	}

	public void setPkgType(String pkgType) {
		PKG_TYPE = pkgType;
	}

	public String getRet() {
		return RET;
	}

	public void setRet(String ret) {
		RET = ret;
	}

	public String getMsg() {
		return MSG;
	}

	public void setMsg(String msg) {
		MSG = msg;
	}
	
	public GkjdResponseEntity getPkg() {
		return PKG;
	}

	public void setPkg(GkjdResponseEntity pkg) {
		PKG = pkg;
	}
}