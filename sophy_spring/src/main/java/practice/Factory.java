package practice;

public class Factory {
	
	public Object getBean(String beanName){
		
		if (beanName.equals("samsung")) {
			return new SamsungTv();
		}else if (beanName.equals("lg")) {
			return new LgTv();
		}
		
		return null;
	}

}
