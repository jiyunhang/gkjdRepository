package com.frontier.mobile.gkjd.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.frontier.mobile.gkjd.service.CtErrorVerService;
import com.frontier.mobile.gkjd.service.ServiceSupport;
import com.frontier.mobile.gkjd.service.constant.Constant;

/**
 * CT误差检定服务类
 * 
 * @author 纪云行
 */
@Service
public class CtErrorVerServiceImpl extends ServiceSupport implements CtErrorVerService {
	/**
	 * 查询检定数据
	 * 
	 * @param periodId 任务ID
	 * @param itSetId 设备ID
	 * @return 检定数据JSON字符串
	 */
	@Override
	public String listVerificationData(Long periodId, Long itSetId) {
		String url = String.format(LIST_VERIFICATION_DATA, periodId, itSetId);
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
	 * @param periodId 任务ID
	 * @param itSetId 设备ID
	 * @param itRatioId 变比ID
	 * @return 删除成功或失败消息
	 */
	@Override
	public String deleteVerificationData(Long periodId, Long itSetId, Long itRatioId) {
		String url = String.format(DELETE_VERIFICATION_DATA, periodId, itSetId, itRatioId);
		return sendGetRequest(url);
	}
	
	/**
	 * 查询CT误差检定检定数据URL
	 */
	private static final String LIST_VERIFICATION_DATA = Constant.CT_ERROR_VER + "/queryCTErrorVerificationData.action?periodId=%1$d&itSetId=%2$d";
	
	/**
	 * 新增/修改CT误差检定检定数据URL
	 */
	private static final String ADD_OR_UPDATE_VERIFICATION_DATA = Constant.CT_ERROR_VER + "/addOrEditCTErrorVerificationData.action";
	
	/**
	 * 删除CT误差检定检定数据URL
	 */
	private static final String DELETE_VERIFICATION_DATA = Constant.CT_ERROR_VER + "/delCTErrorVerificationData.action?periodId=%1$d&itSetId=%2$d&itRatioId=%3$d";
}