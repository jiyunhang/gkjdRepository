package com.frontier.mobile.gkjd.service.constant;

import com.frontier.mobile.gkjd.common.SystemConfig;

/**
 * 关口检定常量类
 * 
 * @author 纪云行
 */
public class Constant {
	/**
	 * 确保自身不能被外部实例化
	 */
	private Constant() {}
	
	/**
	 * 关口检定根路径
	 */
	public static final String ROOT_URL = SystemConfig.getString("gkjdUrl");
	
	/**
	 * 电能表误差
	 */
	public static final String METER_ERROR = ROOT_URL + "ws_dMeterCheckData";
	
	/**
	 * CT误差检定
	 */
	public static final String CT_ERROR_VER = ROOT_URL + "ws_ctError";
	
	/**
	 * CT二次负荷
	 */
	public static final String CT_SEC_LOAD = ROOT_URL + "ws_ctSecCheckDataManage";
	
	/**
	 * PT误差检定
	 */
	public static final String PT_ERROR_VER = ROOT_URL + "ws_ptCheckDataManage";
	
	/**
	 * PT二次负荷
	 */
	public static final String PT_SEC_LOAD = ROOT_URL + "ws_ptSecCheckDataManage";
	
	/**
	 * PT二次压降
	 */
	public static final String PT_SEC_VOL = ROOT_URL + "ws_ptSecVol";
	
	/**
	 * 关口检定公共模块
	 */
	public static final String COMMON_CHECK_DATA = ROOT_URL + "ws_checkDataManage";
	
	/**
	 * 电能表误差
	 */
	public static final int MOD_METER_ERROR = 1;
	
	/**
	 * CT误差检定
	 */
	public static final int MOD_CT_ERROR_VER = 2;
	
	/**
	 * CT二次负荷
	 */
	public static final int MOD_CT_SEC_LOAD = 3;
	
	/**
	 * PT误差检定
	 */
	public static final int MOD_PT_ERROR_VER = 4;
	
	/**
	 * PT二次负荷
	 */
	public static final int MOD_PT_SEC_LOAD = 5;
	
	/**
	 * PT二次压降
	 */
	public static final int MOD_PT_SEC_VOL = 6;
}