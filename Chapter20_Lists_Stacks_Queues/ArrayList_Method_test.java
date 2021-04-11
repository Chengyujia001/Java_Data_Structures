package Chapter20_Lists_Stacks_Queues;
import java.util.*;
public class ArrayList_Method_test {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> c1 = new ArrayList<>();	//create
		
		c1.add("city1");				//add
		c1.add("city2");
		c1.add("city3");
		c1.add("city4");
		c1.add("city5");
		
		
		
		System.out.println(c1);
		
		if (c1.contains("city1"))		//boolean
			System.out.println("contains city1");
		
		c1.remove("city1");				//remove
		System.out.println(c1.size() +" " + c1);
		
		
		
		ArrayList<String> c2 = new ArrayList<>();
		c2.add("city3");	
		c2.add("city2");
		c1.removeAll(c2);				//remove all
		System.out.println(c1);
		
		ArrayList<String> c3 = (ArrayList<String>)(c1.clone());		//clone
		c3.addAll(c2);					//add all
		System.out.println(c3);		
	}

}
