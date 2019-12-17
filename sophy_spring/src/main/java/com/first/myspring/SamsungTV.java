package com.first.myspring;

public class SamsungTV implements Tv {

	private int price;
	private SonySpeaker sony;
	
	public SamsungTV(SonySpeaker sony) {
		this.sony = sony;
		
	}
	public SamsungTV(int price) {
		System.out.println("SamsungTv");
		System.out.println("이 TV 의 가격은  : " + price +" 입니다 _________");
	}
	
	
	// SamsungTV 생성자의 overloading
		public SamsungTV(SonySpeaker speaker, int price) {
			
			System.out.println("SamsungTV speaker / price 생성자");
			this.sony = speaker; // 자기 자신의 멤버로 넘겨줌
			this.price = price;
		}
		
		
	@Override
	public void powerOn() {
		System.out.println("SamsungTV_전원을 켜보도록 하겠습니다.");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("SamsungTV_전원을 꺼보도록 하겠습니다.");
		
	}
	
	@Override
	public void soundUp() {
		
		sony.soundUp();
	}
	@Override
	public void soundDown() {
		
		sony.soundDown();
	}
	
/*
	@Override
	public void soundUp() {
		// TODO Auto-generated method stub
		System.out.println("SamsungTV_소리를 올리도록 하겠습니다.");
		
	}

	@Override
	public void soundDown() {
		System.out.println("SamsungTV_소리를 내리도록 하겠습니다.");
		// TODO Auto-generated method stub
		
	}
*/
}
