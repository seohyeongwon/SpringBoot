package org.comstudy.myweb.tv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SamsungTV implements TV {
	@Autowired
	private Speaker speaker;
	
	public SamsungTV() {
		System.out.println(">>> SamsungTV 생성");
	}
	
	// DI (의존성 주입)을 위해 만든 생성자
	// DI == IoC(제어의 역전)
	public SamsungTV(Speaker speaker) {
		this.speaker = speaker;
	}
	// DI (의존성 주입)을 위해 만든 셋터 메소드
	@Override
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	@Override
	public void turnOn() {
		System.out.println("삼성 TV 켜기!");
	}

	@Override
	public void turnOff() {
		System.out.println("삼성 TV 끄기!");
	}

	@Override
	public void volumeUp() {
		speaker.soundUp();
	}

	@Override
	public void volumeDown() {
		speaker.soundDown();
	}
}
