package final_project;

import java.util.HashMap;
import java.util.Iterator;
//Copy-paste this file at the top of every file you turn in.
/*
* EE422C Final Project submission by
* Replace <...> with your actual data.
* Saptarshi Mondal	
* sm72999
* 17810
* Spring 2021
* Slip Day : 1
*/
import java.util.Map;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Logistics extends Application {
private HashMap<String,Double> a = new HashMap<>();
GridPane mainpane = new GridPane();
int x = 0;
void initialize(HashMap<String, Double> a)
{
	this.a = a;
	
}
public void start(Stage PrimaryStage)
{
	Scene scene = new Scene(mainpane,500,500);
	mainpane.setPrefSize(500, 500);
	PrimaryStage.setTitle("PayMent/Logistics"); // Set the stage title 
	PrimaryStage.setScene(scene); // Place the scene in the stage 
	PrimaryStage.show(); // Display the stage 
    int y = 0,i=0;
    Iterator hmIterator = a.entrySet().iterator();
    mainpane.setStyle("-fx-background-color: #C0C0C0;");
    while(hmIterator.hasNext())
	{
		Map.Entry mapElement = (Map.Entry)hmIterator.next();
		Text b = new Text();
		Text c = new Text();
		b.setText((String) mapElement.getKey());	
		c.setText(String.valueOf(mapElement.getValue()));
		GridPane.setConstraints(b, y,x);
		GridPane.setConstraints(c, y+10,x);
		mainpane.getChildren().addAll(b,c);
		x = x + 10;	
	}
    x = x+10;
	Text a = new Text();
	a.setText("CardNumber:");
	TextField b = new TextField();
	GridPane.setConstraints(a,y, x);
	mainpane.getChildren().addAll(a);
	GridPane.setConstraints(b,y+10,x);
	mainpane.getChildren().addAll(b);
	Text a1 = new Text();
	GridPane.setConstraints(a1, y+20, x);
	mainpane.getChildren().addAll(a1);
	x = x +10;
	Text c = new Text();
	c.setText("Security Number:");
	TextField d = new TextField();
	GridPane.setConstraints(c,y, x);
	mainpane.getChildren().addAll(c);
	GridPane.setConstraints(d,y+10,x);
	mainpane.getChildren().addAll(d);
	Text c1 = new Text();
	GridPane.setConstraints(c1, y+20, x);
	mainpane.getChildren().addAll(c1);
	x = x+10;
	Text e = new Text();
	e.setText("Good Through:");
	TextField f = new TextField();
	GridPane.setConstraints(e,y, x);
	mainpane.getChildren().addAll(e);
	GridPane.setConstraints(f,y+10,x);
	mainpane.getChildren().addAll(f);
	Text e1 = new Text();
	GridPane.setConstraints(e1,y+20, x);
	mainpane.getChildren().addAll(e1);
	x = x+ 10;
	Text g = new Text();
	g.setText("Address");
	TextField h = new TextField();
	GridPane.setConstraints(g,y, x);
	mainpane.getChildren().addAll(g);
	GridPane.setConstraints(h,y+10,x);
	mainpane.getChildren().addAll(h);
	Text g1 = new Text();
	GridPane.setConstraints(g1,y+20, x);
	mainpane.getChildren().addAll(g1);
	x = x+ 10;
	Text j = new Text();
	j.setText("Delieverd by");
	GridPane.setConstraints(j,y,x);
	mainpane.getChildren().addAll(j);
	final ComboBox k = new ComboBox();
    k.getItems().addAll(
        "1 day",
        "2 days",
        "3 days",
        "5 days",
        "1 week",
        "2 weeks"
    );
    GridPane.setConstraints(k,y+10,x);
    mainpane.getChildren().addAll(k);
    x = x+ 10;
    Button btn1 = new Button();
    mainpane.getChildren().addAll(btn1);
    GridPane.setConstraints(btn1,10,x);
    btn1.setText("Final Cost");
	btn1.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			a1.setText("");
			c1.setText("");
			e1.setText("");
			String num = b.getText();
			if(num.length()!=8)
				a1.setText("Invalid card number");
			else
			{
			num = d.getText();
			if(num.length()!=3)
				c1.setText("Invalid Security number");
			else
			{
			num = f.getText();
			if((num.charAt(2) != '/') &&( num.length()!=5))
				e1.setText("Invalid expiration date");
			else
			{
			String k1 = (String) k.getValue();
			double a = calculate(k1);
			Button btn2 = new Button();
			btn2.setText("Pay");
			x = x+ 10;
			GridPane.setConstraints(btn2,10,x);
			Text l = new Text();
			x = x+ 10;
			GridPane.setConstraints(l,10,x);
			Platform.runLater(() -> {
				mainpane.getChildren().addAll(btn2,l);
				btn2.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						l.setText("Your final cost is " + a + " dollars.You may close the window");
					}
				});
				
				});
			}
			}
			}
		}
	});
	//mainpane.getChildren().addAll(a,b,a1,c,d,c1,d,e,f,g,h,g1,k/*,btn1*/);
}
private double calculate(String k1)
{
	double a1 = 0;
	Iterator hmIterator = a.entrySet().iterator();
    while(hmIterator.hasNext())
	{
		Map.Entry mapElement = (Map.Entry)hmIterator.next();
	 a1 = a1 + (double) mapElement.getValue();		
	}
    if (k1.equals("1 day"))
    	return a1 + (0.7*a1);
    else  if (k1.equals("2 days"))
    	return a1 + (0.6*a1);
    else  if (k1.equals("3 days"))
    	return a1 + (0.5*a1);
    else  if (k1.equals("5 days"))
    	return a1 + (0.4*a1);
    else  if (k1.equals("1 week"))
    	return a1 + (0.2*a1);
    else  
    	return a1 ;
}
}
