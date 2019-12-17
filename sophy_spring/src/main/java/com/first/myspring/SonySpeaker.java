package com.first.myspring;

public class SonySpeaker implements Speaker{

	public SonySpeaker() {
	
		System.out.println("SonySpeaker >>>>");
		System.out.println();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void soundUp() {
		System.out.println("Sony__volumeUp_____");
	}

	@Override
	public void soundDown() {
		// TODO Auto-generated method stub
		System.out.println("Sony__volumeDown_____");
		
	}

}
