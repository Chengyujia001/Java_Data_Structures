package Ch22_Time_Complexity_and_Algorithms;
//Java II, Dr. takyiu
//Mack Cheng, March,7,2021

//There are 3 items with different weights and values, find the most-value solution with a limited carrying capacity .
//
//
//


//
import java.util.*;


public class hw_Knapsack_Problem {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int NUMBER_ITEMS = 10;
		final int MIN_WEIGHT = 1;
		final int MAX_WEIGHT = 5;
		final int MIN_VALUE = 50;
		final int MAX_VALUE = 100;
		final int KNAPSACK_CAPACITY = 20;
		
		Item[] items = generateItems(NUMBER_ITEMS, MIN_VALUE, MAX_VALUE, MIN_WEIGHT, MAX_WEIGHT);
		for(Item e:items) {		//display items
			System.out.println(e);
		}			
		
		
		int VALUE[] = new int[NUMBER_ITEMS]; 
        int WEIGHT[] = new int[NUMBER_ITEMS]; 
		for (int i= 0 ; i< NUMBER_ITEMS; i++) {
			VALUE[i] = items[i].value;
			WEIGHT[i] = items[i].weight;
		}
		
        System.out.println("Capacity: " + KNAPSACK_CAPACITY + "\ntotal value: " + 
                  knapSack(KNAPSACK_CAPACITY, WEIGHT, VALUE,  NUMBER_ITEMS)); 
        
		}
	
	 static int max(int a, int b){ 
		 return (a > b) ? a : b; 
	 }
	
	 static int knapSack(int CAP, int wt[], int val[], int NUM) 
	    {  
	        int K[][] = new int[NUM + 1][CAP+1]; 
	        for (int i = 0; i<= NUM; i++) { 
	            for (int c = 0; c<= CAP; c++) { 
	                if (i == 0 || c == 0) 
	                    K[i][c] = 0; 
	                else if (wt[i - 1]<= c) 
	                    K[i][c] = max(
	                    		val[i - 1] + K[i - 1][c - wt[i - 1]],
	                    		K[i - 1][c]
	                    				); 
	                else
	                    K[i][c] = K[i - 1][c]; 
	            } 
	        } 
	  
	        return K[NUM][CAP]; 
	    } 

	
	
	static Item[] generateItems(int howMany, int lValue, int hValue, int lWeight, int hWeight) {
		Item[] results = new Item[howMany];
		for (int i = 0; i < howMany; i++) {
			int value = (int) (Math.random() * (hValue - lValue + 1)) + lValue;
			int weight = (int) (Math.random() * (hWeight - lWeight + 1)) + lWeight;
			results[i] = new Item("Item" + (i + 1), value, weight);
			}
		return results;
	}

	
		
	}
	
	
	class Item {
		String name;
		int value;
		int weight;

		public Item(String s, int v, int w) {
			name = s;
			value = v;
			weight = w;
				}

		@Override
		public String toString() {
			return name + ": " + value + " | " + weight;
			}
	
	
}
	



