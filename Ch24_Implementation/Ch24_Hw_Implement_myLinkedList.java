package Ch24_Implementation;


import java.util.*;

import Ch24_Implementation.MyLinkedList.Node;

public class Ch24_Hw_Implement_myLinkedList {

	public static void main(String[] args) {
		new Ch24_Hw_Implement_myLinkedList();
	}

	public Ch24_Hw_Implement_myLinkedList() {
		String[] names = { "Tom", "Susan", "Kim", "George", "Peter", "Jean", "George", "Jane", "Denise", "Jenny",
				"Kathy", "Jane" };
		MyList<String> list = new MyLinkedList<>(names);

		Scanner input = new Scanner(System.in);
		System.out.print("Enter a name: ");
		String name = input.next();

		System.out.print("Enter an index: ");
		int index = input.nextInt();

		System.out.println(list.contains(name));
		System.out.println(list.get(3));
		System.out.println(list.indexOf(name));
		System.out.println(list.lastIndexOf(name));
		list.set(index, name);

		System.out.println(list);
	}

	public interface MyList<E> extends java.util.Collection<E> {
		/** Add a new element at the specified index in this list */
		public void add(int index, E e);

		/** Return the element from this list at the specified index */
		public E get(int index);

		/**
		 * Return the index of the first matching element in this list. Return -1 if no
		 * match.
		 */
		public int indexOf(Object e);

		/**
		 * Return the index of the last matching element in this list Return -1 if no
		 * match.
		 */
		public int lastIndexOf(E e);

		/**
		 * Remove the element at the specified position in this list Shift any
		 * subsequent elements to the left. Return the element that was removed from the
		 * list.
		 */
		public E remove(int index);

		/**
		 * Replace the element at the specified position in this list with the specified
		 * element and returns the new set.
		 */
		public E set(int index, E e);

		@Override /** Add a new element at the end of this list */
		public default boolean add(E e) {
			add(size(), e);
			return true;
		}

		@Override /** Return true if this list contains no elements */
		public default boolean isEmpty() {
			return size() == 0;
		}

		@Override /**
					 * Remove the first occurrence of the element e from this list. Shift any
					 * subsequent elements to the left. Return true if the element is removed.
					 */
		public default boolean remove(Object e) {
			if (indexOf(e) >= 0) {
				remove(indexOf(e));
				return true;
			} else
				return false;
		}

		@Override
		public default boolean containsAll(Collection<?> c) {
			// Left as an exercise
			return false;
		}

		@Override
		public default boolean addAll(Collection<? extends E> c) {
			// Left as an exercise
			return false;
		}

		@Override
		public default boolean removeAll(Collection<?> c) {
			// Left as an exercise
			return false;
		}

		@Override
		public default boolean retainAll(Collection<?> c) {
			// Left as an exercise
			return false;
		}

		@Override
		public default Object[] toArray() {
			// Left as an exercise
			return null;
		}

		@Override
		public default <T> T[] toArray(T[] array) {
			// Left as an exercise
			return null;
		}
	}

	public class MyLinkedList<E> implements MyList<E> {
		private Node<E> head, tail;
		private int size = 0; // Number of elements in the list

		/** Create an empty list */
		public MyLinkedList() {
		}

		/** Create a list from an array of objects */
		public MyLinkedList(E[] objects) {
			for (int i = 0; i < objects.length; i++)
				add(objects[i]);
		}

		/** Return the head element in the list */
		public E getFirst() {
			if (size == 0) {
				return null;
			} else {
				return head.element;
			}
		}

		/** Return the last element in the list */
		public E getLast() {
			if (size == 0) {
				return null;
			} else {
				return tail.element;
			}
		}

		/** Add an element to the beginning of the list */
		public void addFirst(E e) {
			Node<E> newNode = new Node<>(e); // Create a new node
			newNode.next = head; // link the new node with the head
			head = newNode; // head points to the new node
			size++; // Increase list size

			if (tail == null) // the new node is the only node in list
				tail = head;
		}

		/** Add an element to the end of the list */
		public void addLast(E e) {
			Node<E> newNode = new Node<>(e); // Create a new for element e

			if (tail == null) {
				head = tail = newNode; // The new node is the only node in list
			} else {
				tail.next = newNode; // Link the new with the last node
				tail = tail.next; // tail now points to the last node
			}

			size++; // Increase size
		}

