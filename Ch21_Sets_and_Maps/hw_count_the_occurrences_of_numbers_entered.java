package Ch21_Sets_and_Maps;
import java.util.*;
import java.lang.*;
//Java II, Dr. takyiu
//Mack Cheng, March,9,2021
//
//Goal: read number of integers and find the most frequent.
//output
//enter numbers, end with '0': 3
//4
//5
//3
//3
//4
//4
//9
//0
//The number 3, occurred 3 times. 
//The number 4, occurred 3 times. 

public class hw_count_the_occurrences_of_numbers_entered {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Integer, Integer> counter = new TreeMap<>();
		
		System.out.print("enter numbers, end with '0': ");
		
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		while (n != 0) {			
			if (!counter.containsKey(n))
				counter.put(n,1);
			else {
				int count = counter.get(n);
				count++;
				counter.put(n, count);
			}
			n = input.nextInt();
		}
		
//		for (int i = 1; i< counter.size(); i++) {
//			int max = counter[0];
//		}
		int max = 0;
		int key=0;
		for (Map.Entry e: counter.entrySet()) {
			if (max < (int)e.getValue()) {
				max = (int)e.getValue();
				key = (int) e.getKey();
			}
		}
		
		for (Map.Entry e: counter.entrySet()) {
			key = (int) e.getKey();
			if (max == (int)e.getValue()) 
				System.out.println("The number " + key + ", occurred " + max + " times. ");
		}
		
		

		

	}

}
