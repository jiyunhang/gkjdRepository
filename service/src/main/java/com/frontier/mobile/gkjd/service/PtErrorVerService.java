package com.frontier.mobile.gkjd.service;

import java.util.Map;

/**
 * PT误差检定服务接口
 * 
 * @author 纪云行
 */
public interface PtErrorVerService {
	/**
	 * 查询检定数据
	 * 
	 * @param periodId 检定任务ID
	 * @param ptSetId PT互感器装置ID
	 * @param stationId 厂站ID
	 * @return 检定数据
	 */
	String listVerificationData(Long periodId, Long ptSetId, Long stationId);
	
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
	 * @param ptSetId PT互感器装置ID
	 * @return 删除成功或失败消息
	 */
	String deleteVerificationData(Long periodId, Long ptSetId);
}