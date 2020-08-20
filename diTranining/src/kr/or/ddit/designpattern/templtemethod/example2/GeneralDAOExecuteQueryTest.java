package kr.or.ddit.designpattern.templtemethod.example2;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProdVO;

public class GeneralDAOExecuteQueryTest {
	
	ExecuteQueryTemplate<ProdVO> prodDAO = new GeneralDAOExecuteQuery<>(ProdVO.class);
	ExecuteQueryTemplate<MemberVO> memberDAO = new GeneralDAOExecuteQuery<>(MemberVO.class);
	
	@Test
	public void testQueryForProdList() {
		System.err.println("================ queryForList with Prod ===============================");
		String query = "SELECT * FROM PROD WHERE PROD_LGU = ?";
		List<ProdVO> list = prodDAO.queryForList(query, new String[] {"P101"});
		for(ProdVO member : list) {
			System.out.println(member);
		}
	}

	@Test
	public void testQueryForProd() {
		System.err.println("================ queryForObject with Prod ===============================");
		String query = "SELECT * FROM PROD WHERE PROD_ID = ? ";
		ProdVO obj = prodDAO.queryForObject(query, new String[] {"P101000001"});
		System.out.println(obj);
	}
	
	@Test
	public void testQueryForMemberList() {
		System.err.println("================ queryForList with Member ===============================");
		String query = "SELECT * FROM MEMBER WHERE MEM_ADD1 LIKE '%'||?||'%' ";
		List<MemberVO> list = memberDAO.queryForList(query, new String[] {"대전"});
		for(MemberVO member : list) {
			System.out.println(member);
		}
	}

	@Test
	public void testQueryForMember() {
		System.err.println("================ queryForObject with Member ===============================");
		String query = "SELECT * FROM MEMBER WHERE MEM_ID = ? ";
		MemberVO obj = memberDAO.queryForObject(query, new String[] {"a001"});
		System.out.println(obj);
	}

}
