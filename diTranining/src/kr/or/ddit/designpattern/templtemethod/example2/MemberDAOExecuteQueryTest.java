package kr.or.ddit.designpattern.templtemethod.example2;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.vo.MemberVO;

public class MemberDAOExecuteQueryTest {
	
	ExecuteQueryTemplate<MemberVO> template = new MemberDAOExecuteQuery();

	@Test
	public void testQueryForList() {
		String query = "SELECT * FROM MEMBER WHERE MEM_ADD1 LIKE '%'||?||'%' ";
		List<MemberVO> list = template.queryForList(query, new String[] {"대전"});
		for(MemberVO member : list) {
			System.out.println(member);
		}
	}

	@Test
	public void testQueryForObject() {
		String query = "SELECT * FROM MEMBER WHERE MEM_ID = ? ";
		MemberVO obj = template.queryForObject(query, new String[] {"a001"});
		System.out.println(obj);
	}

}






