package lecture.c01lombok;

import lombok.Data;

@Data // get, set 메소드 생성
	  // canEqual, equal, hashCode, toString 재정의
	  // 모든게 한번에 생성되는 어노테이션
public class JavaBeans3 {
	private String address;
	private int employeeId;
}
