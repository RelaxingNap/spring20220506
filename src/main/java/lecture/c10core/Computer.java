package lecture.c10core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.ToString;

@ToString
@Component
public class Computer {
	
	@Autowired // 권장하지는 않지만 주입이 되어서 제대로 실행됨
	// reflection을 통해서 주입이 됨. 
	private SSD ssd;
	
}
