package com.frontier.mobile.gkjd.webservice.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.frontier.mobile.gkjd.service.CtErrorVerService;
import com.frontier.mobile.gkjd.webservice.bean.GkjdResponseEntity;
import com.google.gson.internal.LinkedTreeMap;

/**
 * CT误差检定控制类
 * 
 * @author 纪云行
 */
@Controller
public class CtErrorVerControl extends ControlSupport {
	/**
	 * CT误差检定服务接口
	 */
	@Autowired
	private CtErrorVerService ctErrorVerService;
	
	/**
	 * 查询检定数据
	 * 
	 * @param map 参数map
	 * @return 关口检定响应实体（包含检定数据JSON字符串）
	 */
	public GkjdResponseEntity listVerificationData(LinkedTreeMap<String, String> map) {
		long periodId = Long.parseLong(map.get("periodId"));
		long itSetId = Long.parseLong(map.get("itSetId"));
		return wrapReadOperResponse(ctErrorVerService.listVerificationData(periodId, itSetId));
	}
	
	/**
	 * 新增/修改检定数据
	 * 
	 * @param map 参数map
	 * @return 关口检定响应实体
	 */
	public GkjdResponseEntity addOrUpdateVerificationData(LinkedTreeMap<String, String> map) {
		return wrapWriteOperResponse(ctErrorVerService.addOrUpdateVerificationData(map));
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
		long itRatioId = Long.parseLong(map.get("itRatioId"));
		return wrapWriteOperResponse(ctErrorVerService.deleteVerificationData(periodId, itSetId, itRatioId));
	}
}