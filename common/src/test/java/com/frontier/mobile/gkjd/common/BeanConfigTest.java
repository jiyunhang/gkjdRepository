package com.frontier.mobile.gkjd.common;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * 关口检定配置测试类
 * 
 * @author 纪云行
 */
@Slf4j
public class BeanConfigTest {
	/**
	 * 获取配置文件参数值
	 */
	@Test
	public void testGetString() {
		String beanInfo = BeanConfig.getString("0701");
		log.info("获取配置信息：{}", beanInfo);
	}
	
	/**
	 * 判断参数是否存在
	 */
	@Test
	public void testExist() {
		boolean flag = BeanConfig.exist("0701");
		log.info("配置信息是否存在：{}", flag);
	}
}