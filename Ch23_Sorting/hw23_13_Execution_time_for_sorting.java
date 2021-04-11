package Ch23_Sorting;

import java.util.ArrayList;

/*Java II, Dr. takyiu
Mack Cheng, April,4,2021

23.12 (RadixSort): Write a program randomly generate 1,000,000 int and sort them using radix sort 

output: 

Array   Selection   Insertion      Bubble       Merge       Quick        Heap       Radix
Size        Sort        Sort        Sort        Sort        Sort        Sort        Sort
-----------------------------------------------------------------------------------------
5000    19719100    15923000    33567300     1817300     1883400    11613000     6485000
10000    61781900    28054200   114760000     2041400      972800     8838100     7955100
15000   135300700    19111700   275709200     2979700     1310300     5135000     3680900
20000   240485200    33686800   535165200     3715800     1681400     6301100     4303700
25000   370458700    51533700   872987300     4694400     2047000     7692200     5005900
30000   533535900    75565300  1274308700     5691900     2507000     9980300     7061800*/


public class hw23_13_Execution_time_for_sorting {

	public static void main(String[] args) {
		System.out.printf("%12s%12s%12s%12s%12s%12s%12s%12s\n", "Array", "Selection", "Insertion", "Bubble", "Merge",
				"Quick", "Heap", "Radix");
		System.out.printf("%12s%12s%12s%12s%12s%12s%12s%12s\n", "Size", "Sort", "Sort", "Sort", "Sort", "Sort", "Sort",
				"Sort");

		System.out.println("\t-----------------------------------------------------------------------------------------");
		int[] list;
		int[] list1;
		Integer[] list2;
		long startTime;
		long endTime;
		long[][] executionTime = new long[6][7];

		final int BASE = 5000; //50000
		for (int k = 0; k < 6; k++) {
			list = new int[(k + 1) * BASE];
			list1 = new int[(k + 1) * BASE];
			list2 = new Integer[(k + 1) * BASE];
			for (int i = 0; i < list.length; i++) {
				list[i] = (int) (Math.random() * 100000);
				list1[i] = list[i];
				list2[i] = list[i];
			}

			startTime = System.nanoTime();
			selectionSort(list);
			endTime = System.nanoTime();
			executionTime[k][0] = endTime - startTime;

			startTime = System.nanoTime();
			copyList(list1, list);
			insertionSort(list);
			endTime = System.nanoTime();
			executionTime[k][1] = endTime - startTime;

			startTime = System.nanoTime();
			copyList(list1, list);
			bubbleSort(list);
			endTime = System.nanoTime();
			executionTime[k][2] = endTime - startTime;

			startTime = System.nanoTime();
			copyList(list1, list);
			mergeSort(list);
			endTime = System.nanoTime();
			executionTime[k][3] = endTime - startTime;

			startTime = System.nanoTime();
			copyList(list1, list);
			quickSort(list);
			endTime = System.nanoTime();
			executionTime[k][4] = endTime - startTime;

			startTime = System.nanoTime();
			heapSort(list2);
			endTime = System.nanoTime();
			executionTime[k][5] = endTime - startTime;

			startTime = System.nanoTime();
			
			radixSort(list, 5);
			endTime = System.nanoTime();
			executionTime[k][6] = endTime - startTime;
		}

		for (int i = 0; i < 6; i++) {
			System.out.printf("%12d", BASE + i * BASE);
			for (int j = 0; j < 7; j++)
				System.out.printf("%12d", executionTime[i][j]);
			System.out.println();
		}
	}

	/** The method for sorting the numbers */
	public static void selectionSort(int[] list) {
		// perform selection sort
		for (int i = 0; i < list.length - 1; i++) {
		      // Find the minimum in the list[i..list.length-1]
		      double currentMin = list[i];
		      int currentMinIndex = i;

		      for (int j = i + 1; j < list.length; j++) {
		        if (currentMin > list[j]) {
		          currentMin = list[j];
		          currentMinIndex = j;
		        }
		      }

		      // Swap list[i] with list[currentMinIndex] if necessary;
		      if (currentMinIndex != i) {
		        list[currentMinIndex] = list[i];
		        list[i] = (int) currentMin;
		      }
		    }
	}

