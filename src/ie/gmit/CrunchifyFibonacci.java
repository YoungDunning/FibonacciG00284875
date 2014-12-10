package ie.gmit;

import java.util.Scanner;

public class CrunchifyFibonacci {
	public static void main(String[] args) {
		//Input to print Fibonacci series upto how many numbers
		System.out.println("Enter Number upto which Fibonacci Series");
		int number = new Scanner(System.in).nextInt();
		
		System.out.println("\n\nFibonacci Series upto" + number + " numbers:");
		//Printing Fibonacci series upto number
		for(int i=1; i<=number; i++)
		{
			System.out.println(fibonacciRecusion(i) + " ");
		}
	}
	
	//Java program for Fibonacci number using recursion
	public static int fibonacciRecusion(int number)
	{
		if(number == 1 || number ==2)
		{
			return 1;
		}
		
		return fibonacciRecusion(number-1) + fibonacciRecusion(number -2); //Tail Recursion
		
	}
	
	//Java program for Fibonacci number using loop
	public static int fibonacciLoop(int number)
	{
		if(number == 1 || number == 2)
		{
			return 1;
		}
		int fibo1=1, fibo2=1, fibonacci=1;
		for(int i =3; i<=number; i++)
		{
			fibonacci = fibo1 +fibo2;
			fibo1 = fibo2;
			fibo2 = fibonacci;
		}
		return fibonacci;
	}

	public String add(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
