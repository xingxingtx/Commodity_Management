package com.wei.exceptions.globalexception.exception;

/**
 * 模拟400错误处理异常类
 * 
 * @author wei.peng
 * @date 2018年6月8日 上午9:27:29
 * @version V1.0
 * @since JDK ： 1.8
 */
public class BadRequestException extends Exception {
	  	
	private static final long serialVersionUID = -6091047030159094706L;

	public BadRequestException() {
		super();
	}

	public BadRequestException(String message) {
		super(message);
	}

}