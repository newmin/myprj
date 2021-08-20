package com.kh.myprj.domain.member.dao;

import com.kh.myprj.domain.member.dto.MemberDTO;

public interface MemberDAO {

	/**
	 * 가입
	 * @param memberDTO
	 * @return
	 */
	long insert(MemberDTO memberDTO);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	MemberDTO findById(long id);
	
	/**
	 * 
	 * @param email
	 * @return
	 */
	MemberDTO findByEmail(String email);
}
