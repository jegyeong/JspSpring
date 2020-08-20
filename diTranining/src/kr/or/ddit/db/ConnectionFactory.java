package kr.or.ddit.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class ConnectionFactory {
	private static String url;
	private static String user;
	private static String password;
	private static DataSource ds;
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("kr.or.ddit.db.dbInfo");
		
//		try {
//			Class.forName(bundle.getString("driverClassName"));
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException(e);
//		}
		// 전혀 수정할 필요가 없는 코드와 수정 발생 가능 코드가 섞여있다면, 분리해야함.
		url = bundle.getString("url").trim();
		user = bundle.getString("user").trim();
		password = bundle.getString("password").trim();
		BasicDataSource ods = new BasicDataSource();
		ods.setDriverClassName(bundle.getString("driverClassName"));
		ods.setUrl(url);
		ods.setUsername(user);
		ods.setPassword(password);
		ods.setInitialSize(5);
		ods.setMaxActive(10);
		ods.setMaxWait(2000);
		ds = ods;
		
	}
	public static Connection getConnection() throws SQLException {
//		Connection conn = DriverManager.getConnection(url, user, password);
		return ds.getConnection();
	}
}








