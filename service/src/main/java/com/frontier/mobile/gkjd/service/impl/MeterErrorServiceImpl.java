package com.frontier.mobile.gkjd.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.frontier.mobile.gkjd.service.MeterErrorService;
import com.frontier.mobile.gkjd.service.ServiceSupport;
import com.frontier.mobile.gkjd.service.constant.Constant;

/**
 * 电能表误差服务类
 * 
 * @author 纪云行
 */
@Service
public class MeterErrorServiceImpl extends ServiceSupport implements MeterErrorService {
	/**
	 * 查询检定数据
	 * 
	 * @param periodId 任务ID
	 * @param measurePointId 关口ID
	 * @return 检定数据JSON字符串
	 */
	@Override
	public String listVerificationData(Long periodId, Long measurePointId) {
		String url = String.format(LIST_VERIFICATION_DATA, periodId, measurePointId);
		return sendGetRequest(url);
	}

	/**
	 * 新增/修改检定数据
	 * 
	 * @param verificationDataMap 检定数据map
	 * @return 新增/修改成功或失败消息
	 */
	@Override
	public String addOrUpdateVerificationData(Map<String, String> verificationDataMap) {
		return sendPostRequest(wrapKeyForMap(verificationDataMap, METER_ERROR_VER_DATA),
				ADD_OR_UPDATE_VERIFICATION_DATA);
	}

	/**
	 * 删除检定数据
	 * 
	 * @param meterId 电能表ID
	 * @param periodId 任务ID
	 * @param measurePointId 关口ID
	 * @return 删除成功或失败消息
	 */
	@Override
	public String deleteVerificationData(Long meterId, Long measurePointId, Long periodId) {
		String url = String.format(DELETE_VERIFICATION_DATA, meterId, measurePointId, periodId);
		return sendGetRequest(url);
	}
	
	/**
	 * 电能表误差检定数据
	 */
	private static final String METER_ERROR_VER_DATA = "mpMeterCheckData";

	/**
	 * 查询电能表误差检定数据URL
	 */
	private static final String LIST_VERIFICATION_DATA = Constant.METER_ERROR + "/queryMpMeterCheckData.action?periodId=%1$d&measurePointId=%2$d";

	/**
	 * 新增/修改电能表误差检定数据URL
	 */
	private static final String ADD_OR_UPDATE_VERIFICATION_DATA = Constant.METER_ERROR + "/addOrEditMpMeterCheckData.action";

	/**
	 * 删除电能表误差检定数据URL
	 */
	private static final String DELETE_VERIFICATION_DATA = Constant.METER_ERROR + "/removeMpMeterCheckData.action?meterId=%1$d&measurePointId=%2$d&periodId=%3$d";
}