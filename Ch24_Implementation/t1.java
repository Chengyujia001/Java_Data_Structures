package Ch24_Implementation;

public class t1 {
	public static void main(String[] args) {
		

		bird b = new bird();
		b.fly();
		
		blueBird1 bb = new blueBird1();
		bb.song();
		bb.fly();
	}
}

//************************************************
interface Flyer{
	void fly();
}

class bird implements Flyer{
	@Override
	public void fly() {
		System.out.println("fly fly fly");
	}
	
}
//**************************************************
interface blueBird extends Flyer{
	void song();
}

class blueBird1 implements blueBird{
	public void song() {
		System.out.println("Sing Sing Sing");
	}
	
	@Override
	public void fly() {
		System.out.println("Dont fly");
	}
}








