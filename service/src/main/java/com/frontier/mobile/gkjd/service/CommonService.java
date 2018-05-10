package com.frontier.mobile.gkjd.service;

/**
 * 公共服务接口
 * 
 * @author 纪云行
 */
public interface CommonService {
	/**
	 * 查询所有统调电厂
	 * 
	 * @return 统调电厂JSON字符串
	 */
	String listTreeNode();
	
	/**
	 * 查询测试单位
	 * 
	 * @return 测试单位JSON字符串
	 */
	String listSpecialOrg();
	
	/**
	 * 查询检验员、核验员
	 * 
	 * @return 检验员、核验员JSON字符串 
	 */
	String listCheckUser();
	
	/**
	 * 查询设备信息
	 * 
	 * @return 设备信息JSON字符串
	 */
	String listCriterionDevice();
	
	/**
	 * 查询关口列表
	 * 
	 * @param stationId 厂站ID
	 * @param itSetType 互感器装置类型
	 * @param moduleType 类型（电能表误差、CT误差、CT二次负荷、PT误差、PT二次负荷、PT二次压降）
	 * @return 关口列表JSON字符串
	 */
	String listStationMp(Long stationId, String itSetType, Integer moduleType);
}