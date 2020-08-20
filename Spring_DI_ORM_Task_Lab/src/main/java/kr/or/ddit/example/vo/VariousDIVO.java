package kr.or.ddit.example.vo;

import java.io.File;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class VariousDIVO {
	private int number;
	private boolean booldata;
	private char ch;
	private String text;
	
	private File file;
	private Class<?> type;
}











