package kr.or.ddit.designpattern.adapter.example.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy
@ComponentScan(basePackages = "kr.or.ddit.designpattern.adapter.example")
public class AdapterPatternContainerConfig {
//	@Bean
//	public SamsungProduct samsung() {
//		return new SamsungProduct();
//	}
//	@Bean("LG")
//	public LGProduct lg() {
//		return new LGProduct();
//	}
//	@Bean
//	public XiaomiProduct xiaomi1() {
//		return new XiaomiProduct();
//	}
//	@Bean
//	public XiaomiProduct xiaomi2() {
//		return new XiaomiProduct();
//	}
//	@Bean
//	@Lazy(false)
//	public AdapterPlug adapter(XiaomiProduct xiaomi2) {
//		return new AdapterPlug(xiaomi2);
//	}
//	@Bean
//	@Scope("prototype")
//	public ConcentKST concentKST() {
//		return new ConcentKST();
//	}
//	
//	@Bean
//	@Lazy(false)
//	public RoomKST room(ConcentKST concent) {
//		RoomKST room = new RoomKST();
//		room.setConcent(concent);
//		return room;
//	}
}








