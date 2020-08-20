package kr.or.ddit.designpattern;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.designpattern.templtemethod.DeriviedClass1;
import kr.or.ddit.designpattern.templtemethod.DeriviedClass2;
import kr.or.ddit.designpattern.templtemethod.TemplateClass;

public class TemplateClassTest {

	@Test
	public void testTemplate() {
		TemplateClass templateClz = new DeriviedClass2();
		templateClz.template();
	}

}
