package lecture.c02lombok;

import lombok.extern.log4j.Log4j;

@Log4j
public class App {
	public static void main(String[] args) {
		
		System.out.println("어떤 메시지 출력....");
		log.debug("디버그 용 메시지 출력...");
		log.info("정보전달용 메시지 출력..");
		log.warn("경고용 메시지 출력....");
		log.error("에러용 메시지 출력...");
		log.fatal("치명적 에러용 메시지 출력......");
		
		// 경고 단계에 따른 출력 단계를 설정할 수 있음
		// default는 warn메소드부터 출력됨
	}

}
