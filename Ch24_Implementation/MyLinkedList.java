package Ch24_Implementation;

import java.lang.reflect.Array;

public class MyLinkedList<E> extends MyAbstractList<E> {
	private static class Node<E>{
		E element; 
		Node<E> next;
		
		public Node(E e) {
			element = e;
		}
	}
	
	private Node<E> head, tail;
	
	
	public MyLinkedList(){
	}
	
	
	public MyLinkedList(E[] array){
		super(array);
	}
	
	
	public E getFirst(){
		if (size == 0) return null;
		else
			return head.element;
	}
	
	
	public E getLast(){
		if (size == 0) return null;
		else
			return tail.element;
	}

	public void addFirst(E e){
		Node<E> newNode = new Node<>(e);
		newNode.next = head;
		head = newNode;
		size++;
		
		if (tail == null)
			tail= head;
	}
	
	
	public void addLast(E e){
		Node<E> newNode = new Node<>(e);
		
		if (tail == null)
			head = tail = newNode;
		else {
			tail.next = newNode;
			tail = tail.next; //tail = nnewNode?
		}
		size++;
	}
	
	@Override
	public void add(int index , E e){
		if (index == 0) 
			addFirst(e);
		else if (index >= size) 
			addLast(e);
		else {
			Node<E> current = head;
			for (int i = 1; i < index ; i++) 
				current = current.next;		//find the element at index
			Node<E> temp = current.next;	//copy the element at this index
			current.next = new Node<E>(e);	//clean and put e into position
			(current.next).next = temp;		//connect the "next" with the origion element
			size++;
		}
	}

	
	
	@Override
	public E remove(int index) {
		if (index < 0 || index > size) return null;
		else if (index == 0) return removeFirst();
		else if (index == size) return removeLast();
		else {
			Node<E> previous = head;
			for (int i = 1; i < index; i++) 
				previous = previous.next;	
			Node<E> current = previous.next;
			previous.next = current.next;
			size--;
			return current.element;
		}
		
	}
	
	public E removeFirst() {
		if (size == 0)
			return null;
		else {
			Node<E> temp = head;
			head = head.next;
			size--;
			if (head == null) tail = null;
			return temp.element;					
		}
	}
	
	
	
	public E removeLast() {
		if (size == 0)
			return null;
		else if (size == 1) {
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		}
		else {
			Node<E> current = head;
			
			for (int i = 1; i < size - 2 ; i++) 
				current = current.next;	
			Node<E> temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.element;					
		}
		
	}
	
	
	
	
	
	
	//*********************************************
	@Override /** Override toString() to return elements in the list */
	  public String toString() {
	    StringBuilder result = new StringBuilder("***[");

	    Node<E> current = head;
	    for (int i = 0; i < size; i++) {
	      result.append(current.element);
	      current = current.next;
	      if (current != null) {
	        result.append(" - "); // Separate two elements with a comma
	      }
	      else {
	        result.append("]***"); // Insert the closing ] in the string
	      }
	    }

	    return result.toString();
	  }
	
	@Override /** Clear the list */
	public void clear() {
	 size = 0;
	 head = tail = null;
	 }
	
	@Override
	public boolean cotains(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	  @Override /** Return the element at the specified index */
	  public E get(int index) {
	    // Left as an exercise 
	    return null;
	  }

	  @Override /** Return the index of the head matching element in 
	   *  this list. Return -1 if no match. */
	  public int indexOf(Object e) {
	    // Left as an exercise
	    return 0;
	  }

	  @Override /** Return the index of the last matching element in 
	   *  this list. Return -1 if no match. */
	  public int lastIndexOf(E e) {
	    // Left as an exercise
	    return 0;
	  }

	  @Override /** Replace the element at the specified position 
	   *  in this list with the specified element. */
	  public E set(int index, E e) {
	    // Left as an exercise
	    return null;
	  }
	//******************************************************************
	
	
	
	
	
	
	
	
	
	//Iterator
	@Override
	public java.util.Iterator<E> iterator(){
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements java.util.Iterator<E> {
		private Node<E> current = head;
		
	@Override
	public boolean hasNext() {
			return (current != null);
		}
	
	@Override
	public E next() {
		E e = current.element;
		current = current.next;
		return e;
	}
	
	@Override
	public void remove() {
		 System.out.println("...");
	}
	}

	

}


