package lecture.c03core;

public class Servlet1 {
	
	private Dao1 dao; // dependency 
	// dependency injection을 spring이 해줌.
	// inversion of control -> IOC 가 일어남.
	
	public void doGet() {
		// request 파라미터 수집 / 가공
		// business 로직 처리
		dao.select();
		// 결과 세팅
		// forward or redirect
	}
}
