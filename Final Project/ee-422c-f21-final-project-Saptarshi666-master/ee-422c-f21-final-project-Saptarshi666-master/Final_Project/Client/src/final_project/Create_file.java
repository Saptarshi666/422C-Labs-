
// Copy-paste this file at the top of every file you turn in.
/*
* EE422C Final Project submission by
* Replace <...> with your actual data.
* Saptarshi Mondal	
* sm72999
* 17810
* Spring 2021
* Slip Day : 1
*/
package final_project;

import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;

public class Create_file {
	private String a;
	private String b;
	private String c;
	
	public void initialize(String a, String b, String c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public void main() {
	    try {
	    	String d =  a+".txt";
	      File myObj = new File(a);
	      if (myObj.createNewFile()) {
	    	  FileWriter name = new FileWriter(myObj,true);
	    	  BufferedWriter bw = new BufferedWriter(name);
	    	  long count = b.chars().filter(ch -> ch == '.').count();
	    	  if(count>1)
	    	  {
	    	  String[] arrOfStr = b.split(".", -2);
	    	  int i = 0; 
	    	  while(i<arrOfStr.length)
	    	  {
	    		  String[] arrOfStr1 = arrOfStr[i].split(" ",-2);
	    		  if(arrOfStr1[0].equals(a))
	    		  {   bw.newLine();
	    			  bw.write(arrOfStr[i]);
	    		  }
	    		  i++;
	    	  }
	    	  }
	    	  else
	    	  {   bw.newLine();
	    		  bw.write(b);
	    	  }
	    	  bw.close();
	    	  name.close();
	        
	      } else {
	    	  FileWriter name = new FileWriter(myObj,true);
	    	  BufferedWriter bw = new BufferedWriter(name);
	    	  long count = b.chars().filter(ch -> ch == '.').count();
	    	  if(count>1)
	    	  {
	    	  String[] arrOfStr = b.split(".", -2);
	    	  int i = 0; 
	    	  while(i<arrOfStr.length)
	    	  {
	    		  String[] arrOfStr1 = arrOfStr[i].split(" ",-2);
	    		  if(arrOfStr1[0].equals(a))
	    			  {
	    			  bw.newLine();
	    			  bw.write(arrOfStr[i]);
	    			  }
	    		  i++;
	    	  }
	    	  }
	    	  else
	    	  {
	    		  bw.newLine();
	    		  bw.write(b);
	    	  }
	    	  bw.close();
	    	  name.close();
	        
	      }
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }
}

