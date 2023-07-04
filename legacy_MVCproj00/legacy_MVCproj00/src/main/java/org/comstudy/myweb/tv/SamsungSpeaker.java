package org.comstudy.myweb.tv;

import org.springframework.stereotype.Component;

@Component
public class SamsungSpeaker implements Speaker {
	public SamsungSpeaker() {
		System.out.println(">>> 삼성 스프커 생성");
	}
	
	@Override
	public void soundUp() {
		System.out.println("삼성 스피커 소리 키우기");
	}
	
	@Override
	public void soundDown() {
		System.out.println("삼성 스피커 소리 줄이기");
	}
	
}
