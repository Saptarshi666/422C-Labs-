/*
 * CRITTERS Critter3.java
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


/* Indecisive Critter 2
 * Can't make up its mind to fight or move so it rolls its lucky dice to determine what to do
 * Only moves when the dice value is divisible by 2
 * Only fights when the dice value is divisible by 3
 */

public class Critter3 extends Critter {

	@Override
	/**
	 * walk in a random direction if both dice rolls are even
	 */
	public void doTimeStep() {
		int dice1 = getRandomInt(6);
		int dice2 = getRandomInt(6);
		
		if (dice1 %2== 0 && dice2 %2 == 0) {
			walk(getRandomInt(8));
		}
	}

	@Override
	/**
	 * @return true if both dice rolls are divisible by 3, false otherwise
	 */
	public boolean fight(String oponent) {
		int dice1 = getRandomInt(6);
		int dice2 = getRandomInt(6);		
		
		if (dice1 %3== 0 && dice2 %3== 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "3";
	}
}
