package com.first.myspring;

public class LgTV implements Tv {

	@Override
	public void powerOn() {
		System.out.println("LgTV_전원을 켜보도록 하겠습니다.");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV_전원을 꺼보도록 하겠습니다.");
		
	}

	@Override
	public void soundUp() {
		System.out.println("LgTV_소리를 올리도록 하겠습니다.");
		
	}

	@Override
	public void soundDown() {
		System.out.println("LgTV_소리를 내리도록 하겠습니다.");
		
	}
}
