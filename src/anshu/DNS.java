package anshu;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class DNS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc =new Scanner(System.in);
int n=0;
while(n!=2) {
		System.out.println("this list 1) DNS 2)Exit\n");
		System.out.println("Enter your choice");
		n=sc.nextInt();
		sc.nextLine();
		if(n==1) {
			System.out.println("Enter hostname");
			String host = sc.nextLine();
			InetAddress ad =null;
			try {
				ad=InetAddress.getByName(host);
				if(ad!=null) {
				System.out.println("The host name :"+ad.getHostName());
				System.out.println("The host Address:"+ad.getHostAddress());
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
		else if(n!=2) {
			System.out.println("Invalid choice\n");
		}
}
System.out.println(("BYE"));
	}

}