	/** The method for sorting the numbers */
	public static void insertionSort(int[] list) {
		// perform insertion sort
		for (int i = 1; i < list.length; i++) {
		      /** insert list[i] into a sorted sublist list[0..i-1] so that
		           list[0..i] is sorted. */
		      int currentElement = list[i];
		      int k;
		      for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
		        list[k + 1] = list[k];
		      }

		      // Insert the current element into list[k+1]
		      list[k + 1] = currentElement;
		    }
	}

	/** The method for sorting the numbers */
	public static void bubbleSort(int[] list) {
		// perform bubble sort
		boolean needNextPass = true;
	    
	    for (int k = 1; k < list.length && needNextPass; k++) {
	      // Array may be sorted and next pass not needed
	      needNextPass = false;
	      for (int i = 0; i < list.length - k; i++) {
	        if (list[i] > list[i + 1]) {
	          // Swap list[i] with list[i + 1]
	          int temp = list[i];
	          list[i] = list[i + 1];
	          list[i + 1] = temp;
	          
	          needNextPass = true; // Next pass still needed
	        }
	      }
	    }
	}

	/** The method for sorting the numbers */
	public static void mergeSort(int[] list) {
		// perform merge sort
		if (list.length > 1) {
		      // Merge sort the first half
		    	
	// arraycopy(source array, the starting position in the source array, 
//		    	the destination array, starting position in the destination data, number of elements to be copied.)
		    	
		      int[] firstHalf = new int[list.length / 2];
		      System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
		      mergeSort(firstHalf);

		      // Merge sort the second half
		      int secondHalfLength = list.length - list.length / 2;
		      int[] secondHalf = new int[secondHalfLength];
		      System.arraycopy(list, list.length / 2, 		
		        secondHalf, 0, secondHalfLength);
		      mergeSort(secondHalf);

		      // Merge firstHalf with secondHalf into list
		      merge(firstHalf, secondHalf, list);
		    }
	}

	private static void merge(int[] list1, int[] list2, int[] temp) {
	    int current1 = 0; // Current index in list1
	    int current2 = 0; // Current index in list2
	    int current3 = 0; // Current index in temp

	    while (current1 < list1.length && current2 < list2.length) {
	      if (list1[current1] < list2[current2])
	        temp[current3++] = list1[current1++];
	      else
	        temp[current3++] = list2[current2++];
	    }

	    while (current1 < list1.length)
	      temp[current3++] = list1[current1++];

	    while (current2 < list2.length)
	      temp[current3++] = list2[current2++];
	  }

	public static void quickSort(int[] list) {
		// perform quick sort
		quickSort(list, 0, list.length - 1);
	}

	private static void quickSort(int[] list, int first, int last) {
		// quick sort helper
	    if (last > first) {
	      int pivotIndex = partition(list, first, last);
	      quickSort(list, first, pivotIndex - 1);
	      quickSort(list, pivotIndex + 1, last);
	    }
	  }

	  /** Partition the array list[first..last] */
	  private static int partition(int[] list, int first, int last) {
	    int pivot = list[first]; // Choose the first element as the pivot
	    int low = first + 1; // Index for forward search
	    int high = last; // Index for backward search

	    while (high > low) {
	      // Search forward from left
	      while (low <= high && list[low] <= pivot)
	        low++;

	      // Search backward from right
	      while (low <= high && list[high] > pivot)
	        high--;

	      // Swap two elements in the list
	      if (high > low) {
	        int temp = list[high];
	        list[high] = list[low];
	        list[low] = temp;
	      }
	    }

	    while (high > first && list[high] >= pivot)
	      high--;

	    // Swap pivot with list[high]
	    if (pivot > list[high]) {
	      list[first] = list[high];
	      list[high] = pivot;
	      return high;
	    }
	    else {
	      return first;
	    }
	  }



	public static void heapSort(Comparable[] list) {
		// perform heap sort
		Heap<Comparable> heap = new Heap<>();
		
		for (int i = 0; i < list.length; i++)
			heap.add(list[i]);
		for (int i = list.length - 1; i >= 0; i--)
			list[i] = heap.remove();
	}

	
	
	/**
	 * Sort the int array list. numberOfDigits is the number of digits in the
	 * largest number in the array
	 */
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

	

	public static void copyList(int[] list1, int[] list) {
		for (int i = 0; i < list1.length; i++)
			list[i] = list1[i];
	}
}