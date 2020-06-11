package com.hm.common.web;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hm.common.vo.JsonResult;

@RestControllerAdvice
public class GlobalExceptionHandler {
	/**
	 * @ExceptionHandler 注解描述的方法为一个
	 * 异常处理方法
	 * @param e
	 * @return
	 */
	@ExceptionHandler(RuntimeException.class)
	public JsonResult doHandlerRuntimeException(RuntimeException e){
		e.printStackTrace();
		return new JsonResult(e);
	}
}
