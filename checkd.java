import java.io.*;
import java.util.*;

class checkd{
	
	public static void main(String[] args)
	{
		String s="";
	try{
		File f = new File("check.txt");
		FileInputStream f1=new FileInputStream(f);
		byte []by=new byte[(int)f.length()];
		f1.read(by);
		s=new String(by);
		}
		catch(Exception e)
		{
			System.out.println("Exception");
		}
			System.out.println("Received Data: "+s);
			
			
			String[] s1=new String[(s.length()/8)+1];
		int i,j=0;
		for(i=0;j<s.length()/8;i=i+8)
		{
			s1[j]=s.substring(i,i+8);
			
			j++;
			
		}
		String ans=addition(s1);
		
		if(ans.equals("00000000"))
		{
			s=s.substring(0,s.length()-8);
			System.out.println("\n\nUnstuffed Data: "+s);
	}
	else{
		System.out.println("message error!");
	}
	}
	
	
	static String addition(String[] arr)
	{


		String res = "",helo="000000000";

	
		int d = 0,i;
		
	for(i=0;i<arr.length-1;i++)
	{		arr[i]="0"+arr[i];
		
		int k = helo.length() - 1, l = arr[i].length() - 1;
		while (k >= 0 || l >= 0 || d == 1) {

			
			d += ((k >= 0) ? helo.charAt(k) - '0' : 0);
			d += ((l >= 0) ? arr[i].charAt(l) - '0' : 0);

			
			res = (char)(d % 2 + '0') + res;

		
			d /= 2;

			
			k--;
			l--;
		}
		
		
		helo=res.substring(1,9);
		
	}
		if(helo.length()==8)
		{
			return helo;
		}
		else
		{
		helo=helo.substring(1,9);

		return helo;
		}
	}
}
	
	
	
