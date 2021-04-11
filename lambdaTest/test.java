package lambdaTest;

public class test {

	public static void main(String[] args) {
		
		innerclass med1 = x -> x*x;
		
		System.out.print(med1.innerclass(5));
	}

}

interface innerclass{
	int innerclass(int num);
}