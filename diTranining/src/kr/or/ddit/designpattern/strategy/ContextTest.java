package kr.or.ddit.designpattern.strategy;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContextTest {

	@Test
	public void testOperation() {
		Sort strategy = new BubbleSort();
		Context ctx = new Context();
		ctx.setStrategy(strategy);
		ctx.operation();
	}

}
