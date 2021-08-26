package com.kh.myprj.domain.member.svc;

import java.sql.Date;

import com.kh.myprj.domain.member.dto.MemberDTO;

public interface MemberSVC {
	/**
	 * 가입
	 * @param memberDTO
	 * @return
	 */
	void join(MemberDTO memberDTO);
	/**
	 * 수정
	 * @param id
	 * @param memberDTO
	 */
	void update(long id, MemberDTO memberDTO);

/**
 * 이메일중복여부 체크
 * @param email
 * @return
 */
boolean isExistEmail(String email);

/**
 * 로그인 체크
 * @param email
 * @param pw
 * @return
 */
MemberDTO isLogin(String email,String pw);

/**
 * 회원 유무체크
 * @param email
 * @param pw
 * @return
 */
Boolean isMember(String email,String pw);

/**
 * 이메일찾기
 * @param tel
 * @param birth
 * @return
 */
String findEmail(String tel,Date birth);

/**
 * 비밀번호찾기
 * @param email
 * @param tel
 * @param birth
 * @return
 */
String findPw(String email, String tel, Date birth);

/**
 * 조회 by id
 * @param id
 * @return
 */
MemberDTO findByID(long id);

/**
 * 조회 by email
 * @param email
 * @return
 */
MemberDTO findByEmail(String email);

/**
 * 삭제
 * @param id
 */
void delete(long id);
/**
 * 삭제
 * @param email
 */
void delete(String email);

}