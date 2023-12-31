/*
 * CRITTERS Critter2.java
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


/* Indecisive Critter
 * Can't make up its mind to fight or move so it rolls its lucky dice to determine what to do
 * Only moves/fights when it rolls snake eyes (two zeroes since rand returns int from 0 to max)
 */

public class Critter2 extends Critter {

	@Override
	/**
	 * move if both dice rolls are 0
	 */
	public void doTimeStep() {
		int dice1 = getRandomInt(6);
		int dice2 = getRandomInt(6);
		
		if (dice1 == 0 && dice2 == 0) {
			walk(getRandomInt(8));
		}
	}

	@Override
	/**
	 * fight if both dice rolls are 0
	 * @return true if both rolls are 0, false otherwise
	 */
	public boolean fight(String oponent) {
		int dice1 = getRandomInt(6);
		int dice2 = getRandomInt(6);		
		
		if (dice1 == 0 && dice2 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "2";
	}

}
