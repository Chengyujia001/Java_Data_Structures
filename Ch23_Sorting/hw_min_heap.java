package Ch23_Sorting;
//Java II, Dr. takyiu
//Mack Cheng, March,21,2021
//
//23.7 min-heap: revise the heap class in list. 
//
//output:
//88 54 32 11 4 3 2 1 1 


import java.util.*;

public class hw_min_heap<E extends Comparable<E>> {
	
	private ArrayList<E> list = new ArrayList<>();
	
	public hw_min_heap() {
	}
	
	public hw_min_heap(E[] obj) {
		for (int i = 0 ; i < obj.length ; i++)
			add(obj[i]);
	}
	
	
	public void add(E e) {
		list.add(e);
		int currentIndex = list.size() - 1;
		
		while (currentIndex > 0) {
			int parentIndex = (currentIndex - 1)/2 ; 
			
			//swap if child > parent 	
			if (list.get(currentIndex).compareTo(list.get(parentIndex)) < 0){
				E temp = list.get(currentIndex);
				list.set(currentIndex, list.get(parentIndex));
				list.set(parentIndex, temp);
			}
			else
				break;
			currentIndex = parentIndex;
		}
	
	}
	
	//remove the root
	public E remove() {
		if (list.size() == 0) return null;
		
		E removedObj = list.get(0);		//store a[o] to obj
		list.set(0, list.get(list.size()-1));
		list.remove(list.size() - 1);
		
		int currentIndex = 0;
		while (currentIndex < list.size()) {
			int leftChildIndex = 2*currentIndex + 1;
			int rightChildIndex = 2*currentIndex + 2;
			
			if (leftChildIndex >= list.size()) 
				break;
			//().compareTo()  	nega : less than  || posi: greater
			
			int minIndex = leftChildIndex;	///compare right/left child
			if (rightChildIndex < list.size()) {
				if (list.get(minIndex).compareTo(list.get(rightChildIndex)) > 0) {		
					minIndex = rightChildIndex;
				}
				}
		
			if (list.get(currentIndex).compareTo(list.get(minIndex)) > 0) {
				E temp = list.get(minIndex);
				list.set(minIndex, list.get(currentIndex));
				list.set(currentIndex, temp);
				currentIndex = minIndex;
				}
			else
				break;
		}
		return removedObj;
	}

	public int getSize() {
		return list.size();
	}
	
	public static <E extends Comparable<E>> void heapSort(E[] list) {
		hw_min_heap<E> heap = new hw_min_heap<>();
		
		for (int i = 0; i < list.length; i++) {
			heap.add(list[i]);
		}

		for (int i = (list.length -1) ; i >= 0  ; i--)
			list[i] = heap.remove();

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] a = {1, 3, 4, 11, 54, 88, 32, 1, 2};
		
		
		heapSort(a);
		
		for (int e: a)
			System.out.print(e + " ");

	}

}
