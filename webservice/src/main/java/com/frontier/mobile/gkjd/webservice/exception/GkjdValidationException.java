package com.frontier.mobile.gkjd.webservice.exception;

/**
 * 关口检定自定义校验异常
 * 
 * @author 纪云行
 */
public class GkjdValidationException extends RuntimeException {
	/**
	 * 序列化兼容 
	 */
	private static final long serialVersionUID = 1L;

	public GkjdValidationException() {
		super();
	}

	public GkjdValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	public GkjdValidationException(String message) {
		super(message);
	}

	public GkjdValidationException(Throwable cause) {
		super(cause);
	}
}