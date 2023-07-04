package org.comstudy.myweb;

import org.comstudy.myweb.tv.TV;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvMain {

	public static void main(String[] args) {
		// DI <---> Look up
		// 룩업 : 컨테이너에 생성 된 빈을 찾아 온다.
		// 웹과 관계없이 어플리케이션으로 실행 된다.
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 컨테이너에 생성 된 tv객체 빈을 찾는다(룩업)
		TV tv = (TV)factory.getBean("tv");
		tv.turnOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.turnOff();
	}

}
