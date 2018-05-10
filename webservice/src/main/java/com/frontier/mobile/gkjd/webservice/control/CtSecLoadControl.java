package com.frontier.mobile.gkjd.webservice.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.frontier.mobile.gkjd.service.CtSecLoadService;
import com.frontier.mobile.gkjd.webservice.bean.GkjdResponseEntity;
import com.google.gson.internal.LinkedTreeMap;

/**
 * CT二次负荷控制类
 * 
 * @author 纪云行
 */
@Controller
public class CtSecLoadControl extends ControlSupport {
	/**
	 * CT二次负荷服务接口
	 */
	@Autowired
	private CtSecLoadService ctSecLoadService;
	
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
		return wrapReadOperResponse(ctSecLoadService.listVerificationData(periodId, itSetId, stationId));
	}

	/**
	 * 新增/修改检定数据
	 * 
	 * @param map 参数map
	 * @return 关口检定响应实体
	 */
	public GkjdResponseEntity addOrUpdateVerificationData(LinkedTreeMap<String, String> map) {
		return wrapWriteOperResponse(ctSecLoadService.addOrUpdateVerificationData(map));
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
		return wrapWriteOperResponse(ctSecLoadService.deleteVerificationData(periodId, itSetId, measurePointId));
	}
}