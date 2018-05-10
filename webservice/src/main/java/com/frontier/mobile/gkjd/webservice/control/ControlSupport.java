package com.frontier.mobile.gkjd.webservice.control;

import com.frontier.mobile.gkjd.common.GsonUtil;
import com.frontier.mobile.gkjd.common.Objects;
import com.frontier.mobile.gkjd.webservice.bean.GkjdResponseEntity;
import com.frontier.mobile.gkjd.webservice.bean.RespEntity;
import com.frontier.mobile.gkjd.webservice.util.GkjdResponseEntityUtil;

/**
 * 关口检定控制支持类
 * 
 * @author 纪云行
 */
public class ControlSupport {
	/**
	 * 包装读操作并返回关口检定响应实体 
	 * 
	 * @param message 待转换的消息
	 * @return 关口检定响应实体
	 */
	protected GkjdResponseEntity wrapReadOperResponse(String message) {
		return GkjdResponseEntityUtil.wrapSuccessResp(message);
	}
	
	/**
	 * 包装写操作并返回关口检定响应实体
	 *  
	 * @param message 待转换的消息
	 * @return 关口检定响应实体
	 */
	protected GkjdResponseEntity wrapWriteOperResponse(String message) {
		RespEntity respEntity = GsonUtil.fromJson(message, RespEntity.class);
		if (respEntity.getSuccess()) {
			if (Objects.isNull(respEntity.getData())) {
				return GkjdResponseEntityUtil.wrapSuccessResp(null);
			}
			return GkjdResponseEntityUtil.wrapSuccessResp(GsonUtil.toJsonString(respEntity.getData()));
		} else {
			return GkjdResponseEntityUtil.wrapFailResp(respEntity.getErrorMessage());
		}
	}
}