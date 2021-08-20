package com.kh.myprj.domain.member.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MemberDTO {

	private long id;        	//number(8),
	private String email;     //varchar2(40),
  private String pw;        //varchar2(10) CONSTRAINT member_pw_nn not NULL,
  private String tel;       //varchar2(13),
  private String nickname;  //varchar2(30),
  private String gender;    //char(3),
  private String region;    //varchar2(30),
  private String letter;    //char(1),
  private Date birth;  //date,
  private long fid;       //number(10),
  private LocalDateTime cdate;     //timestamp default systimestamp,
  private LocalDateTime udate;     //timestamp
}
