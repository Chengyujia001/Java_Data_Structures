package Ch23_Sorting;

import java.util.*;

public class test_heapSort<E extends Comparable<E>> {
	
	private ArrayList<E> list = new ArrayList<>();
	
	public test_heapSort() {
	}
	
	public test_heapSort(E[] obj) {
		for (int i = 0 ; i < obj.length ; i++)
			add(obj[i]);
	}
	
	
	public void add(E e) {
		list.add(e);
		int currentIndex = list.size() - 1;
		
		while (currentIndex > 0) {
			int parentIndex = (currentIndex - 1)/2 ; 
			
			//swap if child > parent 	
			if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0){
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
			
			int maxIndex = leftChildIndex;
			if (rightChildIndex < list.size()) {
				if (list.get(maxIndex).compareTo(list.get(rightChildIndex))< 0) {
					maxIndex = rightChildIndex;
				}
			
				}
		
			if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
				E temp = list.get(maxIndex);
				list.set(maxIndex, list.get(currentIndex));
				list.set(currentIndex, temp);
				currentIndex = maxIndex;
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
		Heap<E> heap = new Heap<>();
		
		for (int i = 0; i < list.length; i++)
			heap.add(list[i]);
		for (int i = list.length - 1; i >= 0; i--)
			list[i] = heap.remove();

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] a = {1, 3, 4, 11, 54, 88, 32, 1, 2};
		String[] b = {"dasfasd", "fdsaee", "23", "fds"};
		
		heapSort(a);
		heapSort(b);
		
		for (int e: a)
			System.out.print(e + " ");
		
		System.out.print("\n");
		for (String e: b)
			System.out.print(e + " ");

	}

}
