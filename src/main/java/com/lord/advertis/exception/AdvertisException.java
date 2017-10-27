package com.lord.advertis.exception;

import com.lord.advertis.enums.ResultEnum;

/**
 * 
 * @Description: 自定义运行时异常类
 * @author Lord
 * @date 2017年5月22日 下午5:36:11
 */
public class AdvertisException extends RuntimeException{
	
	private static final long serialVersionUID = -1810837745386456279L;
	
	private Integer code;

	public AdvertisException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
		this.code = resultEnum.getCode();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
}
