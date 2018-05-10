package com.frontier.mobile.gkjd.webservice.bean;

import java.util.Map;

/**
 * 终端请求实体
 * 
 * @author 纪云行
 */
public class RequestEntity {
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
	 * 用户编号
	 */
	private String USR;
	
	/**
	 * 供电公司编号
	 */
	private String ORG_NO;
	
	/**
	 * 业务数据
	 */
	private Map<String, String> PKG;

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

	public String getUsr() {
		return USR;
	}

	public void setUsr(String usr) {
		USR = usr;
	}

	public String getOrgNo() {
		return ORG_NO;
	}

	public void setOrgNo(String orgNo) {
		ORG_NO = orgNo;
	}

	public Map<String, String> getPkg() {
		return PKG;
	}

	public void setPkg(Map<String, String> pkg) {
		PKG = pkg;
	}
}