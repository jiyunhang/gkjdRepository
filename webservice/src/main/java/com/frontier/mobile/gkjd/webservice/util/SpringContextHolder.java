package com.frontier.mobile.gkjd.webservice.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 获取spring容器
 * 
 * @author 纪云行
 */
public final class SpringContextHolder implements ApplicationContextAware {
	/**
	 * spring容器
	 */
	private static ApplicationContext context;
	
	/**
	 * 确保自身不能被外部实例化
	 */
	private SpringContextHolder() {}

	/**
	 * 容器设值
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		context = applicationContext;
	}

	/**
	 * 根据名称和class对象获取泛型实例
	 * 
	 * @param name 名称
	 * @param clazz class对象
	 * @return 泛型实例
	 */
	public static <T> T getBean(String name, Class<T> clazz) {
		return context.getBean(name, clazz);
	}

	/**
	 * 根据class对象获取泛型实例
	 * 
	 * @param clazz class对象
	 * @return 泛型实例
	 */
	public static <T> T getBean(Class<T> clazz) {
		return context.getBean(clazz);
	}
}