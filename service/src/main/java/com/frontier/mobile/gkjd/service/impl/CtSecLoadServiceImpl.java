package com.frontier.mobile.gkjd.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.frontier.mobile.gkjd.service.CtSecLoadService;
import com.frontier.mobile.gkjd.service.ServiceSupport;
import com.frontier.mobile.gkjd.service.constant.Constant;

/**
 * CT二次负荷服务类
 * 
 * @author 纪云行
 */
@Service
public class CtSecLoadServiceImpl extends ServiceSupport implements CtSecLoadService {
	/**
	 * 查询检定数据
	 * 
	 * @param periodId 检定任务ID
	 * @param itSetId 互感器装置ID
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
	 * @param itSetId 互感器装置ID
	 * @param measurePointId 计量点ID
	 * @return 删除成功或失败
	 */
	@Override
	public String deleteVerificationData(Long periodId, Long itSetId, Long measurePointId) {
		String url = String.format(DELETE_VERIFICATION_DATA, periodId, itSetId, measurePointId);
		return sendGetRequest(url);
	}
	
	/**
	 * 查询CT二次负荷检定数据URL
	 */
	private static final String LIST_VERIFICATION_DATA = Constant.CT_SEC_LOAD + "/viewCtSecLoadChkData.action?periodId=%1$d&itSetId=%2$d&stationId=%3$d";
	
	/**
	 * 新增/修改CT二次负荷检定数据URL
	 */
	private static final String ADD_OR_UPDATE_VERIFICATION_DATA = Constant.CT_SEC_LOAD + "/addOrEditCtSecLoadChkData.action";
	
	/**
	 * 删除CT二次负荷检定数据URL
	 */
	private static final String DELETE_VERIFICATION_DATA = Constant.CT_SEC_LOAD + "/delCtSecLoadChkData.action?periodId=%1$d&itSetId=%2$d&measurePointId=%3$d";
}