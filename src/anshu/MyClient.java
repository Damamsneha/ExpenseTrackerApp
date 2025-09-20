package anshu;
import java.io.*;
import java.net.Socket;
public class MyClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	Socket s=new Socket("localhost",666);
	DataOutputStream dout=new DataOutputStream(s.getOutputStream());
	dout.writeUTF("hello");
	dout.flush();
	dout.close();
	s.close();
}
catch(Exception e) {
	System.out.println(e);
}
	}

}
