package com.frontier.mobile.gkjd.common;

/**
 * 对象工具类
 * 
 * @author 纪云行
 */
public final class Objects {
	/**
	 * 确保自身不能被外部实例化
	 */
	private Objects() {}
	
	/**
	 * 判断对象引用是否为空
	 * 
	 * @param obj 传入对象
	 * @return null返回true，否则返回false
	 */
	public static boolean isNull(Object obj) {
		return obj == null;
	}
	
	/**
	 * 判断对象引用是否不为空
	 * 
	 * @param obj 传入对象
	 * @return 非null返回true，否则返回false
	 */
	public static boolean nonNull(Object obj) {
		return obj != null;
	}
}