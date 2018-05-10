package com.frontier.mobile.gkjd.common;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * JSON工具类
 * 
 * @author 纪云行
 */
public final class GsonUtil {
	/**
	 * 初始化
	 */
	private static Gson gson = new GsonBuilder().serializeNulls().create();
	
	/**
	 * 确保自身不能被外部实例化
	 */
	private GsonUtil() {}

	/**
	 * 序列化java对象到字符串
	 * 
	 * @param object java对象
	 * @return 标准JSON格式字符串
	 */
	public static <T> String toJsonString(T object) {
		return gson.toJson(object);
	}

	/**
	 * 反序列化字符串到java对象
	 * 
	 * @param jsonString 标准格式字符串
	 * @param clazz Class对象
	 * @return 泛型对应的java对象
	 */
    public static <T> T fromJson(String jsonString, Class<T> clazz) {
		return gson.fromJson(jsonString, clazz);
	}
	
	/**
	 * JSON转MAP
	 * @param jsonString 待转换的JSON字符串 
	 * @return 转换后的map
	 */
	public static Map<String, String> jsonToMap(String jsonString) {
		return gson.fromJson(jsonString, new TypeToken<Map<String, String>>() {
		}.getType());
	}
}