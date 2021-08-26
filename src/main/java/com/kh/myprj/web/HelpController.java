package com.kh.myprj.web;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.myprj.domain.member.svc.MemberSVC;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/help")
@AllArgsConstructor
public class HelpController {

	@Autowired
	private MemberSVC memberSVC;
	
	@GetMapping("/")
	public String help() {
		return "help/help";
	}
	//회원 아이디 찾기
	@GetMapping("/findId")
	public String findId() {
		return "help/findIdForm";
	}
	//회원 비밀번호 찾기
	@GetMapping("/findPw")
	public String findPw() {
		return "help/findPwForm";
	}
	
	@PostMapping("/findId")
	public String findId(String tel, Date birth) {
		String email = memberSVC.findEmail(tel, birth);
		return email;
	}
	
}
