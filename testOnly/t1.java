package testOnly;

import java.util.*;

public class t1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> c1 = new ArrayList<>();
		
		c1.add("city1");
		c1.add("city2");
		c1.add("city3");
		c1.add("city4");
		c1.add("city5");
		
		System.out.println(c1);
		
		if (c1.contains("city1"))
			System.out.println("contains city1");
		
		c1.remove("city1");
		System.out.println(c1.size() +" " + c1);
		
		
		
		ArrayList<String> c2 = new ArrayList<>();
		c2.add("city3");
		c2.add("city2");
		c1.removeAll(c2);
		System.out.println(c1);
		
		ArrayList<String> c3 = (ArrayList<String>)(c1.clone());
		c3.addAll(c2);
		System.out.println(c3);
	}

}
