/*
 * EE422C Project 2 (Mastermind) submission by
 * Replace <...> with your actual data. 
 * Saptarshi mondal
 * sm72999
 * Slip days used: <0>
 * Spring 2021
 */
package assignment2;
/*
 * Mastermind
 * Jun 14, 2021
 */

package assignment2;

import java.util.Scanner;
import assignment2.Game;
import assignment2.GameConfiguration;
import assignment2.SecretCodeGenerator;
import assignment2.History;
//import static org.junit.Assert.*;

public class Driver {
    public static void main(String[] args) {
      //   Use this for your testing.  We will not be calling this method.
    //	String[] str = {"R","G","B","Y"};
    	GameConfiguration a = new GameConfiguration(0, args, 0);
        SecretCodeGenerator b = new SecretCodeGenerator(a);
    	start(false,a,b);
    }

    public static void start(Boolean isTesting, GameConfiguration config, SecretCodeGenerator generator) {
        // TODO: complete this method
		// We will call this method from our JUnit test cases.
    	Scanner a = new Scanner(System.in);
    	int e = 12,bh = 0;
    	System.out.print("Welcome to Mastermind.");
    	System.out.println();
    	System.out.print("Do you want to play a new game? (Y/N):");
    	System.out.println();
    	String d = a.next();
    	if(d.equals("Y"))
    	{
    		do{
    		String c  = generator.getNewSecretCode();
    		int f = config.guessNumber;
    		//String[] xi = config.colors;
    		if(isTesting == true)
    			{
    			System.out.println();
    			System.out.println("Secret Code: " + c);
    			//System.out.println();
    			}	
    		Game b = new Game(c,f);
    		b.gameconfigcolourcheck(config.colors);
    	    System.out.println();
    	    while(f > 0)
    		{
    	    System.out.println("You have " + f+ " guess(es) left.");   
    		System.out.print("Enter guess: ");
    		System.out.println();
    		d = a.next();
    		bh = b.runGame(d,c);
    		if(bh == 5 || bh == 6)
    		{
    			f++;
    		}
    		if(bh == 1)
    			break;
    		--f;
    		}
    	    if(bh == 1)
    	    {
    	    	//System.out.println();
    	    	System.out.println("You win!");
    	    	System.out.println();
    	    	System.out.println("Do you want to play a new game? (Y/N):");
    	    	//System.out.println();
    	    	d = a.next();
    	    }
    	    else
    	    {
    	    	//System.out.println();
    	    	System.out.println("You lose! The pattern was " + c);
    	    	System.out.println();
    	    	System.out.println("Do you want to play a new game? (Y/N):");
    	    	d = a.next();
    	    }
    		}while(d.equals("Y"));
    	}
    }
}
