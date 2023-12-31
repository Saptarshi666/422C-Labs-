/*
 * CRITTERS Main.java
 * EE422C Project 4 submission by
 * Replace <...> with your actual data.
 * Samir Mohsin
 * ssm3392
 * 17830
 * Saptarshi Mondal
 * sm72999
 * 17810
 * Slip days used: <0>
 * Fall 2021
 */

package assignment4;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.*;

/*
 * Usage: java <pkg name>.Main <input file> test input file is
 * optional.  If input file is specified, the word 'test' is optional.
 * May not use 'test' argument without specifying input file.
 */

public class Main {

    /* Scanner connected to keyboard input, or input file */
    static Scanner kb;

    /* Input file, used instead of keyboard input if specified */
    private static String inputFile;

    /* If test specified, holds all console output */
    static ByteArrayOutputStream testOutputString;

    /* Use it or not, as you wish! */
    private static boolean DEBUG = false;

    /* if you want to restore output to console */
    static PrintStream old = System.out;

    /* Gets the package name.  The usage assumes that Critter and its
       subclasses are all in the same package. */
    private static String myPackage; // package of Critter file.

    /* Critter cannot be in default pkg. */
    static {
        myPackage = Critter.class.getPackage().toString().split(" ")[1];
    }

    /**
     * Main method.
     *
     * @param args args can be empty.  If not empty, provide two
     *             parameters -- the first is a file name, and the
     *             second is test (for test output, where all output
     *             to be directed to a String), or nothing.
     */
    public static void main(String[] args) {
        if (args.length != 0) {
            try {
                inputFile = args[0];
                kb = new Scanner(new File(inputFile));
            } catch (FileNotFoundException e) {
                System.out.println("USAGE: java <pkg name>.Main OR java <pkg name>.Main <input file> <test output>");
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("USAGE: java <pkg name>.Main OR java <pkg name>.Main <input file> <test output>");
            }
            if (args.length >= 2) {
                /* If the word "test" is the second argument to java */
                if (args[1].equals("test")) {
                    /* Create a stream to hold the output */
                    testOutputString = new ByteArrayOutputStream();
                    PrintStream ps = new PrintStream(testOutputString);
                    /* Save the old System.out. */
                    old = System.out;
                    /* Tell Java to use the special stream; all
                     * console output will be redirected here from
                     * now */
                    System.setOut(ps);
                }
            }
        } else { // If no arguments to main
            kb = new Scanner(System.in); // Use keyboard and console
        }
        commandInterpreter(kb);

        System.out.flush();
    }

    /* Do not alter the code above for your submission. */
    
    /**
     * Runs all the commands specified in lab doc
     * @param kb
     */
    private static void commandInterpreter(Scanner kb)  {
        //TODO Implement this method
    	String input;
    	
    	while (true) {
    		System.out.print("critters>");
        	input = kb.nextLine(); //get input and split into each seperate wore
        	String[] spacedInputs = input.split(" ");
        	
        	//make sure input is of correct command and also argument length, if not then print error or throw error appropirately 
        	if (spacedInputs[0].equals("quit")) {
        		if (spacedInputs.length != 1) {
        			printErrorMsg(input);
        		}
        		
        		else {
            		return;
        		}
        	}
        	
        	else if (spacedInputs[0].equals("show")) {
        		if (spacedInputs.length > 1) {
        			printErrorMsg(input);
        		}
        		
        		else {
            		Critter.displayWorld();
        		}
        	}
        	
        	else if (spacedInputs[0].equals("step")) {
        		if (spacedInputs.length > 2) {
        			printErrorMsg(input);
        		}
        		
        		else {
        			
        			try {
        				doSteps(spacedInputs);
        			}
        			
        			catch (NumberFormatException n) {
        				printErrorMsg(input);
        			}
        			
        			
        		}
        	}
        	
        	else if (spacedInputs[0].equals("seed")) {
        		if (spacedInputs.length > 2) {
        			printErrorMsg(input);
        		}
        		
        		else {
        			Critter.setSeed(Integer.parseInt(spacedInputs[1]));
        		}
        	}
        	
        	else if (spacedInputs[0].equals("create")) {
        		if (spacedInputs.length > 3) {
        			printErrorMsg(input);
        		}
        		
        		else {
        			try {
        				doCreate(spacedInputs);
        			}
        			
        			catch (NumberFormatException | InvalidCritterException e) {
        				printErrorMsg(input);
        			}
        			
        		
    			}
    		}
        	
        	
        	else if (spacedInputs[0].equals("stats")) {
        		if (spacedInputs.length != 2) {
        			printErrorMsg(input);
        		}
        		
        		else {
        			
        			try {
        				doStats(spacedInputs[1]);
        			}
        			
        			catch (InvalidCritterException | ClassNotFoundException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
        				printErrorMsg(input);
        			}
        			
        		}
        	}
        	
        	else if (spacedInputs[0].equals("clear")) {
        		if (spacedInputs.length != 1) {
        			printErrorMsg(input);
        		}
        		
        		else {
        			Critter.clearWorld();
        		}
        	}
        	
        	else {
        		System.out.println("invalid command: " + input);
        	}
        	    	
        	
    	}
    	
    	
    }
    
    
    /**
     * runs the create command from command interpreter
     * @param input
     * @throws NumberFormatException
     * @throws InvalidCritterException
     * @throws NoClassDefFoundError
     */
    private static void doCreate(String[] input) throws NumberFormatException, InvalidCritterException, NoClassDefFoundError {
    	
		if (input.length == 2) {
			Critter.createCritter(input[1]);
		}
		
		else {
			for (int i = 0; i < Integer.parseInt(input[2]); i++) {
				Critter.createCritter(input[1]);
			}
		}
    }
    
    
    /**
     * runs the steps command from the interpreter
     * @param input
     * @throws NumberFormatException
     */
    private static void doSteps(String[] input) throws NumberFormatException{

		if (input.length == 2) {
			for (int i = 0; i < Integer.parseInt(input[1]); i++) {
				Critter.worldTimeStep();
			}
		}
		
		else {
			Critter.worldTimeStep();
		}

    }
    
    /**
     * runs the stats command from the interpreter
     * @param className
     * @throws InvalidCritterException
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     */
    private static void doStats(String className) throws InvalidCritterException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException  {
    	List<Critter> classInstances = Critter.getInstances(className);
    	Class<?>[] critterType = {List.class};
    	Method runStats = Class.forName(myPackage + "." + className).getMethod("runStats", critterType);
    	runStats.invoke(null, classInstances);
    }
    
    /**
     * print error msg if user input is not able to be processed
     * @param input
     */
    private static void printErrorMsg(String input) {
      	System.out.println("error processing: " + input);
    }
}
