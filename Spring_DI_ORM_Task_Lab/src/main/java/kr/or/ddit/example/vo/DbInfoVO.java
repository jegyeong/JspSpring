package kr.or.ddit.example.vo;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class DbInfoVO {
	private String driverClassName;
	private String url;
	private String user;
	private String password;
}
