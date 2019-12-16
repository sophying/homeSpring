package practice;

public class TvUser {
	
	public static void main(String[] args) {
		
		Factory factory = new Factory();
		TV tv = (TV) factory.getBean(args[0]);
		
		tv.powerOn();
		tv.soundUp();
		tv.soundUp();
		tv.soundUp();
		tv.soundUp();
		tv.soundDown();
		tv.soundDown();
		tv.powerOff();
	}

}
