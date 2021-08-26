package com.kh.myprj.web;

import javax.validation.Valid;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.myprj.domain.member.svc.MemberSVC;
import com.kh.myprj.web.api.FindEmailReq;
import com.kh.myprj.web.api.FindPwReq;
import com.kh.myprj.web.api.JsonResult;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Controller
@RestController
@RequestMapping("/api/members")
//@RequiredArgsConstructor
@AllArgsConstructor
public class APItMemberController {

	private final MemberSVC memberSVC;
	
	@GetMapping("/email")
//	@ResponseBody
	public JsonResult<String> findEmail(
			 @RequestBody FindEmailReq findEmailReq,
			BindingResult bindingResult) {
		
//		if(bindingResult.hasErrors()) {return new JsonResult<BindingResult>("01","Not OK",bindingResult);}		
		if(bindingResult.hasErrors()) {return null;}	
		
		String findedEmail = memberSVC.findEmail(findEmailReq.getTel(), findEmailReq.getBirth());
		
		JsonResult<String> result = null;
		
//		(findedEmail == null 
//				? result = new JsonResult<String>("00","OK",findedEmail) 
//				: result = new JsonResult<String>("00","OK",findedEmail);)
		
		return new JsonResult<String>("00","OK",findedEmail);
	}
	
	@GetMapping("/pw")
	public Object findPw(
		@Valid @RequestBody FindPwReq findPwReq,
		BindingResult bindingResult) {
	
	if(bindingResult.hasErrors()) {return bindingResult;}
	
	String findedPwReq = memberSVC.findPw(findPwReq.getEmail(),findPwReq.getTel(), findPwReq.getBirth());
	return new JsonResult<String>("00","OK",findedPwReq);
}
	
	
	
	
}
