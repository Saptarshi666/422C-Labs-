/* CRITTERS GUI <Critter4.java>
 * EE422C Project 5 submission by
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
package assignment5;
import javafx.scene.paint.Color;

/* Aggressive critter 2
 * Runs vertically across the board up/down randomly looking to fight and cause chaos
 */

public class Critter4 extends Critter {

	@Override
	/**
	 * run up if even random number, down if odd
	 */
	public void doTimeStep() {
		int randomNum = getRandomInt(10);
		if (randomNum % 2 == 0) {
			run(2);
		}
		
		else {
			run(6);
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
		return "4";
	}

	@Override
	public CritterShape viewShape() {
		return CritterShape.SQUARE;
	}
	
	@Override
	public javafx.scene.paint.Color viewOutlineColor() {
		return javafx.scene.paint.Color.DARKSEAGREEN;
	}
	
}