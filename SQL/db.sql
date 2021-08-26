drop table code;
create table code(
  code VARCHAR2(11),      --코드
  decode varchar2(30),      --코드명
  descript clob,         --코드설명
  pcode varchar2(11),      --상위코드
  use_yn char(1),         --사용여부
  cdate timestamp default systimestamp,
  udate timestamp,
  constraint code_code_pk primary key(code),
  constraint code_pcode_fk foreign key(code) references code,
  constraint code_decode_uk unique (decode),
  constraint code_use_yn_ck check(use_yn in('Y','N'))
);

insert into code(code,decode,pcode,use_yn) values ('A01','취미',NULL,'Y'); 
insert into code(code,decode,pcode,use_yn) values ('A02','성별',NULL,'Y');
insert into code(code,decode,pcode,use_yn) values ('A03','지역',NULL,'Y');
insert into code(code,decode,pcode,use_yn) values ('A04','첨부파일',NULL,'Y');
insert into code(code,decode,pcode,use_yn) values ('A0101','수영','A01','Y');
insert into code(code,decode,pcode,use_yn) values ('A0102','골프','A01','Y');
insert into code(code,decode,pcode,use_yn) values ('A0103','영화','A01','Y');
insert into code(code,decode,pcode,use_yn) values ('A0201','남','A02','Y');
insert into code(code,decode,pcode,use_yn) values ('A0202','여','A02','Y');
insert into code(code,decode,pcode,use_yn) values ('A0301','서울','A03','Y');
insert into code(code,decode,pcode,use_yn) values ('A0302','부산','A03','Y');
insert into code(code,decode,pcode,use_yn) values ('A0303','울산','A03','Y');
insert into code(code,decode,pcode,use_yn) values ('A0401','회원이미지','A03','Y');
insert into code(code,decode,pcode,use_yn) values ('A0402','상품이미지','A03','Y');

select * from code;