		@Override /**
					 * Add a new element at the specified index in this list. The index of the head
					 * element is 0
					 */
		public void add(int index, E e) {
			if (index == 0) {
				addFirst(e);
			} else if (index >= size) {
				addLast(e);
			} else {
				Node<E> current = head;
				for (int i = 1; i < index; i++) {
					current = current.next;
				}
				Node<E> temp = current.next;
				current.next = new Node<>(e);
				(current.next).next = temp;
				size++;
			}
		}

		/**
		 * Remove the head node and return the object that is contained in the removed
		 * node.
		 */
		public E removeFirst() {
			if (size == 0) {
				return null;
			} else {
				Node<E> temp = head;
				head = head.next;
				size--;
				if (head == null) {
					tail = null;
				}
				return temp.element;
			}
		}

		/**
		 * Remove the last node and return the object that is contained in the removed
		 * node.
		 */
		public E removeLast() {
			if (size == 0) {
				return null;
			} else if (size == 1) {
				Node<E> temp = head;
				head = tail = null;
				size = 0;
				return temp.element;
			} else {
				Node<E> current = head;

				for (int i = 0; i < size - 2; i++) {
					current = current.next;
				}

				Node<E> temp = tail;
				tail = current;
				tail.next = null;
				size--;
				return temp.element;
			}
		}

		@Override /**
					 * Remove the element at the specified position in this list. Return the element
					 * that was removed from the list.
					 */
		public E remove(int index) {
			if (index < 0 || index >= size) {
				return null;
			} else if (index == 0) {
				return removeFirst();
			} else if (index == size - 1) {
				return removeLast();
			} else {
				Node<E> previous = head;

				for (int i = 1; i < index; i++) {
					previous = previous.next;
				}

				Node<E> current = previous.next;
				previous.next = current.next;
				size--;
				return current.element;
			}
		}

		@Override /** Override toString() to return elements in the list */
		public String toString() {
			StringBuilder result = new StringBuilder("[");

			Node<E> current = head;
			for (int i = 0; i < size; i++) {
				result.append(current.element);
				current = current.next;
				if (current != null) {
					result.append(", "); // Separate two elements with a comma
				} else {
					result.append("]"); // Insert the closing ] in the string
				}
			}

			return result.toString();
		}

		@Override /** Clear the list */
		public void clear() {
			size = 0;
			head = tail = null;
		}

		//*************************************************************************
		//Homework
//		System.out.println(list.contains(name));
//		System.out.println(list.get(3));
//		System.out.println(list.indexOf(name));
//		System.out.println(list.lastIndexOf(name));
//		list.set(index, name);
		
		@Override /** Return true if this list contains the element e */
		public boolean contains(Object o) {
			// implement in this exercise
			for (int i = 0 ; i < size  ; i++) {
				if (head.element == o)
					return true;
				head = head.next;
			}
			return false;
		}

		@Override /** Return the element from this list at the specified index */
		public E get(int index) {
			// implement in this exercise
			for (int i = 0 ; i < index ; i++)
				head = head.next;
			return head.element;
		}

		@Override /**
					 * Returns the index of the first matching element in this list. Returns -1 if
					 * no match.
					 */
		public int indexOf(Object o) {
			// implement in this exercise
			for (int i = 0 ; i < size ; i++) {
				if (head.element == o)
					return i;
			}
			return -1;
		}

		@Override /**
					 * Returns the index of the last matching element in this list Returns -1 if no
					 * match.
					 */
		public int lastIndexOf(Object o) {
			// implement in this exercise
			for (int i = size-1 ; i >= 0 ; i--) {
				if (head.element == o)
					return i;
			}	
			return -1;
		}

		@Override /**
					 * Replace the element at the specified position in this list with the specified
					 * element.
					 */
		public E set(int index, E e) {
			// implement in this exercise
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
			return e;
		}

		//hw end
		//************************************************************
		
		@Override /** Override iterator() defined in Iterable */
		public java.util.Iterator<E> iterator() {
			return new LinkedListIterator();
		}

		private class LinkedListIterator implements java.util.Iterator<E> {
			private Node<E> current = head; // Current index

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
				// Left as an exercise
				removeLast();
			}
		}

		private class Node<E> {
			E element;
			Node<E> next;

			public Node(E element) {
				this.element = element;
			}
		}

		@Override /** Return the number of elements in this list */
		public int size() {
			return size;
		}
	}
}
