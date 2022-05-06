package lecture.c08core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.ToString;

@Component
@ToString
public class Computer {
	
	@Setter(onMethod_ = {@Autowired}) // 여러개의 어노테이션을 붙일때 사용
									  // {} 사용해서 배열형식으로 어노테이션 여러개 붙이는거 가능	
	private Memory memory;

//	@Autowired
//	public void setMemory(Memory memory) {
//		this.memory = memory;
//	}
	
	
}
