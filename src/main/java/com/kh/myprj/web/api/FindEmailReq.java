package com.kh.myprj.web.api;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class FindEmailReq {

	@NotNull
	private String tel;
//	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull
//	@Size(max=10)
	private Date birth;
}
