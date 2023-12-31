/*
 * CRITTERS Critter1.java
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


/* Aggressive critter - 
 * Runs horizontally across the board left/right randomly looking to fight and cause chaos
 */

public class Critter1 extends Critter {

	@Override
	/**
	 * run right if random number is even, left if odd
	 */
	public void doTimeStep() {
		int randomNum = getRandomInt(10);
		if (randomNum % 2 == 0) {
			run(0);
		}
		
		else {
			run(4);
		}
	}

	@Override
	/**
	 * @return true always
	 */
	public boolean fight(String oponent) {
		return true;
	}
	
	@Override
	public String toString() {
		return "1";
	}
}
