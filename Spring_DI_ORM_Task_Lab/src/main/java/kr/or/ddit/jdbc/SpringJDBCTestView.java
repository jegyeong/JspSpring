package kr.or.ddit.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import kr.or.ddit.vo.MemberVO;

public class SpringJDBCTestView {
	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				new ClassPathXmlApplicationContext("kr/or/ddit/jdbc/conf/datasource-context.xml");
		context.registerShutdownHook();
		
		DataSource ds = context.getBean(DataSource.class);
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		NamedParameterJdbcTemplate namedTemplate = context.getBean(NamedParameterJdbcTemplate.class);
		String sql = " SELECT * FROM MEMBER ";
		List<MemberVO> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<MemberVO>(MemberVO.class));
		System.out.println(list);
		sql = "SELECT * FROM MEMBER WHERE MEM_ID = ? AND MEM_NAME LIKE ('%'|| ? ||'%')";
		list = jdbcTemplate.query(sql, new Object[] {"은대", "a001" }, new BeanPropertyRowMapper<MemberVO>(MemberVO.class));
		System.out.println(list);
		sql = "SELECT * FROM MEMBER WHERE MEM_ID = :mem_id AND MEM_NAME LIKE ('%'|| :mem_name ||'%')";
		Map<String, Object> map = new HashMap<>();
		map.put("mem_id", "a001");
		map.put("mem_name", "은대");
		list = namedTemplate.query(sql, map, new BeanPropertyRowMapper<MemberVO>(MemberVO.class));
	}
}











