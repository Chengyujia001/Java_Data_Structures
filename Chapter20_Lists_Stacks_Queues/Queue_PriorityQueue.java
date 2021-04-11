package Chapter20_Lists_Stacks_Queues;
import java.util.*;
public class Queue_PriorityQueue {

	public static void main(String[] args) {
		
//		queue:
//		A queue is a first-in, first-out data structure
//		
//		
//		+offer(element: E): boolean		Inserts an element into the queue	
//		+poll(): E						Retrieves and removes the head of this queue, or null if this queue is empty.
//		+remove(): E					Retrieves and removes the head of this queue and
//											throws an exception if this queue is empty.
//		+peek(): E						Retrieves, but does not remove, the head of this queue,
//											returning null if this queue is empty.
//		+element(): E					Retrieves, but does not remove, the head of this queue,
//											throws an exception if this queue is empty.
//		
//		The offer method is used to add an element to the queue. 
//		This method is similar to the add method in the Collection interface, but the offer method is preferred for queues.
//		The poll and remove methods are similar, except that poll() returns null if the queue is empty, 
//			whereas remove() throws an exception. 
//		The peek and element methods are similar, except that peek() returns null if the queue is empty, 
//			whereas element() throws an exception
//		
//		example:
		java.util.Queue<String> queue = new java.util.LinkedList<>();
		queue.offer("Oklahoma");
		queue.offer("Indiana");
		queue.offer("Georgia");
		queue.offer("Texas");
		
		while (queue.size() > 0)
			System.out.print(queue.remove() + " ");
	
	
//		
//		
//		
//		priority queue:
//		In a priority queue, elements are assigned priorities according to their natural ordering using Comparable. .
//		The element with the least value is assigned the highest priority and thus is removed from the queue first
//		
//		+PriorityQueue()
//		+PriorityQueue(initialCapacity: int)
//		+PriorityQueue(c: Collection<? extends E>)
//		+PriorityQueue(initialCapacity: int, comparator: Comparator<? super E>)
//		
//		Creates a default priority queue with initial capacity 11.
//		Creates a default priority queue with the specified initial
//		   	capacity.
//		Creates a priority queue with the specified collection.
//		Creates a priority queue with the specified initial
//			capacity and the comparator.
		
		PriorityQueue<String> queue1 = new PriorityQueue<>();		//create a default queue
		queue1.offer("Oklahoma");
		
		PriorityQueue<String> queue2 = new PriorityQueue(4, Collections.reverseOrder());		//create a queue with comparator
		queue2.offer("Indiana");				//reversed order
		queue2.offer("Texas");
		System.out.println();
		while (queue2.size() > 0) {
			System.out.print(queue2.remove() + " ");
		}
	}

}
