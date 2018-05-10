package com.frontier.mobile.gkjd.webservice.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.frontier.mobile.gkjd.service.VerificationTaskService;
import com.frontier.mobile.gkjd.webservice.bean.GkjdResponseEntity;
import com.google.gson.internal.LinkedTreeMap;

/**
 * 检定任务控制类
 * 
 * @author 纪云行
 */
@Controller
public class VerificationTaskControl  extends ControlSupport {
	/**
	 * 检定任务服务接口
	 */
	@Autowired
	private VerificationTaskService verificationTaskService;
	
	/**
	 * 查询检定任务
	 * 
	 * @param jsonMap 参数map
	 * @return 关口检定响应实体（包含检定任务列表JSON字符串）
	 */
	public GkjdResponseEntity listVerificationTask(LinkedTreeMap<String, String> jsonMap) {
		long stationId = Long.valueOf(jsonMap.get("stationId"));
		long primaryId = Long.valueOf(jsonMap.get("primaryId"));
		int moduleType = Integer.valueOf(jsonMap.get("moduleType"));
		return wrapReadOperResponse(verificationTaskService.listVerificationTask(stationId, primaryId, moduleType));
	}
	
	/**
	 * 新增检定任务
	 * 
	 * @param jsonMap 参数map
	 * @return 关口检定响应实体
	 */
	public GkjdResponseEntity addVerificationTask(LinkedTreeMap<String, String> jsonMap) {
		int moduleType = Integer.valueOf(jsonMap.get("moduleType"));
		// 手动将多余的key-value删除
		jsonMap.remove("moduleType");
		return wrapWriteOperResponse(verificationTaskService.addVerificationTask(jsonMap, moduleType));
	}
	
	/**
	 * 删除检定任务
	 * 
	 * @param jsonMap 参数map
	 * @return 关口检定响应实体
	 */
	public GkjdResponseEntity deleteVerificationTask(LinkedTreeMap<String, String> jsonMap) {
		long periodId = Long.valueOf(jsonMap.get("periodId"));
		int moduleType = Integer.valueOf(jsonMap.get("moduleType"));
		return wrapWriteOperResponse(verificationTaskService.deleteVerificationTask(periodId, moduleType));
	}
}