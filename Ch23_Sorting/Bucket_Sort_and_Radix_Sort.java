package Ch23_Sorting;
import java.util.*;

public class Bucket_Sort_and_Radix_Sort<E extends Comparable<E>> {

/*	private ArrayList<E> list = new ArrayList<>();
	
	public Bucket_Sort_and_Radix_Sort() {
	}
	
		  *//** Add a new object into the heap *//*
		  
	 public void add(E newObject) {
		    list.add(newObject); // Append to the heap
		  }
	 
	 
	 public void getKey(E newObject) {
		    list.add(newObject); // Append to the heap
		  }
	 
	 public int size() {
		 return list.size();
	}*/
	
	
	 //******************
	 
	public void bucketSort(E[] list) {
		int[] bucket = (int)new list[10];
		
		// Distribute the elements from list to buckets
		for (int i = 0; i < list.length; i++) {
			int key = list[i].getKey(); // Assume element has the getKey() method
			if (bucket[key] == null)
				bucket[key] = new ArrayList<>();
			
		 bucket[key].add(list[i]);
		 }
		
		// Now move the elements from the buckets back to list
		int k = 0; // k is the index 
		for (int i = 0; i < 10; i++) {
			if (bucket[i] != null) {
				for (int j = 0; j < bucket[i].size(); j++)
					list[k++] = bucket[i].get(j);
				}
			}
		}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
		bucketSort(list);
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
		}
	}

class bucket<E extends Comparable<E>>{
	int[] bucket;
	int key;
	
	bucket() {
	}
	
	void add() {
		
	}
	
	
}















class SetCircle {
	double r = 1;
	double[] location = {0,0};
	  
	SetCircle() {
	}
	
	SetCircle(double newR){
		r = newR;
	}
	
	double getArea() {
		return r*r*Math.PI;
	}










