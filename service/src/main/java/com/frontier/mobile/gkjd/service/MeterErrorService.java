package com.frontier.mobile.gkjd.service;

import java.util.Map;

/**
 * 电能表误差服务接口
 * 
 * @author 纪云行
 */
public interface MeterErrorService {
	/**
	 * 查询检定数据
	 * 
	 * @param periodId 任务ID
	 * @param measurePointId 关口ID
	 * @return 检定数据JSON字符串
	 */
	String listVerificationData(Long periodId, Long measurePointId);

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
	 * @param meterId 电能表ID
	 * @param measurePointId 关口ID
	 * @param periodId 任务ID
	 * @return 删除成功或失败消息
	 */
	String deleteVerificationData(Long meterId, Long measurePointId, Long periodId);
}