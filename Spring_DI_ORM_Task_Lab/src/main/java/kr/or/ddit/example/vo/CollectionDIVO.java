package kr.or.ddit.example.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CollectionDIVO {
	private List<?> list;
	private Set<String> set;
	private Map<String, Date> map;
	private Properties props;
	
	private String[] array;
}
