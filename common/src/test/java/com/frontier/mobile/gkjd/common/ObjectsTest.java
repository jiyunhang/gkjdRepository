package com.frontier.mobile.gkjd.common;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * Object测试类
 * 
 * @author 纪云行
 */
@Slf4j
public class ObjectsTest {
	/**
	 * 测试对象为空
	 */
	@Test
	public void testIsNull() {
		Object obj = null;
		log.info("测试引用是否为null：{}", Objects.isNull(obj));
	}

	/**
	 * 测试对象不为空
	 */
	@Test
	public void testNonNull() {
		Object obj = new Object();
		log.info("测试引用是否不为null：{}", Objects.nonNull(obj));
	}
}