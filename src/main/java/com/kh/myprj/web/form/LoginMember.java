package com.kh.myprj.web.form;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginMember {
	private long id; 				//내부 관리용
	private String email;		//회원 아이디
	private String nickname;
	private String role;
}