package kr.or.ddit.designpattern.pooling;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;

import org.apache.commons.pool2.impl.GenericObjectPool;

public class TestMain {
	public static void main(String[] args) {
		ReaderUtilWithPooling util =
				new ReaderUtilWithPooling(new GenericObjectPool<StringBuffer>(new StringBufferFactory()));
		URL url = TestMain.class.getResource("anotherday.txt");
		File readFile = new File( url.getFile() );
		try(
				Reader in = new FileReader(readFile);
		){
			String text = util.readToString(in);
			System.out.println(text);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}








