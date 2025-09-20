package anshu;
	import java.io.*;
public class CRC {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the generator:");
		String gen=br.readLine();
		System.out.println("Enter data:");
		String data =br.readLine();
		String code=data;
		while(code.length()<(data.length()+gen.length()))
			code=code+"0";
		code=data+div(code,gen);
		System.out.println("The generated :"+code);
		System.out.println(" received code:");
		String rec=br.readLine();
		if(Integer.parseInt(div(rec,gen))==0)
			System.out.println("System has  errors");
		else 
			System.out.println("System has no errors");
	}
	static String div(String num1,String num2) {
		int pointer =num2.length();
		String result=num1.substring(0,pointer);
		String remainder="";
		for(int i=0;i<num2.length();i++)
			if(result.charAt(i)==num2.charAt(i))
				remainder+="0";
			else
				remainder+="1";
		while(pointer<num1.length()) {
			if(remainder.charAt(0)=='0') {
				remainder=remainder.substring(1,remainder.length());
				remainder=remainder+String.valueOf(num1.charAt(pointer));
				pointer++;
			}
			result=remainder;
			remainder="";
			for(int i=0;i<num2.length();i++) {
				if(result.charAt(i)==num2.charAt(i))
					remainder+="0";
				else
					remainder+="1";
			}
		}
		return remainder.substring(1,remainder.length());
	}

}