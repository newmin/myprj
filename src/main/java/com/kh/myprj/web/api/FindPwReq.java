package com.kh.myprj.web.api;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class FindPwReq {

	@NotNull
	@Email
	private String email;
	@NotNull
	@Size(max=13)
	private String tel;
	@NotNull
//	@Size(max=10)
	private Date birth;
}
