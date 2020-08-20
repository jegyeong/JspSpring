package kr.or.ddit;

import org.apache.commons.lang3.StringUtils;

public class HelloMaven {
	public void printHello() {
		if(StringUtils.isBlank("test")) {
			System.out.println("hello maven");
		}
	}
}
