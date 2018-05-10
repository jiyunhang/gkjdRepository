package com.frontier.mobile.gkjd.service;

import java.util.Map;

/**
 * CT误差检定服务接口
 * 
 * @author 纪云行
 */
public interface CtErrorVerService {
	/**
	 * 查询检定数据
	 * 
	 * @param periodId 任务ID
	 * @param itSetId 设备ID
	 * @return 检定数据JSON字符串
	 */
	String listVerificationData(Long periodId, Long itSetId);
	
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
	 * @param periodId 任务ID
	 * @param itSetId 设备ID
	 * @param itRatioId 变比ID
	 * @return 删除成功或失败消息
	 */
	String deleteVerificationData(Long periodId, Long itSetId, Long itRatioId);
}