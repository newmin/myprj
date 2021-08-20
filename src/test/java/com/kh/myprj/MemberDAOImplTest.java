package com.kh.myprj;

import java.sql.Date;

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
	void findById() {

		log.info("findById:{}",dao.findById(1));
	}

	@Test
	@DisplayName("회원조회 by email")
	void findByEmail() {

		log.info("findById:{}",dao.findByEmail("zxc@zxc.com"));
	}	
}
