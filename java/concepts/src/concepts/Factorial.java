package concepts;

import java.util.Scanner;

public class Factorial {
	int factorial(int n)
	{
	if(n==1)
		return 1;
	else
return n*factorial(n-1);
	}
	public static void main(String args[])
	{
Factorial f=new Factorial();
		System.out.println("enter the no.");
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		System.out.println("factorial of" +n+ "="+f.factorial(n));
		
	}
}
