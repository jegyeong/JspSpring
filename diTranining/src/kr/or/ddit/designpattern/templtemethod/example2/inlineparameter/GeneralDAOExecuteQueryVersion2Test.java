package kr.or.ddit.designpattern.templtemethod.example2.inlineparameter;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProdVO;

public class GeneralDAOExecuteQueryVersion2Test {

	ExecuteQueryTemplateVersion2<ProdVO> prodDAO = new GeneralDAOExecuteQueryVersion2<>(ProdVO.class);
	ExecuteQueryTemplateVersion2<MemberVO> memberDAO = new GeneralDAOExecuteQueryVersion2<>(MemberVO.class);
	
	@Test
	public void testQueryForProdList() {
		System.err.println("================ queryForList with Prod ===============================");
		String query = "SELECT * FROM PROD WHERE PROD_LGU = #{prod_lgu}";
		List<ProdVO> list = prodDAO.queryForList(query, "P101");
		for(ProdVO member : list) {
			System.out.println(member);
		}
	}

	@Test
	public void testQueryForProd() {
		System.err.println("================ queryForObject with Prod ===============================");
		String query = "SELECT * FROM PROD WHERE PROD_ID = #{prod_id}";
		ProdVO obj = prodDAO.queryForObject(query, "P101000001");
		System.out.println(obj);
	}
	
	@Test
	public void testQueryForMemberList() {
		System.err.println("================ queryForList with Member ===============================");
		String query = "SELECT * FROM MEMBER WHERE MEM_ADD1 LIKE '%'||#{mem_add1}||'%' AND MEM_NAME LIKE '%'||#{mem_name}||'%' ";
		MemberVO search = new MemberVO();
		search.setMem_add1("대전");
		search.setMem_name("윤희");
		List<MemberVO> list = memberDAO.queryForList(query, search);
		for(MemberVO member : list) {
			System.out.println(member);
		}
	}

	@Test
	public void testQueryForMember() {
		System.err.println("================ queryForObject with Member ===============================");
		String query = "SELECT * FROM MEMBER WHERE MEM_ID = #{mem_id}";
		MemberVO obj = memberDAO.queryForObject(query, "a001");
		System.out.println(obj);
	}

}
