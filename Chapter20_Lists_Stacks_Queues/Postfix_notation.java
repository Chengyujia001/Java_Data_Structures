package Chapter20_Lists_Stacks_Queues;

//Java II, Dr. takyiu
//Mack Cheng, March,7,2021

//writing expressions without using parentheses. 
//For example, the expression (1 + 2) * 3 would be written as 1 2 + 3 *
//
//Write a program to evaluate postfix expressions. Pass the expression as a command-line argument in one string.


//input: 3 4 + 10*
//ouput: 43.0

//input: (3 4 +) 10 *
//ouput: 70.0

import java.util.*;
public class Postfix_notation {
	public static void main(String[] args) {
		
		System.out.println("3 + 4*10 :\t" + evaluation("3 + 4*10 "));
		System.out.println("3 4 + 10 * :\t" + evaluation("3 4 + 10 * "));
		
		
		System.out.println("(3 + 4)*10 :\t" + evaluation("(3 + 4)*10 "));
		System.out.println("(3 4 +) 10 * :\t" + evaluation("(3 4 +) 10 * "));
		
	}
	
	
	public static double evaluation(String input) {
		Stack<Double> numberStack = new Stack<>();			//numberStack
		Stack<Character> operatorStack = new Stack<>();		//operatorStack
		
		input = rewrite(input);								//rewrite the input and take out spaces
		String[] tokens = input.split(" ");					//( 12 +3) ¡ú  (12+3)
		
		for (String token: tokens) {
			if (token.length() == 0)						// skip blank space
				continue;
			
			else if (token.charAt(0) == '+' || token.charAt(0) == '-') {			//+ or - scanned
				while (!operatorStack.isEmpty() &&
					(operatorStack.peek() == '+' || 
			           operatorStack.peek() == '-' ||
			           operatorStack.peek() == '*' ||
			           operatorStack.peek() == '/')) {
					calculation(numberStack, operatorStack);
			        }
			  
	        operatorStack.push(token.charAt(0));						// Push the + or - operator into the operator stack
	      }
			
			
	      else if (token.charAt(0) == '*' || token.charAt(0) == '/') {		// Process all *, / in the top of the operator stack 
	        while (!operatorStack.isEmpty() &&
	          (operatorStack.peek() == '*' ||
	          operatorStack.peek() == '/')) {
	        	calculation(numberStack, operatorStack);
	        }
	        operatorStack.push(token.charAt(0));					      // Push the * or / operator into the operator stack
	      }
			
	      else if (token.trim().charAt(0) == '(') {
	        operatorStack.push('('); // Push '(' to stack
	      }
	      else if (token.trim().charAt(0) == ')') {					        // Process all the operators in the stack until seeing '('
	        while (operatorStack.peek() != '(') {
	        	calculation(numberStack, operatorStack);
	        }
	        
	        operatorStack.pop();					 // Pop the '(' symbol from the stack
	      }
	      else { // An operand scanned
	        // Push an operand to the stack
	        numberStack.push(new Double(token));
	      }
		}
		
	    while (!operatorStack.isEmpty()) {
	    	calculation(numberStack, operatorStack);
	      }

		return numberStack.pop();
	}
	
	
	public static void calculation(Stack<Double> Tem_numberStack, Stack<Character> Tem_operatorStack) {
		char op = Tem_operatorStack.pop();
		double num1 = Tem_numberStack.pop();
		double num2 = Tem_numberStack.pop();
		
		switch (op) {
		case '+':
			Tem_numberStack.push(num1 + num2);			//process (+ - * / ), then put the result back to stack
            break;
		case '-':
			Tem_numberStack.push(num1 - num2);
            break;
		case '*':
			Tem_numberStack.push(num1 * num2);
            break;
		case '/':
			Tem_numberStack.push(num1 / num2);
            break;
		}
		
		
	}
	
	
	public static String rewrite(String s) {				//write input and insert blanks
		String result = "";
		for (int i = 0; i < s.length(); i++) {
		     if (s.charAt(i) == '(' || s.charAt(i) == ')' || 
		         s.charAt(i) == '+' || s.charAt(i) == '-' ||
		         s.charAt(i) == '*' || s.charAt(i) == '/')
		       result += " " + s.charAt(i) + " ";
		     else
		       result += s.charAt(i);
		   }
		return result;
	}
	
	
	

}
