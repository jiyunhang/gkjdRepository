package com.frontier.mobile.gkjd.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.frontier.mobile.gkjd.service.PtSecLoadService;
import com.frontier.mobile.gkjd.service.ServiceSupport;
import com.frontier.mobile.gkjd.service.constant.Constant;

/**
 * PT二次负荷服务类
 * 
 * @author 纪云行
 */
@Service
public class PtSecLoadServiceImpl extends ServiceSupport implements PtSecLoadService {
	/**
	 * 查询检定数据
	 * 
	 * @param periodId 检定任务ID
	 * @param itSetId 电压互感器装置ID
	 * @param stationId 厂站ID
	 * @return 检定数据
	 */
	@Override
	public String listVerificationData(Long periodId, Long itSetId, Long stationId) {
		String url = String.format(LIST_VERIFICATION_DATA, periodId, itSetId, stationId);
		return sendGetRequest(url);
	}
	
	/**
	 * 新增/修改检定数据
	 * 
	 * @param verificationDataMap 检定数据map
	 * @return 新增/修改成功或失败消息
	 */
	@Override
	public String addOrUpdateVerificationData(Map<String, String> verificationDataMap) {
		return sendPostRequest(verificationDataMap, ADD_OR_UPDATE_VERIFICATION_DATA);
	}
	
	/**
	 * 删除检定数据
	 * 
	 * @param periodId 检定任务ID
	 * @param itSetId 电压互感器装置ID
	 * @param measurePointId 计量点ID
	 * @param stationId 厂站ID
	 * @return 删除成功或失败信息
	 */
	@Override
	public String deleteVerificationData(Long periodId, Long itSetId, Long measurePointId, Long stationId) {
		String url = String.format(DELETE_VERIFICATION_DATA, periodId, itSetId, measurePointId, stationId);
		return sendGetRequest(url);
	}
	
	/**
	 * 查询PT二次负荷检定数据URL
	 */
	private static final String LIST_VERIFICATION_DATA = Constant.PT_SEC_LOAD + "/viewPtSecLoadChkData.action?periodId=%1$d&itSetId=%2$d&stationId=%3$d";
	
	/**
	 * 新增/修改PT二次负荷检定数据URL
	 */
	private static final String ADD_OR_UPDATE_VERIFICATION_DATA = Constant.PT_SEC_LOAD + "/addOrEditPtSecLoadChkData.action";
	
	/**
	 * 删除PT二次负荷检定数据URL
	 */
	private static final String DELETE_VERIFICATION_DATA = Constant.PT_SEC_LOAD + "/delPtSecLoadChkData.action?periodId=%1$d&itSetId=%2$d&measurePointId=%3$d&stationId=%4$d";
}