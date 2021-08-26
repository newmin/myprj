package com.kh.myprj.domain.member.svc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.myprj.domain.member.dto.MemberDTO;
import com.kh.myprj.domain.member.svc.MemberSVC;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class MemberSVCImplTEST {

	@Autowired
	private MemberSVC mSVC;
	
	@Test
	@DisplayName("email중복체크")
	@Disabled
	void isExistEmail() {
		boolean result = mSVC.isExistEmail("user@test.com");
		Assertions.assertThat(result).isEqualTo(true);
		boolean result2 = mSVC.isExistEmail("test@test.com");
		Assertions.assertThat(result2).isEqualTo(false);
	}
	
	@Test
	@DisplayName("로그인체크")
	void isLogin() {
		MemberDTO mdto=mSVC.isLogin("user@test.com", "zxc12345");
		Assertions.assertThat(mdto.getEmail()).isEqualTo("user@test.com");
		
		MemberDTO mdto2=mSVC.isLogin("user@test.com", "zxc12345");
		log.info("mdto2:{}",mdto2);
		Assertions.assertThat(mdto.getEmail()).isEqualTo("user@test.com");
	}
	
	@Test
	@DisplayName("이메일로 회원정보 가져오기")
	void findByEmail() {
		MemberDTO mdto = mSVC.findByEmail("user@test.com");
		log.info("mdto:{}",mdto);
	}
	
}
