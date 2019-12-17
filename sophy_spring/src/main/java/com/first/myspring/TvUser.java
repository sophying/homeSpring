package com.first.myspring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUser {
	
	public static void main(String[] args) {
		
		
		//1. Spring container 구동 
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. Spring container 로부터 필요한 객체를 요청 (LookUp)
		/*
		  applicationContext.xml 에서 bean id="tv" 를 찾아 감 
		  
		  bean 객체를 tv 라는 이름으로 생성한 뒤  SamsungTV class 로 형변환하여 그 값을
		  Tv 타입의 tv 변수에 담겠다. 
		*/
		Tv tv = factory.getBean("tv",SamsungTV.class);
		
		tv.powerOn();
		tv.soundUp();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();
		
		
	}
	

}
