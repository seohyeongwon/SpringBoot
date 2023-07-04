package org.comstudy.myweb.tv;

public class SonySpeaker implements Speaker {

	@Override
	public void soundUp() {
		System.out.println("소니 스피커 소리 키우기");
	}

	@Override
	public void soundDown() {
		System.out.println("소니 스피커 소리 줄이기");
	}

}
