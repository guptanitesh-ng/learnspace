package concepts;

import java.util.Scanner;

public class Substraction {
	public int substract(int a, int b)
	{
		if (a>b)
		{
			return a-b;
		}
		else
			return -1;
	}
	public static void main (String args[])
	{
		Substraction sub= new Substraction();
		System.out.println("enter the no. a:");
	   
		Scanner s=new Scanner(System.in);
	int	a=s.nextInt();
	 System.out.println("enter the no. b:");
	int	b=s.nextInt();
	
    System.out.println("a-b="+ sub.substract(a,b));
	}
	

}
