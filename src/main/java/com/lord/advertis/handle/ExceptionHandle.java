package com.lord.advertis.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lord.advertis.common.ResultAjax;
import com.lord.advertis.exception.AdvertisException;
import com.lord.advertis.utils.ResultUtil;

/**
 * 
 * @Description: 异常捕获
 * @author Lord
 * @date 2017年5月22日 下午5:42:15
 */
@ControllerAdvice
public class ExceptionHandle {
	
	private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class); 

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResultAjax<?> handle(Exception e){
		if(e instanceof AdvertisException){
			AdvertisException advertisException = (AdvertisException) e;
			return ResultUtil.error(advertisException.getCode(), advertisException.getMessage());
		}else{
			logger.error("【系统异常】 {}", e);
			return ResultUtil.error(-1, "未知错误");
		}
	}
}
