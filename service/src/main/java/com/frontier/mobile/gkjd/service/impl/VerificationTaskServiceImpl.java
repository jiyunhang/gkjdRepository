package com.frontier.mobile.gkjd.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.frontier.mobile.gkjd.service.ServiceSupport;
import com.frontier.mobile.gkjd.service.VerificationTaskService;
import com.frontier.mobile.gkjd.service.constant.Constant;
import com.frontier.mobile.gkjd.service.constant.VerificationTask;

/**
 * 检定任务服务类
 * 
 * @author 纪云行
 */
@Service
public class VerificationTaskServiceImpl extends ServiceSupport implements VerificationTaskService {
	/**
	 * 查询检定任务
	 * 
	 * @param stationId 电站ID
	 * @param primaryId 关口ID/设备ID
	 * @param moduleType 类型（电能表误差、CT误差、CT二次负荷、PT误差、PT二次负荷、PT二次压降）
	 * @return 检定任务列表JSON字符串
	 */
	@Override
	public String listVerificationTask(Long stationId, Long primaryId, Integer moduleType) {
		String url = null;
		switch (moduleType) {
		case Constant.MOD_METER_ERROR:
			url = LIST_METER_ERROR_VER_TASK;
			break;
		case Constant.MOD_CT_ERROR_VER:
			url = LIST_CT_ERROR_VER_TASK;
			break;
		case Constant.MOD_CT_SEC_LOAD:
			url = LIST_CT_SEC_LOAD_VER_TASK;
			break;
		case Constant.MOD_PT_ERROR_VER:
			url = LIST_PT_ERROR_VER_TASK;
			break;
		case Constant.MOD_PT_SEC_LOAD:
			url = LIST_PT_SEC_LOAD_VER_TASK;
			break;
		case Constant.MOD_PT_SEC_VOL:
			url = LIST_PT_SEC_VOL_VER_TASK;
			break;
		}
		return sendGetRequest(String.format(url, stationId, primaryId));
	}
	
	/**
	 * 新增检定任务
	 * 
	 * @param verTaskMap 检定任务map
	 * @param moduleType 类型（电能表误差、CT误差、CT二次负荷、PT误差、PT二次负荷、PT二次压降）
	 * @return 新增检定任务成功或失败
	 */
	@Override
	public String addVerificationTask(Map<String, String> verTaskMap, Integer moduleType) {
		String url = null;
		String beanPrefix = null;
		switch (moduleType) {
		case Constant.MOD_METER_ERROR:
			url = ADD_METER_ERROR_VER_TASK;
			beanPrefix = VerificationTask.METER_ERROR_VER_TASK;
			break;
		case Constant.MOD_CT_ERROR_VER:
			url = ADD_CT_ERROR_VER_TASK;
			beanPrefix = VerificationTask.CT_ERROR_VER_TASK;
			break;
		case Constant.MOD_CT_SEC_LOAD:
			url = ADD_CT_SEC_LOAD_VER_TASK;
			beanPrefix = VerificationTask.CT_SEC_LOAD_VER_TASK;
			break;
		case Constant.MOD_PT_ERROR_VER:
			url = ADD_PT_ERROR_VER_TASK;
			beanPrefix = VerificationTask.PT_ERROR_VER_TASK;
			break;
		case Constant.MOD_PT_SEC_LOAD:
			url = ADD_PT_SEC_LOAD_VER_TASK;
			beanPrefix = VerificationTask.PT_SEC_LOAD_VER_TASK;
			break;
		case Constant.MOD_PT_SEC_VOL:
			url = ADD_PT_SEC_VOL_VER_TASK;
			beanPrefix = VerificationTask.PT_SEC_VOL_VER_TASK;
			break;
		}
		// 将MAP转换成带对象前缀的MAP
		Map<String, String> paramMap = wrapKeyForMap(verTaskMap, beanPrefix);
		return sendPostRequest(paramMap, url);
	}
	
	/**
	 * 删除检定任务
	 * 
	 * @param periodId 检定任务ID
	 * @param moduleType 类型（电能表误差、CT误差、CT二次负荷、PT误差、PT二次负荷、PT二次压降）
	 * @return 删除检定任务成功或失败
	 */
	@Override
	public String deleteVerificationTask(Long periodId, Integer moduleType) {
		String url = null;
		switch (moduleType) {
		case Constant.MOD_METER_ERROR:
			url = DELETE_METER_ERROR_VER_TASK;
			break;
		case Constant.MOD_CT_ERROR_VER:
			url = DELETE_CT_ERROR_VER_TASK;
			break;
		case Constant.MOD_CT_SEC_LOAD:
			url = DELETE_CT_SEC_LOAD_VER_TASK;
			break;
		case Constant.MOD_PT_ERROR_VER:
			url = DELETE_PT_ERROR_VER_TASK;
			break;
		case Constant.MOD_PT_SEC_LOAD:
			url = DELETE_PT_SEC_LOAD_VER_TASK;
			break;
		case Constant.MOD_PT_SEC_VOL:
			url = DELETE_PT_SEC_VOL_VER_TASK;
			break;
		}
		return sendGetRequest(String.format(url, periodId));
	}
	
