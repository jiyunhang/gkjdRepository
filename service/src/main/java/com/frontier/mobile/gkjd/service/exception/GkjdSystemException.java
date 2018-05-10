package com.frontier.mobile.gkjd.service.exception;

/**
 * 关口检定自定义系统异常
 * 
 * @author 纪云行
 */
public class GkjdSystemException extends RuntimeException {
	/**
	 * 序列化兼容 
	 */
	private static final long serialVersionUID = 1L;

	public GkjdSystemException() {
		super();
	}

	public GkjdSystemException(String message, Throwable cause) {
		super(message, cause);
	}

	public GkjdSystemException(String message) {
		super(message);
	}

	public GkjdSystemException(Throwable cause) {
		super(cause);
	}
}