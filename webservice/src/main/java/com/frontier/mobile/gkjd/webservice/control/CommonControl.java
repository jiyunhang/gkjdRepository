package com.frontier.mobile.gkjd.webservice.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.frontier.mobile.gkjd.service.CommonService;
import com.frontier.mobile.gkjd.webservice.bean.GkjdResponseEntity;
import com.google.gson.internal.LinkedTreeMap;

/**
 * 公共服务控制类
 * 
 * @author 纪云行
 */
@Controller
public class CommonControl extends ControlSupport {
	/**
	 * 公共服务接口
	 */
	@Autowired
	private CommonService commonService;
	
	/**
	 * 查询所有统调电厂（包含节点）
	 * 
	 * @return 关口检定响应实体（包含统调电厂列表JSON字符串）
	 */
	public GkjdResponseEntity listTreeNode() {
		return wrapReadOperResponse(commonService.listTreeNode());
	}
	
	/**
	 * 查询测试单位
	 * 
	 * @return 关口检定响应实体（包含测试单位JSON字符串）
	 */
	public GkjdResponseEntity listSpecialOrg() {
		return wrapReadOperResponse(commonService.listSpecialOrg());
	}
	
	/**
	 * 查询检验员、核验员
	 * 
	 * @return 关口检定响应实体（包含检验员、核验员JSON字符串）
	 */
	public GkjdResponseEntity listCheckUser() {
		return wrapReadOperResponse(commonService.listCheckUser());
	}
	
	/**
	 * 查询设备信息
	 * 
	 * @return 关口检定响应实体（包含设备信息JSON字符串）
	 */
	public GkjdResponseEntity listCriterionDevice() {
		return wrapReadOperResponse(commonService.listCriterionDevice());
	}
	
	/**
	 * 查询关口列表
	 * 
	 * @param jsonMap 参数map
	 * @return 关口检定响应实体（包含关口列表JSON字符串）
	 */
	public GkjdResponseEntity listStationMp(LinkedTreeMap<String, String> jsonMap) {
		long stationId = Long.valueOf(jsonMap.get("stationId"));
		String itSetType = jsonMap.get("itSetType");
		int moduleType = Integer.valueOf(jsonMap.get("moduleType"));
		return wrapReadOperResponse(commonService.listStationMp(stationId, itSetType, moduleType));
	}
}