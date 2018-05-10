package com.frontier.mobile.gkjd.service.impl;

import org.springframework.stereotype.Service;

import com.frontier.mobile.gkjd.service.CommonService;
import com.frontier.mobile.gkjd.service.ServiceSupport;
import com.frontier.mobile.gkjd.service.constant.Constant;

/**
 * 公共服务类
 * 
 * @author 纪云行
 */
@Service
public class CommonServiceImpl extends ServiceSupport implements CommonService {
	/**
	 * 查询所有统调电厂
	 * 
	 * @return 统调电厂JSON字符串
	 */
	@Override
	public String listTreeNode() {
		return sendGetRequest(LIST_TREE_NODE);
	}
	
	/**
	 * 查询测试单位
	 * 
	 * @return 测试单位JSON字符串
	 */
	@Override
	public String listSpecialOrg() {
		return sendGetRequest(LIST_SPECIAL_ORG);
	}
	
	/**
	 * 查询检验员、核验员
	 * 
	 * @param specialOrgId 单位ID
	 * @return 检验员、核验员JSON字符串 
	 */
	@Override
	public String listCheckUser() {
		return sendGetRequest(LIST_CHECK_USER);
	}
	
	/**
	 * 查询设备信息
	 * 
	 * @param deviceNo 标准编号
	 * @return 设备信息JSON字符串
	 */
	@Override
	public String listCriterionDevice() {
		return sendGetRequest(LIST_CRITERION_DEVICE);
	}
	
	/**
	 * 查询关口列表
	 * 
	 * @param stationId 厂站ID
	 * @param itSetType 互感器装置类型
	 * @param moduleType 类型（电能表误差、CT误差、CT二次负荷、PT误差、PT二次负荷、PT二次压降）
	 * @return 关口列表JSON字符串
	 */
	@Override
	public String listStationMp(Long stationId, String itSetType, Integer moduleType) {
		String url = null;
		switch (moduleType) {
		case Constant.MOD_METER_ERROR:
			url = String.format(LIST_ME_STATION_MP, stationId);
			break;
		case Constant.MOD_CT_ERROR_VER:
			url = String.format(LIST_CTEV_STATION_MP, stationId);
			break;
		case Constant.MOD_CT_SEC_LOAD:
			url = String.format(LIST_CTSL_STATION_MP, stationId, Long.parseLong(itSetType));
			break;
		case Constant.MOD_PT_ERROR_VER:
			url = String.format(LIST_PTEV_STATION_MP, stationId);
			break;
		case Constant.MOD_PT_SEC_LOAD:
			url = String.format(LIST_PTSL_STATION_MP, stationId, Long.parseLong(itSetType));
			break;
		case Constant.MOD_PT_SEC_VOL:
			url = String.format(LIST_PTSV_STATION_MP, stationId);
			break;
		}
		return sendGetRequest(url);
	}
	
	/**
	 * 查询统调电厂URL
	 */
	private static final String LIST_TREE_NODE = Constant.COMMON_CHECK_DATA + "/findAllTreeNode.action";
	
	/**
	 * 查询测试单位URL
	 */
	private static final String LIST_SPECIAL_ORG = Constant.COMMON_CHECK_DATA + "/querySpecialOrgs.action";
	
	/**
	 * 查询检验员、核验员URL
	 */
	private static final String LIST_CHECK_USER = Constant.COMMON_CHECK_DATA + "/queryCheckUsers.action";
	
	/**
	 * 查询设备信息URL
	 */
	private static final String LIST_CRITERION_DEVICE = Constant.COMMON_CHECK_DATA + "/queryCriterionDeviceByDeviceNo.action";
	
	/**
	 * 查询电能表误差关口列表URL
	 */
	private static final String LIST_ME_STATION_MP = Constant.METER_ERROR + "/queryStationMpList.action?stationId=%1$d";
	
	/**
	 * 查询CT误差检定关口列表URL
	 */
	private static final String LIST_CTEV_STATION_MP = Constant.CT_ERROR_VER + "/queryCTErrorGateList.action?stationId=%1$d";
	
	/**
	 * 查询CT二次负荷关口列表URL
	 */
	private static final String LIST_CTSL_STATION_MP = Constant.CT_SEC_LOAD + "/searchStationMpItSetList.action?stationId=%1$d&itSetType=%2$d";
	
	/**
	 * 查询PT误差检定关口列表URL
	 */
	private static final String LIST_PTEV_STATION_MP = Constant.PT_ERROR_VER + "/findTvs.action?stationId=%1$d";
	
	/**
	 * 查询PT二次负荷关口列表URL
	 */
	private static final String LIST_PTSL_STATION_MP = Constant.PT_SEC_LOAD + "/searchStationMpItSetList.action?stationId=%1$d&itSetType=%2$d";
	
	/**
	 * 查询PT二次压降关口列表URL
	 */
	private static final String LIST_PTSV_STATION_MP = Constant.PT_SEC_VOL + "/searchStationMpItSetList.action?seatStationId=%1$d";
}