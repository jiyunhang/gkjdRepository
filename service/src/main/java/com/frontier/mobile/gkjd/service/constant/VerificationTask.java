package com.frontier.mobile.gkjd.service.constant;

/**
 * 检定任务对象前缀
 * 
 * @author 纪云行
 */
public class VerificationTask {
	/**
	 * 确保自身不能被外部实例化
	 */
	private VerificationTask() {}
	
	/**
	 * 电能表误差检定任务
	 */
	public static final String METER_ERROR_VER_TASK = "mpMeterCheckDataPeriod";
	
	/**
	 * CT误差检定任务
	 */
	public static final String CT_ERROR_VER_TASK = "mpCtCheckDataPeriod";
	
	/**
	 * CT二次负荷检定任务
	 */
	public static final String CT_SEC_LOAD_VER_TASK = "mpCtSecLoadPeriod";
	
	/**
	 * PT误差检定任务
	 */
	public static final String PT_ERROR_VER_TASK = "mpPtCheckDataPeriod";
	
	/**
	 * PT二次负荷检定任务
	 */
	public static final String PT_SEC_LOAD_VER_TASK = "mpPtSecLoadPeriod";
	
	/**
	 * PT二次压降检定任务
	 */
	public static final String PT_SEC_VOL_VER_TASK = "mpPtSecVoltPeriod";
}