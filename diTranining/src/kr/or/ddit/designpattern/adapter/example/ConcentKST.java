package kr.or.ddit.designpattern.adapter.example;

import org.springframework.stereotype.Component;

@Component
public class ConcentKST {
	public void plugin(PluggableKST product) {
		product.receiveElectricWithTwoLeg();
	}
}
