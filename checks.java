import java.io.*;
import java.util.*;
public class checks
{
	public static void main(String[] args)
	{
		Scanner in= new Scanner(System.in);
		String s;
		s=in.nextLine();
		int flag=0;
		
		String[] s1=new String[(s.length()/8)+1];
		
		int i,j=0;
		for(i=0;j<s.length()/8;i=i+8)
		{
			s1[j]=s.substring(i,i+8);
			System.out.println(s1[j]);
			j++;
			
		}
		if((s.length()%8)!=0)
		{
			flag=1;
			int a=8*(s.length()/8);
			int s2=s.length();
			s1[j]=s.substring(a,s.length());
			System.out.println(s1[j]);
			s=s.substring(0,a);
			a=s2-a;
			
			for(i=a;i<8;i++)
			{
				s1[j]="0"+s1[j];
			}
			s=s+s1[j];
		}
		System.out.println(s1[j]);
		
		String ans=addition(s1,flag);
		String two=twocomplement(ans);
		System.out.println("g: "+ans);
		s=s+two;
		 try{    
             FileOutputStream fout=new FileOutputStream("check.txt");
		     byte b[]=s.getBytes();			 
             fout.write(b);    
             fout.close();    
             System.out.println("success...");    
            }catch(Exception e){System.out.println(e);}    
          
		System.out.println("Transmitted Data is : "+s);
		
		
	
	}
	

	static String addition(String[] arr,int flag)
	{


		String res = "",helo="000000000";

	
		int d = 0,i;
		int m;
		if(flag==1)
			m=arr.length;
		else
			m=arr.length-1;
		
	for(i=0;i<m;i++)
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
	
	
	
	static char flip(char c)
    {
        return (c == '0') ? '1' : '0';
    }
	
	
	
	static String twocomplement(String bin)
	{
		int n = bin.length();
		int i;

		String ones = "", twos = "";
		ones = twos = "";

	
		for (i = 0; i < n; i++)
		{
			ones += flip(bin.charAt(i));
		}

		twos = ones;
		for (i = n - 1; i >= 0; i--)
		{
			if (ones.charAt(i) == '1')
			{
				twos = twos.substring(0, i) + '0' + twos.substring(i + 1);
			}
			else
			{
				twos = twos.substring(0, i) + '1' + twos.substring(i + 1);
				break;
			}
		}

		if (i == -1)
		{
			twos = '1' + twos;
		}

		return twos;
	}



	
	
}
		
		
		
		