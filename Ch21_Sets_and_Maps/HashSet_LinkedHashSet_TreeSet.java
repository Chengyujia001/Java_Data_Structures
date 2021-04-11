package Ch21_Sets_and_Maps;
import java.util.*;
public class HashSet_LinkedHashSet_TreeSet {

	public static void main(String[] args) {
		
		//Set:
		//no duplicates, no same elements
		//Three concrete classes of Set are HashSet, LinkedHashSet, and TreeSet
				
				
		//HashSet: 
		//HashSet can be used to store duplicate-free elements	
		//the strings are not stored in the order in which they are inserted
		//    into the set. There is no particular order for the elements in a hash set
//		
//	#...+HashSet()
//		+HashSet(c: Collection<? extends E>)
//		+HashSet(initialCapacity: int)
//		+HashSet(initialCapacity: int, loadFactor: float)
//		
//		
//		
//	...	LinkedHashSet: 	£¨HashSet<E>£©
//		the elements in a LinkedHashSet can be retrieved in the order in which they were inserted into the set
//		
//	#	+LinkedHashSet()
//		+LinkedHashSet(c: Collection<? extends E>)
//		+LinkedHashSet(initialCapacity: int)
//		+LinkedHashSet(initialCapacity: int, loadFactor: float)
//		
//		
//		
//		
//	...	TreeSet£º		(NavigableSet	SortedSet)	p822
//		SortedSet is a subinterface of Set, which guarantees that the elements in the set are sorted.
//		Additionally, it provides the methods first() and last() for returning the first and last
//		  elements in the set, and headSet(toElement) and tailSet(fromElement) for returning 
//		  a portion of the set whose elements are less than toElement and greater than or equal to
//		  fromElement, respectively	
//	#	+TreeSet()
//		+TreeSet(c: Collection<? extends E>)
//		+TreeSet(comparator: Comparator<?
//		 super E>)
//		+TreeSet(s: SortedSet<E>)
//		
//	...	NavigableSet:		:provide navigation methods lower(e),floor(e),
//							ceiling(e), and higher(e) that return elements respectively less than, less
//							than or equal, greater than or equal, and greater than a given element
//		+pollFirst(): E
//		+pollLast(): E
//		+lower(e: E): E
//		+higher(e: E):E
//		+floor(e: E): E
//		+ceiling(e: E): E
//		
//	...	SortedSet:			:guarantees that the elements in the set are sorted/
//		+first(): E			
//		+last(): E			returning the first and last elements in the set
//		+headSet(toElement: E): SortedSet<E>
//		+tailSet(fromElement: E): SortedSet<E>
//		
//		 headSet(toElement) and tailSet(fromElement) for returning 
//		 a portion of the set whose elements are less than toElement and greater than or equal to
//		 fromElement, respectively
		
//	#	21.4 Case Study: Counting Keywords p832

//example:--------------
		//HashSet
		Set<String> set = new HashSet<>();
		set.add("Shanghai");
		set.add("New York");
		
		for (String s: set) {
			System.out.print(s.toUpperCase() + " ");}
		


		Set<String> set1 = new java.util.HashSet<>();
		set1.add("London");
		set1.add("Paris");
		
		System.out.println(set1.size());
		set1.remove("London");
		System.out.println("\nIs Taipei in set1? "+ set1.contains("Taipei"));	//bool
		
		set1.addAll(set);
		set1.removeAll(set);
		
		//--------------------
		//LinkedHashSe
		 Set<String> set2 = new LinkedHashSet<>();
		 set2.add("Beijing");
		 set2.add("San Francisco");
		 for (Object element: set)
			 System.out.print(((String) element).toLowerCase() + " ");
		
		
		//-------------
		 //TreeSet
		 //,Test TreeSet With Comparator
//		 Set<GeometricObject> set4 = new TreeSet<>(new GeometricObjectComparator());
//		 set.add(new Rectangle(4, 5));
//		 for (GeometricObject element: set)
//			 16 System.out.println("area = " + element.getArea());
			
		
		
	}

}
