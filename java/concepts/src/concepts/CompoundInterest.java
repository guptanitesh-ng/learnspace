package concepts;

import java.util.Scanner;

public class CompoundInterest {
public static void main(String args[])
{
	CompoundInterest ci= new CompoundInterest();
	Scanner s= new Scanner(System.in);
	System.out.println("enter the principal");
	double p=s.nextDouble();
	System.out.println("enter the Rate Of Interest");
	double r=s.nextDouble();
	System.out.println("enter the Time");
	int n=s.nextInt();
	System.out.println("The Compound Interest CI="+ ci.compoundinterest(p,r,n));
	
}

public double compoundinterest(double p,double r,int n)
{
	
	return p* (Math.pow((1+r/100),n));

}
}
