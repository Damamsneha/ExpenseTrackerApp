package core_java;
import java.util.*;
public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num1,num2;
		System.out.println("Enter two numbers");
		num1=sc.nextInt();
		num2=sc.nextInt();
		System.out.println("Choose an operation\n1.Addition\n2.Subtraction\n3.Multiplication\n4.Division");
		int op=sc.nextInt();
		switch(op) {
		case 1:System.out.println(num1+num2);
				break;
		case 2:System.out.println(num1-num2);
				break;
		case 3:System.out.println(num1*num2);
				break;
		case 4:System.out.println(num1/num2);
				break;
		case 5:System.out.println("Please enter a valid operation");
				break;
		}
	}

}