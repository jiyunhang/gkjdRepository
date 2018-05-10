package com.frontier.mobile.gkjd.service;

import java.util.Map;

/**
 * PT二次负荷服务接口
 * 
 * @author 纪云行
 */
public interface PtSecLoadService {
	/**
	 * 查询检定数据
	 * 
	 * @param periodId 检定任务ID
	 * @param itSetId 电压互感器装置ID
	 * @param stationId 厂站ID
	 * @return 检定数据
	 */
	String listVerificationData(Long periodId, Long itSetId, Long stationId);
	
	/**
	 * 新增/修改检定数据
	 * 
	 * @param verificationDataMap 检定数据map
	 * @return 新增/修改成功或失败消息
	 */
	String addOrUpdateVerificationData(Map<String, String> verificationDataMap);
	
	/**
	 * 删除检定数据
	 * 
	 * @param periodId 检定任务ID
	 * @param itSetId 电压互感器装置ID
	 * @param measurePointId 计量点ID
	 * @param stationId 厂站ID
	 * @return 删除成功或失败信息
	 */
	String deleteVerificationData(Long periodId, Long itSetId, Long measurePointId, Long stationId);
}