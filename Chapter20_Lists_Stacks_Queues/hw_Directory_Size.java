package Chapter20_Lists_Stacks_Queues;
//Java II, Dr. takyiu
//Mack Cheng, March,7,2021



//Gives a recursive method for finding a directory size.
//Goal:	Rewrite this method without using recursion. Use a queue to store the subdirectories under a directory
//
//rewrite: 
//long getSize(File directory) {
//     long size = 0;
//     add directory to the queue;
//
//     while (queue is not empty) {
//       Remove an item from the queue into t;
//       if (t is a file)
//         size += t.length();
//       else
//         add all the files and subdirectories under t into the queue;
//     }
//
//     return size;
//     }
//   
import java.io.File;
import java.util.*;
public class hw_Directory_Size {

	public static void main(String[] args) {
		
		
		System.out.println("enter a file or a directory");
		Scanner input = new Scanner(System.in);
		
		String filename = input.nextLine();
		
		System.out.println(getSize(new File(filename)) + " bytes");
	}
	
	
	
	public static long getSize(File directory) {
		long size = 0;
		Queue<File> queue = new LinkedList<>();				//add directory to the queue;
		queue.add(directory);
		
		
		while (!queue.isEmpty()) {						//queue is not empty
			File t = queue.remove();		//Remove an item from the queue into t;
			
			if (t.isFile())			//if (t is a file)
				size += t.length();
			else {
				File[] files = t.listFiles();
                if (files != null) 
                	Collections.addAll(queue, files);;		//add all the files and subdirectories under t into the queue;
				}
			}
		return size;
		}
	
	
	
}
	
