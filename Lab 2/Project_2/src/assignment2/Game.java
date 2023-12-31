package assignment2;

public class Game {
	History stor;
	String[] colorcheck;
public Game(String b,int f) {
		stor = new History(f);
	}
public void gameconfigcolourcheck(String[] x)
{
	colorcheck = x; 
}
public int checkcolor(String x)
{
	for(int i = 0; i<x.length();i++)
	{
		int j = 0,n=0;
		while(j<colorcheck.length)
		{
			String a = colorcheck[j];
			char b = a.charAt(0);
			if(x.charAt(i) == b)
			{
				break;
			}
			else
				n++;
		j++;	
		}
		if(n==colorcheck.length)
			return 5;
	}
	return 0;
}
public int runGame(String d, String c) {
	int b=0,w=0,x = d.length();
	if(d.equals("HISTORY"))
	{
		stor.recall();
		return 6;
	}
	Invalid_test cd = new Invalid_test();
	int c1 = cd.check_upper(d);
	if(c1 == 5)
		return 5;
	c1 = cd.invalid_length(d, c);
	if(c1 == 5)
		return 5;
	else {
		
		int ab = checkcolor(d);
		if(ab == 5)
			{
			System.out.println();
			System.out.println("INVALID_GUESS");
			System.out.println();
			return 5;
			}
		else
		{
			String temp1 = "";
			String temp2 = "";
		   for(int i = 0; i<c.length(); i++)
		   {
			   if(d.charAt(i)== c.charAt(i))
			   { 
				   b++; 
			   }
			   else
			   {
				   temp1 = temp1 + d.charAt(i);
				   temp2 = temp2 + c.charAt(i);
			   }
		   }
		  for(int i = 0; i<temp2.length();i++ )
		  {
			   int j=0;
			   while(j<temp1.length())
			   {
				   if(temp1.charAt(j)==temp2.charAt(i))
				   {
					   String jh = temp1.substring(j, j+1);
					   temp1 = temp1.replaceFirst(jh,"");
					   w++;
					   break;
				   }
				   j++;
			   }
		  }
		  
		    System.out.println(d+" -> " + b +"b_"+w +"w");
		    }
	}
	stor.addinfor(d, b, w);
	if(b == x)
    	return 1;
    else
    	return 0;
	
}
}
