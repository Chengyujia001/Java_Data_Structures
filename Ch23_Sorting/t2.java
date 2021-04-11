
package Ch23_Sorting;
//Java II, Dr. takyiu
//Mack Cheng, March,21,2021
//
//23.12 (RadixSort): Write a program randomly generate 1,000,000 int and sort them using radix sort 
//
import java.math.*;
import java.util.ArrayList;

public class t2<E extends Comparable<E>> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] list = new Integer[10];			//1000000
		for (int i = 0 ; i < list.length ; i++) {
			list[i] = (int)( Math.random()* 1000);
		}
		
		for (int e: list)
			System.out.print(e+ " ");
		
		radixSort(list, 3);
		System.out.println("\nAfter sort:");
		for (int e: list)
			System.out.print(e + " ");
	}
	
	
	
    public static void radixSort(Integer[] list, int numberOfDigits) {
        ArrayList<Integer>[] buckets = new ArrayList[10];
        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < numberOfDigits; i++) {
            for(int j = 0; j < buckets.length; j++) {
                buckets[j].clear();
            }
            
            for(int j = 0; j < list.length; j++) {
                int temp = (list[j] / (int)(Math.pow(10, i))) % 10;
                buckets[temp].add(list[j]);
            }
            
            int k = 0;
            for(int j = 0; j < buckets.length; j++) {
                for(int n = 0; n < buckets[j].size(); n++) {
                    list[k++] = buckets[j].get(n);
                }
            }
        }
    }
}