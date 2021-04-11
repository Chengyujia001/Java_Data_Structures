package Ch21_Sets_and_Maps;
import java.util.*;
//Java II, Dr. takyiu
//Mack Cheng, March,9,2021
//
//Create two linked hash sets and find their union difference intersection.
//output: 
//Union :[Michelle, Kevin, Ryan, George, Katie, Blake, Michael, John, Jim]
//Intersection :[Michelle, Kevin, Ryan, George, Katie]
//Difference :[Michelle, Kevin, Ryan, George, Katie][Michelle, Kevin, Ryan, George, Katie]


public class hw_Perform_set_operations_on_hash_sets {
	public static void main(String[] args) {
		
		Set<String> set1 = new HashSet<String>(Arrays.asList("George", "Jim", "John", "Blake", "Kevin", "Michael"));
		Set<String> set2 = new HashSet<String>(Arrays.asList("George", "Katie", "Kevin", "Michelle", "Ryan"));
		
		Set<String> tem = new HashSet<>();
		Set<String> tem1 = new HashSet<>();
		Set<String> tem2 = new HashSet<>();
		
		tem = set1;		//clone the set, or use:	 LinkedHashSet<String> tem = (LinkedHashSet<String>)set1.clone(); 
		tem.addAll(set2);//union
		System.out.println("Union :" + tem);				
		
		
		tem = set1;							//intersection
		tem.retainAll(set2);   /*The retainAll method retains the elements in this collection that are also present in the specified collection*/
		System.out.println("Intersection :" + tem);		   
		
		
		tem1 = set1;
		tem2 = set2;
		tem1.remove(tem); 		// difference 
		tem2.remove(tem); 
		System.out.println("Difference :" + tem1 + tem2);		
		
	}

}
