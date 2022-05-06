package lecture.c01lombok;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
// 클래스 전체에 적용시에는 JavaBeans클래스 위에 어노테이션 선언함
public class JavaBeans2 {
	private String model;
	private int id;
}
