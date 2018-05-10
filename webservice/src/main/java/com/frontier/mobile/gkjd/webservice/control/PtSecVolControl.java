package com.frontier.mobile.gkjd.webservice.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.frontier.mobile.gkjd.service.PtSecVolService;
import com.frontier.mobile.gkjd.webservice.bean.GkjdResponseEntity;
import com.google.gson.internal.LinkedTreeMap;

/**
 * PT二次压降控制类
 * 
 * @author 纪云行
 */
@Controller
public class PtSecVolControl extends ControlSupport {
	/**
	 * PT二次压降服务接口
	 */
	@Autowired
	private PtSecVolService ptSecVolService;
	
	/**
	 * 查询检定数据
	 * 
	 * @param map 参数map
	 * @return 关口检定响应实体（包含检定数据JSON字符串）
	 */
	public GkjdResponseEntity listVerificationData(LinkedTreeMap<String, String> map) {
		long periodId = Long.parseLong(map.get("periodId"));
		long measurePointId = Long.parseLong(map.get("measurePointId"));
		return wrapReadOperResponse(ptSecVolService.listVerificationData(periodId, measurePointId));
	}

	/**
	 * 新增/修改检定数据
	 * 
	 * @param map 参数map
	 * @return 关口检定响应实体
	 */
	public GkjdResponseEntity addOrUpdateVerificationData(LinkedTreeMap<String, String> map) {
		return wrapWriteOperResponse(ptSecVolService.addOrUpdateVerificationData(map));
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
		String checkDate = map.get("checkDate");
		return wrapWriteOperResponse(ptSecVolService.deleteVerificationData(periodId, itSetId, measurePointId, checkDate));
	}
}