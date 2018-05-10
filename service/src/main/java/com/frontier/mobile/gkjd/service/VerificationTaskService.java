package com.frontier.mobile.gkjd.service;

import java.util.Map;

/**
 * 检定任务服务接口
 * 
 * @author 纪云行
 */
public interface VerificationTaskService {
	/**
	 * 查询检定任务
	 * 
	 * @param stationId 电站ID
	 * @param primaryId 关口ID/设备ID
	 * @param moduleType 类型（电能表误差、CT误差、CT二次负荷、PT误差、PT二次负荷、PT二次压降）
	 * @return 检定任务列表JSON字符串
	 */
	String listVerificationTask(Long stationId, Long primaryId, Integer moduleType);
	
	/**
	 * 新增检定任务
	 * 
	 * @param verTaskMap 检定任务map
	 * @param moduleType 类型（电能表误差、CT误差、CT二次负荷、PT误差、PT二次负荷、PT二次压降）
	 * @return 新增检定任务成功或失败
	 */
	String addVerificationTask(Map<String, String> verTaskMap, Integer moduleType);
	
	/**
	 * 删除检定任务
	 * 
	 * @param periodId 检定任务ID
	 * @param moduleType 类型（电能表误差、CT误差、CT二次负荷、PT误差、PT二次负荷、PT二次压降）
	 * @return 删除检定任务成功或失败
	 */
	String deleteVerificationTask(Long periodId, Integer moduleType);
}