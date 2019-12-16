package practice;

public class LgTv implements TV {

	@Override
	public void powerOn() {
		System.out.println("LgTv 전원 On");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTv 전원 Off");		
	}

	@Override
	public void soundUp() {
		System.out.println("LgTv soundUp");		
		
	}

	@Override
	public void soundDown() {
		System.out.println("LgTv soundDown");		
		
	}
	

}
