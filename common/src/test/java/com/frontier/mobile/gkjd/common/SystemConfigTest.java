package com.frontier.mobile.gkjd.common;

import org.junit.Test;

import com.frontier.mobile.gkjd.common.SystemConfig;

import lombok.extern.slf4j.Slf4j;

/**
 * 关口检定配置测试类
 * 
 * @author 纪云行
 */
@Slf4j
public class SystemConfigTest {
	/**
	 * 获取配置文件参数值
	 */
	@Test
	public void testGetString() {
		String url = SystemConfig.getString("gkjdUrl");
		log.info("获取配置信息：{}", url);
	}
	
	/**
	 * 判断参数是否存在
	 */
	@Test
	public void testExist() {
		boolean flag = SystemConfig.exist("test");
		log.info("配置信息是否存在：{}", flag);
	}
}