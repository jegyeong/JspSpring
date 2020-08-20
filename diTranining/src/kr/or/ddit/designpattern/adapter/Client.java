package kr.or.ddit.designpattern.adapter;

public class Client {
	private Target target = new Adapter(new Adaptee());
	
	public static void main(String[] args) {
		new Client().target.request();
	}
}
