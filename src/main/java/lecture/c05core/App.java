package lecture.c05core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.log4j.Log4j;

@Log4j
public class App {
	public static void main(String[] args) {
		String path = "lecture/c05core/context.xml";

		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		
		MyServlet s = context.getBean(MyServlet.class);
		MyDao d = context.getBean(MyDao.class); // bean으로 만든 객체는 1개로 돌려씀
		MyDao d1 = (MyDao) context.getBean("myDao");
		
		log.warn(s);
		log.warn(d);
		log.warn(d1);
		
	}

}
