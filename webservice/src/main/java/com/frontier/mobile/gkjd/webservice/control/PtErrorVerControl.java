package com.frontier.mobile.gkjd.webservice.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.frontier.mobile.gkjd.service.PtErrorVerService;
import com.frontier.mobile.gkjd.webservice.bean.GkjdResponseEntity;
import com.google.gson.internal.LinkedTreeMap;

/**
 * PT误差检定控制类
 * 
 * @author 纪云行
 */
@Controller
public class PtErrorVerControl extends ControlSupport {
	/**
	 * PT误差检定服务接口
	 */
	@Autowired
	private PtErrorVerService ptErrorVerService;
	
	/**
	 * 查询检定数据
	 * 
	 * @param map 参数map
	 * @return 关口检定响应实体（包含检定数据JSON字符串）
	 */
	public GkjdResponseEntity listVerificationData(LinkedTreeMap<String, String> map) {
		long periodId = Long.parseLong(map.get("periodId"));
		long ptSetId = Long.parseLong(map.get("ptSetId"));
		long stationId = Long.parseLong(map.get("stationId"));
		return wrapReadOperResponse(ptErrorVerService.listVerificationData(periodId, ptSetId, stationId));
	}

	/**
	 * 新增/修改检定数据
	 * 
	 * @param map 参数map
	 * @return 关口检定响应实体
	 */
	public GkjdResponseEntity addOrUpdateVerificationData(LinkedTreeMap<String, String> map) {
		return wrapWriteOperResponse(ptErrorVerService.addOrUpdateVerificationData(map));
	}

	/**
	 * 删除检定数据
	 * 
	 * @param map 参数map
	 * @return 关口检定响应实体
	 */
	public GkjdResponseEntity deleteVerificationData(LinkedTreeMap<String, String> map) {
		long periodId = Long.parseLong(map.get("periodId"));
		long ptSetId = Long.parseLong(map.get("ptSetId"));
		return wrapWriteOperResponse(ptErrorVerService.deleteVerificationData(periodId, ptSetId));
	}
}