package Ch23_Sorting;

/*Java II, Dr. takyiu
Mack Cheng, April,4,2021

HW4:  calculate the number on the number spiral:
		1	2	9	19	25 . . . 
		2	3	8	11	24
		5	6	7	12	23
		16	15	14	13	22
		17	18	19	20	21
		.				  .
		.				    .
		.				      .
		example:	(2,3) is 8
					(4,2) is 15
goal: calculate (18273645,81726354) and (12345678,87654321).		

output: 
	Result: 
	6679196792954254	7683279977625364	
	*/
public class hw_Number_Spiral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("calculate (18273645,81726354) and (12345678,87654321): \nResult: ");
		System.out.print(get(18273645,81726354) + "\t" + get(12345678,87654321));
		
	}
	
	private static long get(long row, long col) {
		long max , min , result = 0 ;
		int maxIsRow = 0;
		
		if (row > col) {
			max = row;
			min = col;
			maxIsRow = 1;
			}
		else {
			max = col;
			min = row;
		}
		//(max%2 == 0 && maxIsRow == 1) || (max%2 == 1 && maxIsRow == 0 )
		if ( max%2 + maxIsRow == 1 ) 
			result = (long)Math.pow(max-1,2) + 2*max - min;
		else
			result = (long)Math.pow(max-1,2) + min;
		
		return result;
	}

}
