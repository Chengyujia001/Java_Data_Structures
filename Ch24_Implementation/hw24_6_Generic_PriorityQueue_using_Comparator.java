package Ch24_Implementation;
import java.util.Comparator;

import Ch23_Sorting.Heap;
public class hw24_6_Generic_PriorityQueue_using_Comparator {

  public static void main(String[] args) {
    new hw24_6_Generic_PriorityQueue_using_Comparator();
  }

  public hw24_6_Generic_PriorityQueue_using_Comparator() {

    // construct queue with a comparator object, say
    // s1, s2 with compareToIgnoreCase
	MyPriorityQueue<Q1> queue = new MyPriorityQueue<>();
	  
    queue.enqueue("Macon");
    queue.enqueue("Atlanta");
    queue.enqueue("Savannah");
    queue.enqueue("Augusta");
    queue.enqueue("Columbus");

    while (queue.getSize() > 0) {
      System.out.print(queue.dequeue() + " ");
    }
	
	  
	// construct queue1 with a different comparator object, say
	// s1, s2 with length of the string
    MyPriorityQueue<Q2> queue1 = new MyPriorityQueue<>();
    queue1.enqueue("ABC");
    queue1.enqueue("A");
    queue1.enqueue("AB");
    queue1.enqueue("ABCDE");
    queue1.enqueue("ABCD");

    System.out.println();
    while (queue1.getSize() > 0) {
      System.out.print(queue1.dequeue() + " ");
    }
    
  }

  static class Q1 implements Comparable<Q1>{
	  private String city;
	  private int priority;
	  
	  public Q1(String city) {
		  this.city = city;
		  this.priority = 
	  }
	  
	  
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  class MyPriorityQueue<E extends Comparable<E>> {
	// implement priority queue
		private Heap<E> heap = new Heap<>();
		
		public void enqueue(E newObject) {
			heap.add(newObject);
		}
		
		public E dequeue() {
			return heap.remove();
		}
		
		public int getSize() {
			return heap.getSize();
		}
		
	}
  
}
