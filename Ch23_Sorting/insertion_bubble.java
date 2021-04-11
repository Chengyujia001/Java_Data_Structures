package Ch23_Sorting;

public class insertion_bubble {
	public static void insertionSort(double[] list) {					//insertion Sort
	    for (int i = 1; i < list.length; i++) {
	      /** insert list[i] into a sorted sublist list[0..i-1] so that
	           list[0..i] is sorted. */
	      double currentElement = list[i];
	      int k;
	      for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
	        list[k + 1] = list[k];
	      }

	      // Insert the current element into list[k+1]
	      list[k + 1] = currentElement;
	    }
	  }
	
	
	 public static void bubbleSort(int[] list) {						//bubble Sort
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
	
	
	
	
}
