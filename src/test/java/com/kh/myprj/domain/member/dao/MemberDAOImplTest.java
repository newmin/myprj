package com.kh.myprj.domain.member.dao;

import java.sql.Date;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.myprj.domain.member.dao.MemberDAO;
import com.kh.myprj.domain.member.dto.MemberDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class MemberDAOImplTest {

	@Autowired
	private MemberDAO dao;
	
	@Test
	@DisplayName("가입")
	@Disabled
	void isert() {
		MemberDTO dto = new MemberDTO();
//		pstmt.setString(1, memberDTO.getEmail());
//		pstmt.setString(2, memberDTO.getPw());
//		pstmt.setString(3, memberDTO.getTel());
//		pstmt.setString(4, memberDTO.getNickname());
//		pstmt.setString(5, memberDTO.getGender());
//		pstmt.setString(6, memberDTO.getRegion());
//		pstmt.setDate(7, memberDTO.getBirth());
//		pstmt.setString(8, memberDTO.getLetter());
		dto.setEmail("zxc@zxc.com");
		dto.setPw("zxczxc");
		dto.setTel("0667005454");
		dto.setNickname("ㅋㅌㅊ");
		dto.setGender("여");
		dto.setRegion("부산");
		dto.setBirth(Date.valueOf("2020-02-20"));
		dto.setLetter("0");
		
		log.info("member_id:{}",dao.insert(dto));
		
	}
	
	@Test
	@DisplayName("회원조회 by id")
	@Disabled
	void findById() {

		log.info("findById:{}",dao.findByID(1));
	}

	@Test
	@DisplayName("회원조회 by email")
	@Disabled
	void findByEmail() {

		log.info("findById:{}",dao.findByEmail("user@test.com"));
	}
	
	@Test
	@DisplayName("이메일찾기")
	void findEmail() {
		MemberDTO mdto = dao.findByEmail("user@test.com");
		String findedEmail = dao.findEmail(mdto.getTel(), mdto.getBirth());
		log.info("findEmail"+findedEmail);
		Assertions.assertThat(findedEmail).isEqualTo(mdto.getEmail());
	}
	
	@Test
	@DisplayName("비밀번호찾기")
	void findPw() {
		MemberDTO mdto = dao.findByEmail("user@test.com");
		String findedPw = dao.findPw(mdto.getEmail(),mdto.getTel(), mdto.getBirth());
		log.info("findPW:"+findedPw);
		Assertions.assertThat(findedPw).isEqualTo(mdto.getPw());
	}
	
	
}
