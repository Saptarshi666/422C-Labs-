/* CRITTERS GUI <Main.java>
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

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import assignment5.Critter;
import assignment5.InvalidCritterException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class Main extends Application {
	private static String myPackage; // package of Critter file.
	static GridPane root = new GridPane();
	static GridPane root1 = new GridPane();
	
    /* Critter cannot be in default pkg. */
	static int i = 0;
	 private static HashMap<String,Text> Stats = new HashMap<>();
	 private static ArrayList<String> StatCritter = new ArrayList<>();
    static {
        myPackage = Critter.class.getPackage().toString().split(" ")[1];
    }

    public static void main(String[] args) {
         launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        // Creating a suitable container to hold the button and the window.
        // GridPane?
        // Define Text Field object, and define its value.
        // Add the Text Field object to the container defined above.
        // Define Increment Button to press to increment the counter.
        // Add the button to the container.
        // Add any other label etc.
        // Set an action for the Increment button by calling its setOnAction,
        // updating the counter.
        // primaryStage.setScene(new Scene(<container object>, 300, 250));
    	primaryStage.setTitle("Controller");
    	root.setPrefSize(1000, 1000);
    	Button btn = new Button();
    	Button btn1 = new Button();
    	Button btn2 = new Button();
    	Button btn3 = new Button();
    	Button btn4 = new Button();
    	Button btn5 = new Button();
    	Button btn6 = new Button();
    	Button btn7 = new Button();
    	btn.setText("Create");
    	btn1.setText("steps");
    	btn2.setText("clear");
    	btn3.setText("quit");
    	btn4.setText("stats");
    	btn5.setText("seed");
    	btn6.setText("show");
    	btn7.setText("animate");
    	TextField b = new TextField();
    	Text b1 = new Text();
    	GridPane.setConstraints(btn, 0,0);
    	GridPane.setConstraints(btn1, 0, 10);
    	GridPane.setConstraints(btn2, 0, 20);
    	GridPane.setConstraints(btn3, 0, 30);
    	GridPane.setConstraints(btn4, 0, 40);
    	GridPane.setConstraints(btn5, 0, 50);
    	GridPane.setConstraints(btn6, 0, 60);
    	GridPane.setConstraints(btn7, 0, 70);
    	GridPane.setConstraints(b, 20, 0);
    	GridPane.setConstraints(b1, 30, 0);
    	// root1.setPrefSize(500, 500);
    	Stage secondStage = new Stage(); // creates a second stage for the button
		secondStage.setTitle("Display World");
		Scene secondScene = new Scene(root1, 1000, 1000); // creates a second scene object with the Stackpane
		secondStage.setScene(secondScene); // puts the scene onto the second stage 
		secondStage.show();
    	 
		btn.setOnAction(new EventHandler<ActionEvent>() { //create button
    		 
             @Override
             public void handle(ActionEvent event) {
            	 b1.setText("");
                String a = b.getText();
               // root.getChildren().remove(b);
                String[]spacedinputs = a.split(" ");
                if (spacedinputs.length > 2) {
        			printErrorMsg(a,b1);
        		}
        		
        		else {
        			try {
        				doCreate(spacedinputs);
        			}
        			
        			catch (NumberFormatException | InvalidCritterException e) {
        				printErrorMsg(a,b1);
        			}
	
    			}
             }
         });
    	 
		btn1.setOnAction(new EventHandler<ActionEvent>() { //steps button
	    		 
             @Override
             public void handle(ActionEvent event) {
            	 b1.setText("");
                String a = b.getText();
                String[]spacedinputs = a.split(" ");
                if (spacedinputs.length > 1) {
        			printErrorMsg(a,b1);
        		}
        		
        		else {
        			
        			try {
        				doSteps(spacedinputs);
        			}
        			
        			catch (NumberFormatException n) {
        				printErrorMsg(a,b1);
        			}
        			
        			
        		}
             }
         });
		btn2.setOnAction(new EventHandler<ActionEvent>() {  //clear world button
		    @Override
		    public void handle(ActionEvent event) {  	 
		       Critter.clearWorld();
		    }
		});
		
		btn3.setOnAction(new EventHandler<ActionEvent>() { //quit button
		    @Override
		    public void handle(ActionEvent event) { 	 
		      System.exit(0);
		    }
		});
		
		btn4.setOnAction(new EventHandler<ActionEvent>() { //stats button
		    @Override
		    public void handle(ActionEvent event) {
		    	b1.setText("");
		       String a = b.getText();
		       String[]spacedinputs = a.split(" ");
		       if (spacedinputs.length != 1) {
					printErrorMsg(a,b1);
				}
				
				else {
					
					try {
						doStats(spacedinputs[0]);
					}		
					catch (InvalidCritterException | ClassNotFoundException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
						printErrorMsg(a,b1);
					}
					
				}
					
		    }
		});
		
		btn5.setOnAction(new EventHandler<ActionEvent>() { //set seed button
			 
		    @Override
		    public void handle(ActionEvent event) {
		    	b1.setText("");
		       String a = b.getText();
		       root.getChildren().remove(b);
		       String[]spacedinputs = a.split(" ");
		       try {
		    	   Critter.setSeed(Integer.parseInt(spacedinputs[0]));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoClassDefFoundError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		});
		
		btn6.setOnAction(new EventHandler<ActionEvent>() { //display world (show) button
			 
		    @Override
		    public void handle(ActionEvent event) {
		    	b1.setText("");
		 
		       try {
		    	   Critter.displayWorld(root1);
		    	
		 
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoClassDefFoundError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		});
		
		btn7.setOnAction(new EventHandler<ActionEvent>() { //animation button
			@Override
			public void handle(ActionEvent event) {
				b1.setText("");
				doAnimation(btn7, root, root1);
			}
		});
	    /* root.getChildren().add(btn);
	     root.getChildren().add(btn1);
	     root.getChildren().add(btn2);
	     root.getChildren().add(btn3);
	     root.getChildren().add(btn4);
	     root.getChildren().add(btn5);
	     root.getChildren().add(btn6);*/
		root.getChildren().addAll(btn,btn1,btn2,btn3,btn4,btn5,btn6,btn7,b,b1);
	    // root.getChildren().add(label);
	     primaryStage.setScene(new Scene(root, 750, 750));
	     primaryStage.show();
    }
    
    private static void doCreate(String[] input) throws NumberFormatException, InvalidCritterException, NoClassDefFoundError {
    	
		if (input.length == 1) {
			Critter.createCritter(input[1]);
		}
		
		else {
			for (int i = 0; i < Integer.parseInt(input[1]); i++) {
				Critter.createCritter(input[0]);
			}
		}
    }
    
    private static void doSteps(String[] input) throws NumberFormatException{

	 if(input[0].equals("")) {
			Critter.worldTimeStep();
		}
	
	 else if (Integer.parseInt(input[0])>0) {
			for (int i = 0; i < Integer.parseInt(input[0]); i++) {
				Critter.worldTimeStep();
			}
		}
		 
    }
    
    private static void doStats(String className) throws InvalidCritterException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException  {
	 	List<Critter> classInstances = Critter.getInstances(className);
	 	Class<?>[] critterType = {List.class};
	 	Method runStats = Class.forName(myPackage + "." + className).getMethod("runStats", critterType);
	 	String a = (String) runStats.invoke(null, classInstances);
	 	Text b = new Text();
	 	GridPane.setConstraints(b, 100, 100+i);
	 	i++;
	 	b.setText(a);
	 	root.getChildren().add(b);
	 	addStats(className,b);
    }
 
    private static void printErrorMsg(String input,Text b1) {
	   	//System.out.println("error processing: " + input);
		 b1.setText("error processing: " + input);
    }   
    
    public static void addStats(String a, Text b) {
	 	Stats.put(a, b);
		StatCritter.add(a);   
    }
 
    private static void doAnimation(Button b, GridPane buttonGrid, GridPane worldGrid) {
    	Animate ani = new Animate(b, buttonGrid, worldGrid);
    }
 
 
 
    public static void updateStats() {
		for(int i = 0; i<StatCritter.size(); i++) {
			String className = StatCritter.get(i);
			
		 	String a = null;
			try {
				a = doStats1(className);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidCritterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 	Text b = Stats.get(className);
		 	b.setText(a);
		} 
    }
    
    private static String doStats1(String className) throws InvalidCritterException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException  {
	 	List<Critter> classInstances = Critter.getInstances(className);
	 	Class<?>[] critterType = {List.class};
	 	Method runStats = Class.forName(myPackage + "." + className).getMethod("runStats", critterType);
	 	String a = (String) runStats.invoke(null, classInstances);
	 	return a;
    }
}

