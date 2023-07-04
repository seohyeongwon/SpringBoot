package org.comstudy.myweb.tv;

public interface TV {

	// DI (의존성 주입)을 위해 만든 셋터 메소드
	void setSpeaker(Speaker speaker);

	void turnOn();

	void turnOff();

	void volumeUp();

	void volumeDown();

}