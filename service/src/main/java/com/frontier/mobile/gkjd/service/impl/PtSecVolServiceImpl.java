package com.frontier.mobile.gkjd.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.frontier.mobile.gkjd.service.PtSecVolService;
import com.frontier.mobile.gkjd.service.ServiceSupport;
import com.frontier.mobile.gkjd.service.constant.Constant;

/**
 * PT二次压降服务类
 * 
 * @author 纪云行
 */
@Service
public class PtSecVolServiceImpl extends ServiceSupport implements PtSecVolService {
	/**
	 * 查询检定数据
	 * 
	 * @param periodId 检定任务ID
	 * @param measurePointId 计量点ID
	 * @return 检定数据
	 */ 
	@Override
	public String listVerificationData(Long periodId, Long measurePointId) {
		String url = String.format(LIST_VERIFICATION_DATA, periodId, measurePointId);
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
	 * @param checkDate 测试日期
	 * @return 删除成功或失败信息
	 */
	@Override
	public String deleteVerificationData(Long periodId, Long itSetId, Long measurePointId, String checkDate) {
		String url = String.format(DELETE_VERIFICATION_DATA, periodId, itSetId, measurePointId, checkDate);
		return sendGetRequest(url);
	}
	
	/**
	 * 查询PT二次压降检定数据URL
	 */
	private static final String LIST_VERIFICATION_DATA = Constant.PT_SEC_VOL + "/queryPTSecondVolVerificationData.action?periodId=%1$d&measurePointId=%2$d";
	
	/**
	 * 新增/修改PT二次压降检定数据URL
	 */
	private static final String ADD_OR_UPDATE_VERIFICATION_DATA = Constant.PT_SEC_VOL + "/addOrEditPTSecondVolVerificationData.action";
	
	/**
	 * 删除PT二次压降检定数据URL
	 */
	private static final String DELETE_VERIFICATION_DATA = Constant.PT_SEC_VOL + "/delPTSecondVolVerificationData.action?periodId=%1$d&itSetId=%2$d&measurePointId=%3$d&checkDate=%4$s";
}