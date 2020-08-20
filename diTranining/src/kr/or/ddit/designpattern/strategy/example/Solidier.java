package kr.or.ddit.designpattern.strategy.example;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import kr.or.ddit.designpattern.adapter.example.XiaomiProduct;

@Component
public class Solidier {
	private XiaomiProduct xiaomi;
	@Inject
	public void setXiaomi(XiaomiProduct xiaomi) {
		this.xiaomi = xiaomi;
	}
	public XiaomiProduct getXiaomi() {
		return xiaomi;
	}
	
	@PostConstruct
	public void init() {
		System.out.println(" 객체 생성 ");
	}
	@PreDestroy
	public void destroy() {
		System.out.println(" 객체 소멸 ");
	}
	
	private Gun gun;
	
//	@Inject
	@Resource(name="biBitan")
	public void armedWithGun(Gun gun){
		this.gun = gun;
	}
	public void attack() {
		gun.shot();
	}
}