	/**
	 * 查询电能表误差检定任务列表URL
	 */
	private static final String LIST_METER_ERROR_VER_TASK = Constant.METER_ERROR + "/queryDmeterChkDataAllTask.action?stationId=%1$d&measurePointId=%2$d";
	
	/**
	 * 查询CT误差检定任务列表URL
	 */
	private static final String LIST_CT_ERROR_VER_TASK = Constant.CT_ERROR_VER + "/queryCTErrorVerificationTask.action?stationId=%1$d&itSetId=%2$d";
	
	/**
	 * 查询CT二次负荷检定任务列表URL
	 */
	private static final String LIST_CT_SEC_LOAD_VER_TASK = Constant.CT_SEC_LOAD + "/listCtSecLoadChkTask.action?stationId=%1$d&itSetId=%2$d";
	
	/**
	 * 查询PT误差检定任务列表URL
	 */
	private static final String LIST_PT_ERROR_VER_TASK = Constant.PT_ERROR_VER + "/listPtCheckDataTask.action?stationId=%1$d&itSetId=%2$d";
	
	/**
	 * 查询PT二次负荷检定任务列表URL
	 */
	private static final String LIST_PT_SEC_LOAD_VER_TASK = Constant.PT_SEC_LOAD + "/listPtSecLoadChkTask.action?stationId=%1$d&itSetId=%2$d";
	
	/**
	 * 查询PT二次压降检定任务列表URL
	 */
	private static final String LIST_PT_SEC_VOL_VER_TASK = Constant.PT_SEC_VOL + "/queryPTSecondVolVerificationTask.action?stationId=%1$d&measurePointId=%2$d";
	
	/**
	 * 新增电能表误差检定任务URL
	 */
	private static final String ADD_METER_ERROR_VER_TASK = Constant.METER_ERROR + "/createDmeterChkDataTask.action";
	
	/**
	 * 新增CT误差检定任务URL
	 */
	private static final String ADD_CT_ERROR_VER_TASK = Constant.CT_ERROR_VER + "/addCTErrorVerificationTask.action";
	
	/**
	 * 新增CT二次负荷检定任务URL
	 */
	private static final String ADD_CT_SEC_LOAD_VER_TASK = Constant.CT_SEC_LOAD + "/addCtSecLoadChkTask.action";
	
	/**
	 * 新增PT误差检定任务URL
	 */
	private static final String ADD_PT_ERROR_VER_TASK = Constant.PT_ERROR_VER + "/addPtChkDataTask.action";
	
	/**
	 * 新增PT二次负荷检定任务URL
	 */
	private static final String ADD_PT_SEC_LOAD_VER_TASK = Constant.PT_SEC_LOAD + "/addPtSecLoadChkTask.action";
	
	/**
	 * 新增PT二次压降检定任务URL
	 */
	private static final String ADD_PT_SEC_VOL_VER_TASK = Constant.PT_SEC_VOL + "/addPTSecondVolVerificationTask.action";
	
	/**
	 * 删除电能表误差检定URL
	 */
	private static final String DELETE_METER_ERROR_VER_TASK = Constant.METER_ERROR + "/removeDmeterChkDataTask.action?periodId=%1$d";
	
	/**
	 * 删除CT误差检定任务URL
	 */
	private static final String DELETE_CT_ERROR_VER_TASK = Constant.CT_ERROR_VER + "/delCTErrorVerificationTask.action?periodId=%1$d";
	
	/**
	 * 删除CT二次负荷检定任务URL
	 */
	private static final String DELETE_CT_SEC_LOAD_VER_TASK = Constant.CT_SEC_LOAD + "/delCtSecLoadChkTask.action?periodId=%1$d";
	
	/**
	 * 删除PT误差检定任务URL
	 */
	private static final String DELETE_PT_ERROR_VER_TASK = Constant.PT_ERROR_VER + "/delPtChkTask.action?periodId=%1$d";
	
	/**
	 * 删除PT二次负荷检定任务URL
	 */
	private static final String DELETE_PT_SEC_LOAD_VER_TASK = Constant.PT_SEC_LOAD + "/delPtSecLoadChkTask.action?periodId=%1$d";
	
	/**
	 * 删除PT二次压降检定任务URL
	 */
	private static final String DELETE_PT_SEC_VOL_VER_TASK = Constant.PT_SEC_VOL + "/delPTSecondVolVerificationTask.action?periodId=%1$d";
}