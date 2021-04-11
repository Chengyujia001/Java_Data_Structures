package Ch23_Sorting;
//Java II, Dr. takyiu
//Mack Cheng, March,21,2021
//
//23.12 (RadixSort): Write a program randomly generate 1,000,000 int and sort them using radix sort 
//
//output: test 10 integers: 
//350 591 117 307 321 908 778 256 56 664  
//after sort:
//56 117 256 307 321 350 591 664 778 908 

//base 16. use shifting

import java.math.*;
import java.util.*;

public class hw_RadixSort<E extends Comparable<E>> {
	public static void main(String[] args) {

		//test
		/*
		 * Integer[] list0 = new Integer[10]; for (int i = 0 ; i < list0.length ; i++) {
		 * list0[i] = (int)( Math.random()* 1000); } for (int e: list0)
		 * System.out.print(e + " "); System.out.println( " "); radixSort(list0,4); for
		 * (int e: list0) System.out.print(e + " "); System.out.println();
		 */
		
		//generate 1,000,000 int and sort them
		
		int[] list = new int[1000000];
		for (int i = 0 ; i < list.length ; i++) {
			list[i] = (int)( Math.random()* 1000);
		}
		radixSort(list,4);
		for (int e: list)
			System.out.println(e);
	}
	
	public static void radixSort(int[] list , int figures) {
		//create 10 buckets
		ArrayList[] buckets = new ArrayList[10];

		//create an arraylist for each buckets
		for (int i = 0 ; i < 10; i++) {			
			buckets[i] = new ArrayList<>();
		}
		
		
		
		//for each postion
		for(int i = 0 ; i < figures; i++) {	
			//clear bucket
			for (int j = 0 ; j < 10; j++) {			
				buckets[j].clear();
			}
			
			//put numbers into buckets
			for (int j = 0 ; j < list.length ; j++) {
				int key =  ((list[j] / (int)Math.pow(10 , i)) % 10);
				buckets[key].add(list[j]);
			}
			
			int index = 0;
			//for each buckets
			for (int j = 0 ; j < 10 ; j++) {	
				// for each element in this bucket
				for (int k = 0 ; k < buckets[j].size() ; k++) { 
					//put the elements back to list
					list[index++] =  (Integer) buckets[j].get(k);
				}
			}
			
		}
		
	}
}
