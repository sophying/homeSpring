package practice;

public class SamsungTv implements TV {

	@Override
	public void powerOn() {
		System.out.println("삼성 전원 On");
	}

	@Override
	public void powerOff() {
		System.out.println("삼성 전원 Off");		
	}

	@Override
	public void soundUp() {
		System.out.println("삼성 soundUp");		
		
	}

	@Override
	public void soundDown() {
		System.out.println("삼성 soundDown");		
		
	}
	

}
