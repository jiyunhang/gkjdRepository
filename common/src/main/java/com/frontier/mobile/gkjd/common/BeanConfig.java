package com.frontier.mobile.gkjd.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.google.common.base.Strings;

import lombok.extern.slf4j.Slf4j;

/**
 * 读取关口检定类信息定义配置文件
 * 
 * @author 纪云行
 */
@Slf4j
public final class BeanConfig {
	/**
	 * 属性文件文件名
	 */
	private static final String FILE_NAME = "beanConfig.properties";
	
	/**
	 * 属性对象
	 */
	private static Properties pro;
	
	/**
	 * 确保自身不能被外部实例化
	 */
	private BeanConfig() {}
	
	/**
	 * 加载配置文件
	 */
	static {
		InputStream inputStream = null;
		pro = new Properties();
		try {
			inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(FILE_NAME);
			pro.load(inputStream);
		} catch (IOException e) {
			log.error("读取beanConfig.properties配置文件异常，异常信息{}", e.getMessage());
			System.exit(-1);
		} finally {
			if(Objects.nonNull(inputStream)) {
				try {
					inputStream.close();
				} catch (IOException e) {
					log.error("关闭输入流发生异常，异常信息{}", e.getMessage());
				}
			}
		}
	}
	
	/**
	 * 获取配置信息
	 * 
	 * @param key 名称
	 * @return 配置文件中名称对应的值
	 */
	public static String getString(String key) {
		return pro.getProperty(key);
	}
	
	/**
	 * 验证配置信息是否存在
	 * 
	 * @param key 名称
	 * @return 存在/不存在
	 */
	public static Boolean exist(String key) {
		return Strings.isNullOrEmpty(getString(key)) ? false : true;
	}
}