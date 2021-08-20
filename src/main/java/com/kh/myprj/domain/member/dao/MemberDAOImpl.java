package com.kh.myprj.domain.member.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.kh.myprj.domain.member.dto.MemberDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberDAOImpl implements MemberDAO {

	private final JdbcTemplate jt;
	
	@Override
	public long insert(MemberDTO memberDTO) {
		StringBuffer sql = new StringBuffer();
		
		sql.append("insert into member( ");
		sql.append("  id, ");
		sql.append("  email, ");
		sql.append("  pw, ");
		sql.append("  tel, ");
		sql.append("  nickname, ");
		sql.append("  gender, ");
		sql.append("  region, ");
		sql.append("  birth, ");
		sql.append("  letter)  ");
		sql.append("values(member_id_seq.nextval, ");
		sql.append("  ?, ");
		sql.append("  ?, ");
		sql.append("  ?, ");
		sql.append("  ?, ");
		sql.append("  ?, ");
		sql.append("  ?, ");
		sql.append("  ?, ");
		sql.append("  ?  ");
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jt.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql.toString(),new String[] {"id"});
				pstmt.setString(1, memberDTO.getEmail());
				pstmt.setString(2, memberDTO.getPw());
				pstmt.setString(3, memberDTO.getTel());
				pstmt.setString(4, memberDTO.getNickname());
				pstmt.setString(5, memberDTO.getGender());
				pstmt.setString(6, memberDTO.getRegion());
				pstmt.setDate(7, memberDTO.getBirth());
				pstmt.setString(8, memberDTO.getLetter());
				return pstmt;
			}
		},keyHolder);
		
		return (long)keyHolder.getKeyAs(BigDecimal.class).longValue();
	}

	@Override
	public MemberDTO findById(long id) {
		StringBuffer sql = new StringBuffer();
		
		sql.append("select ");
		sql.append("  id, ");
		sql.append("  email, ");
		sql.append("  pw, ");
		sql.append("  tel, ");
		sql.append("  nickname, ");
		sql.append("  gender, ");
		sql.append("  region, ");
		sql.append("  birth, ");
		sql.append("  letter,  ");
		sql.append("  fid,  ");
		sql.append("  cdate,  ");
		sql.append("  udate  ");
		sql.append("  from member  ");
		sql.append("  where id=?  ");
		
		MemberDTO memberDTO = jt.queryForObject(sql.toString(), 
																						new BeanPropertyRowMapper<>(MemberDTO.class),
																						id);
		return memberDTO;
	}

	@Override
	public MemberDTO findByEmail(String email) {
	StringBuffer sql = new StringBuffer();
		
		sql.append("select ");
		sql.append("  id, ");
		sql.append("  email, ");
		sql.append("  pw, ");
		sql.append("  tel, ");
		sql.append("  nickname, ");
		sql.append("  gender, ");
		sql.append("  region, ");
		sql.append("  birth, ");
		sql.append("  letter,  ");
		sql.append("  fid,  ");
		sql.append("  cdate,  ");
		sql.append("  udate  ");
		sql.append("  from member  ");
		sql.append("  where email=?  ");
		
		MemberDTO memberDTO = jt.queryForObject(sql.toString(), 
																						new BeanPropertyRowMapper<>(MemberDTO.class),
																						email);
		return memberDTO;
	}
}
