package kr.or.ddit.designpattern.adapter.example;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

@Component
public class AdapterPlug implements PluggableKST {

	private PluggableCN cnProduct;	
	
//	@Autowired
	@Inject
	public AdapterPlug(PluggableCN cnProduct) {
		super();
		this.cnProduct = cnProduct;
	}

	@Override
	public void receiveElectricWithTwoLeg() {
		cnProduct.receiveElectricWithThreeLeg();
	}

}
