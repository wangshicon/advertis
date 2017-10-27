package com.lord.advertis.enums;

/**
 * 
 * @Description: 自定义异常枚举类
 * @author Lord
 * @date 2017年5月22日 下午5:33:36
 */
public enum ResultEnum {
	UNKNOW_ERROR(-1, "未知错误"),
	SUCCESS(0, "成功"),
	;
	
	private Integer code;
	
	private String msg;

	private ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
