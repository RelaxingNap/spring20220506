package lecture.c09core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	private Wheel wheel;
	
	@Autowired
	public Car(Wheel wheel) {
		this.wheel = wheel;
	}
	// 생성자가 하나인 경우 @AutoWired생략가능(버전에따라 다름)
	
	
	
	public void go() {
		wheel.roll();
	}
}
