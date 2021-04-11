package Chapter20_Lists_Stacks_Queues;

import java.util.*;

public class iteratorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> c1 = new ArrayList<>();
		
		c1.add("city1");				
		c1.add("city2");
		c1.add("city3");
		c1.add("city4");
		c1.add("city5");
		
		Iterator<String> it1 = c1.iterator();		//create
		
		while (it1.hasNext()) {						//bool
			System.out.println(it1.next().toUpperCase());	//Upper case
		}
		
//		+add(element: E): void
//		+hasPrevious(): boolean
//		+nextIndex(): int
//		+previous(): E
//		+previousIndex(): int
//		+set(element: E): void
//		
		
		
	}

}
