package spring.service.hello.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import spring.service.hello.Greet;

public class GreetTestApp04UseSpring {

	public static void main(String[] args) {
		// 1. 공장을 생성..이때 주문서를 읽어들이도록 한다
		// --> 알아서 공장안에서 주문서에 적힌 객체를 생성하고 저장하고 있게된다.
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("./src/main/resources/config/greet.xml")); //파일시스템이기 때문에 src 패키지 인식이 안된다.. 처음부터 다 쳐서 넣는다.
		
		// 2. 공장에서 저장하고 있는 빈을 받아온다...getBean() 사용
		//Greet greet1 = (Greet)factory.getBean("greet1");
		
		//Greet greet1 = (Greet)factory.getBean("greet2");
		
		//Greet greet1 = (Greet)factory.getBean("greet3");
		
		//Greet greet1 = (Greet)factory.getBean("greet4");
		
		//Greet greet1 = (Greet)factory.getBean("greet5");
		
		Greet greet1 = (Greet)factory.getBean("greet6");
		
		// 3. 받아온 빈의 메소드 호출...
		greet1.printMessage();
	}

}
