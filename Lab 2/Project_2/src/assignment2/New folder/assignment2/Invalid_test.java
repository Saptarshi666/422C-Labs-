package assignment2;

public class Invalid_test {
 public int invalid_length(String d, String c) {
	 if(d.length() != c.length())
	 {
		 System.out.println();
		 System.out.println("INVALID_GUESS");
			//System.out.println();
			return 5;
	 }
	 else
		 return 0;
 }
 public int check_upper(String d)
 {
	 char[] g = d.toCharArray();
		for(int i=0;i<g.length;i++)
		{
			if(!Character.isUpperCase(g[i]))
				{
				System.out.println();
				System.out.println("INVALID_GUESS");
				//System.out.println();
				return 5;
				}
		}
	return 0;	
 }

}
