package kr.or.ddit.jdbc;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.MemberVO;

@Repository
public interface IMemberDAO {
	public MemberVO selectMember(String mem_id);
}
