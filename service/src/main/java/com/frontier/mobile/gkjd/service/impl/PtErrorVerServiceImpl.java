package com.frontier.mobile.gkjd.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.frontier.mobile.gkjd.service.PtErrorVerService;
import com.frontier.mobile.gkjd.service.ServiceSupport;
import com.frontier.mobile.gkjd.service.constant.Constant;

/**
 * PT误差检定服务类
 * 
 * @author 纪云行
 */
@Service
public class PtErrorVerServiceImpl extends ServiceSupport implements PtErrorVerService {
	/**
	 * 查询检定数据
	 * 
	 * @param periodId 检定任务ID
	 * @param ptSetId PT互感器装置ID
	 * @param stationId 厂站ID
	 * @return 检定数据
	 */
	@Override
	public String listVerificationData(Long periodId, Long ptSetId, Long stationId) {
		String url = String.format(LIST_VERIFICATION_DATA, periodId, ptSetId, stationId);
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
	 * @param ptSetId PT互感器装置ID
	 * @return 删除成功或失败消息
	 */
	@Override
	public String deleteVerificationData(Long periodId, Long ptSetId) {
		String url = String.format(DELETE_VERIFICATION_DATA, periodId, ptSetId);
		return sendGetRequest(url);
	}
	
	/**
	 * 查询PT误差检定检定数据URL
	 */
	private static final String LIST_VERIFICATION_DATA = Constant.PT_ERROR_VER + "/ptChkDataLoad.action?periodId=%1$d&ptSetId=%2$d&stationId=%3$d";
	
	/**
	 * 新增/修改PT误差检定检定数据URL
	 */
	private static final String ADD_OR_UPDATE_VERIFICATION_DATA = Constant.PT_ERROR_VER + "/addOrEditMPPTCheckData.action";
	
	/**
	 * 删除PT误差检定检定数据URL
	 */
	private static final String DELETE_VERIFICATION_DATA = Constant.PT_ERROR_VER + "/deleteMPPTCheckData.action?periodId=%1$d&ptSetId=%2$d";
}