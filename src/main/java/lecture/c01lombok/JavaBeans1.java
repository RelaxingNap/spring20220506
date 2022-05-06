package lecture.c01lombok;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString // toString 재정의
public class JavaBeans1 {
	
	@Getter // get메소드 만들어짐
	@Setter // set메소드 만들어짐
	private String name;
	
	@Getter
	@Setter
	private int age;
	
}
