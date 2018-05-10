package com.frontier.mobile.gkjd.webservice.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.frontier.mobile.gkjd.service.PtSecLoadService;
import com.frontier.mobile.gkjd.webservice.bean.GkjdResponseEntity;
import com.google.gson.internal.LinkedTreeMap;

/**
 * PT二次负荷控制类
 * 
 * @author 纪云行
 */
@Controller
public class PtSecLoadControl extends ControlSupport {
	/**
	 * PT二次负荷服务接口
	 */
	@Autowired
	private PtSecLoadService ptSecLoadService;
	
	/**
	 * 查询检定数据
	 * 
	 * @param map 参数map
	 * @return 关口检定响应实体（包含检定数据JSON字符串）
	 */
	public GkjdResponseEntity listVerificationData(LinkedTreeMap<String, String> map) {
		long periodId = Long.parseLong(map.get("periodId"));
		long itSetId = Long.parseLong(map.get("itSetId"));
		long stationId = Long.parseLong(map.get("stationId"));
		return wrapReadOperResponse(ptSecLoadService.listVerificationData(periodId, itSetId, stationId));
	}

	/**
	 * 新增/修改检定数据
	 * 
	 * @param map 参数map
	 * @return 关口检定响应实体
	 */
	public GkjdResponseEntity addOrUpdateVerificationData(LinkedTreeMap<String, String> map) {
		return wrapWriteOperResponse(ptSecLoadService.addOrUpdateVerificationData(map));
	}

	/**
	 * 删除检定数据
	 * 
	 * @param map 参数map
	 * @return 关口检定响应实体
	 */
	public GkjdResponseEntity deleteVerificationData(LinkedTreeMap<String, String> map) {
		long periodId = Long.parseLong(map.get("periodId"));
		long itSetId = Long.parseLong(map.get("itSetId"));
		long measurePointId = Long.parseLong(map.get("measurePointId"));
		long stationId = Long.parseLong(map.get("stationId"));
		return wrapWriteOperResponse(ptSecLoadService.deleteVerificationData(periodId, itSetId, measurePointId, stationId));
	}
}