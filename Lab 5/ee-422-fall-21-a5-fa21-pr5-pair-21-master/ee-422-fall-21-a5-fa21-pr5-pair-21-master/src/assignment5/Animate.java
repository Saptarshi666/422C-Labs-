/* CRITTERS GUI <Animate.java>
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


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import assignment5.Critter.TestCritter;
import javafx.animation.AnimationTimer;
import javafx.collections.ObservableList;
import assignment5.Critter;
import assignment5.InvalidCritterException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;




public class Animate {
	Button start;
	Button stop;
	GridPane grid;
	GridPane butt;
	public static boolean started;
	public static int numAnimations = 0;
	
	
	
	public Animate(Button b,  GridPane buttonGrid, GridPane worldGrid) {
		this.grid = worldGrid;
		this.butt = buttonGrid;
		
		//get user num of animations
		TextField inputNum = new TextField();
		Text inputNumText = new Text();
		GridPane.setConstraints(inputNumText, 30, 70);
		GridPane.setConstraints(inputNum, 20, 70);
		//inputNum.setMinSize(50, 50);
		inputNum.setPromptText("How many time steps? ");
		//inputNum.setAlignment(Pos.BOTTOM_LEFT);
		
		
		//start
		this.start = new Button("Start Animation");
		GridPane.setConstraints(start, 0, 80);
	//	start.setMinWidth(50);
		//start.setMinHeight(50);
		//start.setAlignment(Pos.BOTTOM_CENTER);
		start.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				inputNumText.setText("");
				start.setDisable(true);
				numAnimations = Integer.parseInt(inputNum.getText());
				started = true;
				AnimationTimer at = new CritterAnimation(numAnimations);
				at.start();
				//disable the other buttons
				ObservableList<Node> buttons = buttonGrid.getChildren();
				for (Node n: buttons) {
					n.setDisable(true);
				}
				stop.setDisable(false);

			
			}
		});
		
		//stop
		stop = new Button("Stop Animation");
		GridPane.setConstraints(stop, 0, 90);

		stop.setDisable(true);
		//stop.setMinSize(50, 50);
	//	stop.setAlignment(Pos.BOTTOM_RIGHT);
		stop.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				inputNumText.setText("");
				started = false;
				start.setDisable(false);
				//put buttons back on screen
				//enable the other buttons
				ObservableList<Node> buttons = buttonGrid.getChildren();
				for (Node n: buttons) {
					n.setDisable(false);
					
				}
				stop.setDisable(true);

			}
		});
		
		
		buttonGrid.getChildren().addAll(start, stop,inputNumText,inputNum );
		
		
		
	}
	
	private class CritterAnimation extends AnimationTimer {
		public int numAnimations;
		public int numWait;
		public int currAnimations;
		
		public CritterAnimation(int num) {
			numAnimations = num;
			numWait = 0;
			currAnimations = 0;
		}
		
		
		@Override
		public void handle(long now) {
			if (started == false) {
				stop();
			}	
			numWait++;
			if (numWait > 50) {
				doHandle();
				numWait = 0;
				currAnimations++;
			}		
		}
		
		private void doHandle() {
			Critter.displayWorld(grid);
			for (int i = currAnimations; i < numAnimations; i++) {
				Critter.worldTimeStep();
			}
			
				//update the statline
				Main.updateStats();
			}
				
	}
}



