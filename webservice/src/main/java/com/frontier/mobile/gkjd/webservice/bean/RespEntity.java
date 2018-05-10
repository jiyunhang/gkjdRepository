package com.frontier.mobile.gkjd.webservice.bean;

import java.util.Map;

import lombok.Data;

/**
 * 后台处理操作返回信息对应响应实体
 * 
 * @author 纪云行
 */
@Data
public class RespEntity {
	/**
	 * 成功或失败标识
	 */
	private Boolean success;
	/**
	 * 失败错误消息
	 */
	private String errorMessage;
	/**
	 * 成功返回的数据
	 */
	private Map<String, String> data;
}