package lecture.c08core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component
public class Car {
	
	private Engine engine;
	
	@Autowired // 자동으로 bean에 주입
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void go() {
		engine.action();
	}
}
