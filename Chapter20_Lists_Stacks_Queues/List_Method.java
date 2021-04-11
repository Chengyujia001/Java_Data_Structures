package Chapter20_Lists_Stacks_Queues;

import java.util.*;


public class List_Method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		LinkedList<String> list1 = new LinkedList<>();
		
		list1.add("city1");		//add(index, element)
		list1.add("city2");
		list1.add(1,"city3");	//insert element
		;
		
		
		
		int a = list1.indexOf("city2");	//find index of element
		

		System.out.println(list1);
		
		
		
		//list1.addAll(10,collection1);	//add a collection at index
		
		
		
//		+add(index: int, element: Object): boolean
//		+addAll(index: int, c: Collection<? extends E>): boolean
//		+get(index: int): E
//		+indexOf(element: Object): int
//		+lastIndexOf(element: Object): int
//		+listIterator(): ListIterator<E>
//		+listIterator(startIndex: int): ListIterator<E>
//		+remove(index: int): E
//		+set(index: int, element: Object): Object
//		+subList(fromIndex: int, toIndex: int): List<E>
//		

		ListIterator<String> listIte1 = list1.listIterator();		//create a list iterator,p793
		list1.set(0, "city4");
		
//		+add(element: E): void
//		+hasPrevious(): boolean
//		+nextIndex(): int
//		+previous(): E
//		+previousIndex(): int
//		+set(element: E): void
//		
		
		
		List<Integer> arrayList = new ArrayList<>();
		arrayList.add(1); // 1 is autoboxed to new Integer(1)
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(1);
		arrayList.add(4);
		arrayList.add(0, 10);
		arrayList.add(3, 30);
		
		LinkedList<Object> linkedList = new LinkedList<>(arrayList);	//linked list
		linkedList.add(1, "red");
		linkedList.removeLast();
		linkedList.addFirst("green");
		
		System.out.println("Display the linked list forward:");
		
		ListIterator<Object> listIterator = linkedList.listIterator();	//list iterator
		while (listIterator.hasNext()) {
			System.out.print(listIterator.next() + " ");
		 }
		 System.out.println();
		
		System.out.println("Display the linked list backward:");
		listIterator = linkedList.listIterator(linkedList.size());
		 while (listIterator.hasPrevious()) {
		 System.out.print(listIterator.previous() + " ");
		
		
		
	}
	}
}
