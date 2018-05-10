package com.frontier.mobile.gkjd.common;

import java.util.Map;

import org.junit.Test;

import com.frontier.mobile.gkjd.common.GsonUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 工具类测试
 * 
 * @author 纪云行
 */
@Slf4j
public class GsonUtilTest {
	/*
	 * JSON字符串转MAP
	 */
	@Test
	public void testJsonToMap() {
		Map<String, String> map = GsonUtil.jsonToMap("{name:zhangsan,age:18}");
		log.info("反序列到map：{}", map);
	}
}