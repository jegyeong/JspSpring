package kr.or.ddit.example.vo;

import org.springframework.beans.factory.FactoryBean;

public class StringArrayFactoryBean implements FactoryBean<String[]>{

	@Override
	public String[] getObject() throws Exception {
		return new String[] {"value1", "value2"};
	}

	@Override
	public Class<?> getObjectType() {
		return String[].class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}









