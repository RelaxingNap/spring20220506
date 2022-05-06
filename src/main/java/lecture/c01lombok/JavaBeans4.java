package lecture.c01lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor // 모든 파라미터가 들어간 생성자 생성
@NoArgsConstructor // 파라미터가 없는 생성자 생성
@Data
public class JavaBeans4 {
	private String name;
	private int age;
	
	
}
