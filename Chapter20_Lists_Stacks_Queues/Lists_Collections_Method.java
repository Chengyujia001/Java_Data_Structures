package Chapter20_Lists_Stacks_Queues;
import java.util.*;
public class Lists_Collections_Method {
	public static void main(String[] args) {
//	p790
	
//	list::
//	+sort(list: List): void
//	+sort(list: List, c: Comparator): void
//	+binarySearch(list: List, key: Object): int
//	+binarySearch(list: List, key: Object, c:
//	Comparator): int
//	+reverse(list: List): void
//	+reverseOrder(): Comparator
//	+shuffle(list: List): void
//	+shuffle(list: List, rmd: Random): void
//	+copy(des: List, src: List): void
//	+nCopies(n: int, o: Object): List
//	+fill(list: List, o: Object): void
	
//	Collections
//	+max(c: Collection): Object
//	+max(c: Collection, c: Comparator): Object
//	+min(c: Collection): Object
//	+min(c: Collection, c: Comparator): Object
//	+disjoint(c1: Collection, c2: Collection): boolean
//	+frequency(c: Collection, o: Object): int
	
	
	//sort list
	List<String> list1 = Arrays.asList("red", "green", "blue");
	Collections.sort(list1);
	System.out.println(list1);
	
	//change order
	List<String> list2 = Arrays.asList("yellow", "red", "green", "blue");
	Collections.sort(list2, Collections.reverseOrder());
	System.out.println(list2);
	
	//binary search
	List<String> list3 = Arrays.asList("blue", "green", "red");
	System.out.println("(3) Index: " + Collections.binarySearch(list3, "red"));
	System.out.println("(4) Index: " + Collections.binarySearch(list3, "cyan"));
	
	//random
	List<String> list11 = Arrays.asList("yellow", "red", "green", "blue");
	Collections.shuffle(list11, new Random(20));
	System.out.println(list11);
	
	
	//copy l2 to l1
	Collections.copy(list1, list2);
	//n copy
	List<GregorianCalendar> list1 = Collections.nCopies(5, new GregorianCalendar(2005, 0, 1));
	
	//fill
	List<String> list = Arrays.asList("red", "green", "blue");
	Collections.fill(list, "black");
	System.out.println(list);
	
	//min, max
	Collections.max(collection);
	
	//disjoint(collection1, collection2) method returns true if the two collections have no elements in common
	Collections.disjoint(collection1, collection2); 	//return bool
	
	//p799
	
	
	}
}
