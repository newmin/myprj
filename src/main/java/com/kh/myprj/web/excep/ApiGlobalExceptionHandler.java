package com.kh.myprj.web.excep;

import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kh.myprj.web.api.JsonResult;

//모든 컨트롤러에서 예외처리에 대응 //모든 맞아?Rest면 Rest에만 반응하는건 아니지?
@RestControllerAdvice //ControllerAdvice + @ResposeBody
public class ApiGlobalExceptionHandler {

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public JsonResult<String> emptyJsonResult(EmptyResultDataAccessException ex){
		return  new JsonResult<String>("01","NOK","일치하는 정보가 없습니다.");
	}
	
}
