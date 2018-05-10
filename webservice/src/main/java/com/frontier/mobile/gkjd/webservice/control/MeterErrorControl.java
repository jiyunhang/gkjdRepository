package com.frontier.mobile.gkjd.webservice.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.frontier.mobile.gkjd.service.MeterErrorService;
import com.frontier.mobile.gkjd.webservice.bean.GkjdResponseEntity;
import com.google.gson.internal.LinkedTreeMap;

/**
 * 电能表误差控制类
 * 
 * @author 纪云行
 */
@Controller
public class MeterErrorControl extends ControlSupport {
	/**
	 * 电能表误差服务接口
	 */
	@Autowired
	private MeterErrorService meterErrorService;
	
	/**
	 * 查询检定数据
	 * 
	 * @param map 参数map
	 * @return 关口检定响应实体（包含检定数据JSON字符串）
	 */
	public GkjdResponseEntity listVerificationData(LinkedTreeMap<String, String> map) {
		long periodId = Long.parseLong(map.get("periodId"));
		long measurePointId = Long.parseLong(map.get("measurePointId"));
		return wrapReadOperResponse(meterErrorService.listVerificationData(periodId, measurePointId));
	}

	/**
	 * 新增/修改检定数据
	 * 
	 * @param map 参数map
	 * @return 关口检定响应实体
	 */
	public GkjdResponseEntity addOrUpdateVerificationData(LinkedTreeMap<String, String> map) {
		return wrapWriteOperResponse(meterErrorService.addOrUpdateVerificationData(map));
	}

	/**
	 * 删除检定数据
	 * 
	 * @param map 参数map
	 * @return 关口检定响应实体
	 */
	public GkjdResponseEntity deleteVerificationData(LinkedTreeMap<String, String> map) {
		long meterId = Long.parseLong(map.get("meterId"));
		long measurePointId = Long.parseLong(map.get("measurePointId"));
		long periodId = Long.parseLong(map.get("periodId"));
		return wrapWriteOperResponse(meterErrorService.deleteVerificationData(meterId, measurePointId, periodId));
	}
}