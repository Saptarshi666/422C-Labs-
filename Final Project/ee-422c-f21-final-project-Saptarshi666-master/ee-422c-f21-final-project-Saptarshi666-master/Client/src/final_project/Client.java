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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import final_project.Create_file;
//import ChatClient.IncomingReader;
import javafx.application.Application;
import java.nio.file.Paths;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Client extends Application { 
	// I/O streams 
	//ObjectOutputStream toServer = null; 
	//ObjectInputStream fromServer = null;
	BufferedReader reader;
	PrintWriter writer;
	Text b4 = new Text();
	String nam;
	HashMap<String,Double> disp_bid = new HashMap<>();
	GridPane mainPane = new GridPane(); 
	HashMap<String,Text> update = new HashMap<>();
	HashMap<String,Text> update1 = new HashMap<>();
	Text b6 = new Text();
	Text b7 = new Text();
	Text b8 = new Text();
	Text wronguser= new Text();
	TextField b = new TextField();
	TextField b1 = new TextField();
	int p = 0;
	HashMap<String,Double> bought = new HashMap<>();
	@Override
	public void start(Stage primaryStage) { 
		
		// Create a scene and place it in the stage 
	//	mainPane.getStylesheets().add("TextField.css");
		Scene scene = new Scene(mainPane, 1000, 1000); 
		mainPane.setPrefSize(1000, 1000);
		primaryStage.setTitle("Client"); // Set the stage title 
		primaryStage.setScene(scene); // Place the scene in the stage 
		primaryStage.show(); // Display the stage 
		Text b2 = new Text();
		Text b3 = new Text();
		b6.setText("");
		b7.setText("");
		
	//	b1.getStyleClass().add("hidden");
		//Text b4 = new Text();
		Button btn = new Button();
		Button btn5 = new Button();
		Button log = new Button();
		log.setText("New User?register");
		btn5.setText("Exit");
		btn.setText("Enter");
		GridPane.setConstraints(log, 20, 0);
		GridPane.setConstraints(wronguser, 30, 0);
		GridPane.setConstraints(b2, 0,0);
		GridPane.setConstraints(b, 10,0 );
		GridPane.setConstraints(b3, 0, 10);
		GridPane.setConstraints(b1, 10, 10);
		GridPane.setConstraints(btn, 5, 20);
		GridPane.setConstraints(b4,5,30 );
		GridPane.setConstraints(btn5,1000,1000 );
		GridPane.setConstraints(b6, 0, 200);
		GridPane.setConstraints(b7, 10, 200 );
		GridPane.setConstraints(b8, 60,150);
		mainPane.setStyle("-fx-background-color: #C0C0C0;");
		b2.setText("Username");
		b3.setText("Password");
		b6.setWrappingWidth(100);
		b7.setWrappingWidth(100);
		Media media = null;
		try {
		  media = new Media(getClass().getResource("music.mp3").toURI().toString());
		  MediaPlayer mp = new MediaPlayer(media);
	      mp.stop();
	      mp.setStartTime(new Duration(1000));
		  mp.play();
		} catch (URISyntaxException e) {
		  e.printStackTrace();
		}
	
		try { 
			@SuppressWarnings("resource")
			Socket sock = new Socket("127.0.0.1", 8000);
			InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(streamReader);
			writer = new PrintWriter(sock.getOutputStream());
		//	System.out.println("networking established");
			Thread readerThread = new Thread(new IncomingReader());
			readerThread.start();
		} 
		catch (IOException ex) { 
			ex.printStackTrace();
		}
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				wronguser.setText("");
				String a = b.getText();
				if(!a.equals("Guest"))
				{
				String c = b1.getText();
				String d = a +" " + c+"!";
				nam = b.getText();
				b4.setText("");
				b.setText("");
				b1.setText("");
				b8.setText("");
				writer.println(d);
				writer.flush();
				}
				else
				{
					a = a+ " " + "!";
					nam = b.getText();
					b4.setText("");
					b.setText("");
					b1.setText("");
					writer.println(a);
					writer.flush();
				}
			}
		});
		btn5.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(p == 1 || bought.isEmpty())
				System.exit(0);
				else
				{
					p = 1;
					Logistics logistics = new Logistics();
					logistics.initialize(bought);
					Stage secondStage = new Stage();
					logistics.start(secondStage);
					//bought.clear();
				}
			}
		});
		log.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String a = b.getText();
				String a1 = b1.getText();
				b.setText("");
				b1.setText("");
				a = a+ " " + a1 +"@";
				writer.println(a);
				writer.flush();
			}
		});
		mainPane.getChildren().addAll(b2,b3,b,b1,btn,b4,btn5,b6,b7,b8,log,wronguser);
	}
	private void displaybid1(HashMap<String,Double>a)
	{ 
		Iterator hmIterator = a.entrySet().iterator();
		Text a3 = new Text();
		Text a4 = new Text();
		Text a5 = new Text();
		Text a7 = new Text();
		GridPane.setConstraints(a3,0,35);
		GridPane.setConstraints(a4, 10,35);
		GridPane.setConstraints(a7, 20, 35);
		GridPane.setConstraints(a5, 30, 35);
		a3.setText("Name");
		a4.setText("Starting price");
		a5.setText("Buy now Price");
		a7.setText("Current Price");
		int x = 45,y=0;
		Platform.runLater(() -> {
			mainPane.getChildren().addAll(a3,a4,a5,a7);
			}
			);
		int x1 = 0;
		while(hmIterator.hasNext())
		{
			Map.Entry mapElement = (Map.Entry)hmIterator.next();
			Text a1 = new Text();
			Text a2 = new Text();
			Text a6 = new Text();
			Text a8 = new Text();
			if(x1%2 == 0)
			a1.setText((String) mapElement.getKey() + "(Pink)");
			else
			a1.setText((String) mapElement.getKey() + "(Green)");	
			a2.setText(String.valueOf(mapElement.getValue()));
			a8.setText(String.valueOf(mapElement.getValue()));
			GridPane.setConstraints(a1, y,x);
			GridPane.setConstraints(a2, y+10,x);
			GridPane.setConstraints(a8, y+20, x);
			GridPane.setConstraints(a6, y+30, x);
			a6.setText("1000.0");
			update.put((String) mapElement.getKey(), a2);
			update1.put((String) mapElement.getKey(), a8);
			x = x + 10;
			Platform.runLater(() -> {
				mainPane.getChildren().addAll(a1,a2,a6,a8);
				}
				);

		x1++;	
		}
	}
	private void displaybid(String message)
	{
		message = message.replace("{", "");
		message = message.replace("}", "");
		message = message.replaceAll(" ", "");
		message = message.replace("!", "");
		String[] arrOfStr = message.split(",", -2);
		int i = 0;
		while(i<arrOfStr.length)
		{
			String[] b = arrOfStr[i].split("=", -2);
			double a = Double.parseDouble(b[1]);
			disp_bid.put(b[0], a);
			i++;
		}
		displaybid1(disp_bid);
		//TextField a3 = new TextField();
		  final ComboBox a3 = new ComboBox();
	        a3.getItems().addAll(
	            "Shirt",
	            "Pant",
	            "Saree",
	            "Suit",
	            "Skirt"
	        );
		TextField a4 = new TextField();
		GridPane.setConstraints(a3, 0,105);
		GridPane.setConstraints(a4, 10,105);
		Button btn1 = new Button();
		btn1.setText("Enter");
		Button btn2 = new Button();
		btn2.setText("Receipt");
		Button btn3 = new Button();
		btn3.setText("Payment");
		GridPane.setConstraints(btn1,20,100);
		GridPane.setConstraints(btn2, 40, 100);
		GridPane.setConstraints(btn3, 60, 100);
		Platform.runLater(() -> {
			Image image1 = new Image("img/pant_green.png",100,100,false,false);
			Image image2 = new Image("img/pink_skirt.png",100,100,false,false);
			Image image3 = new Image("img/saree_pink.png",100,100,false,false);
			Image image4 = new Image("img/shirt_pink.png",100,100,false,false);
			Image image5 = new Image("img/suit_green.png",100,100,false,false);
			ImageView Image1 = new ImageView(image1);
			ImageView Image2 = new ImageView(image2);
			ImageView Image3 = new ImageView(image3);
			ImageView Image4 = new ImageView(image4);
			ImageView Image5 = new ImageView(image5);
			GridPane.setConstraints(Image1,100,100);
			GridPane.setConstraints(Image2,200,100);
			GridPane.setConstraints(Image3,100,200);
			GridPane.setConstraints(Image4,200,200);
			GridPane.setConstraints(Image5,100,300);
			mainPane.getChildren().addAll(a3,a4,btn1,btn2,btn3,Image1,Image2,Image3,Image4,Image5);
			btn1.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					String a = (String) a3.getValue();
					String c = a4.getText();
					String d = a +" " + c;
					b4.setText("");
					a3.setPromptText("");
					b4.setText("");
					
					writer.println(d);
					writer.flush();
				}
			});
			btn2.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					Create_file create_file = new Create_file();
					create_file.initialize(nam, b6.getText(), b7.getText());
					create_file.main();
				}
			});
			btn3.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					p = 1;
					Logistics logistics = new Logistics();
					logistics.initialize(bought);
					Stage secondStage = new Stage();
					logistics.start(secondStage);
					//bought.clear();
				}
			});
			}
			);
		
	}
	private void updateddisp(String message)
	{   b8.setText("");
		message = message.substring(0, message.length()-2);
		String[] arrOfStr = message.split(" ", -4);
		String b = arrOfStr[4];
		Double c = Double.parseDouble(arrOfStr[6]);
		if(arrOfStr[0].equals(nam))
			bought.put(b, c);
		Text a = update.get(b);
		a.setText(message);
		b6.setText(b6.getText() + " " + message );
		b7.setText(b7.getText() + " "+ message);
	}
	private void updatedisp1(String message)
	{    b8.setText("");
	message = message.substring(0, message.length()-2);
		b6.setText(b6.getText() + " " + message );
		b7.setText(b7.getText() + " "+ message);
		String[] arrOfStr = message.split(" ", -4);
		Text a = update1.get(arrOfStr[6]);
		a.setText(arrOfStr[8]+".0");
	}
	private void updatedisp2(String message)
	{b8.setText("");
	message = message.substring(0, message.length()-2);
		b6.setText(b6.getText() + " " + message );
	}
	private void updateddisp3(String message)
	{
		message = message.substring(0, message.length()-2);
		if(message.equals("The account has been created"))
		{
			wronguser.setText(message);
			b.setText("");
			b1.setText("");
		}
		else
		{
			wronguser.setText(message);
			b.setText("");
			b1.setText("");
		}
	}
	class IncomingReader implements Runnable {
		public void run() {
			String message;
			try {
				while ((message = reader.readLine()) != null) {
					if(message.charAt(message.length()-1)=='!')
						 displaybid(message);
					else if(message.charAt(message.length()-1) == '@')
						updateddisp(message);
					else if(message.charAt(message.length()-1) == '#')
						updatedisp1(message);
					else if(message.charAt(message.length()-1)=='$')
						updatedisp2(message);
					else if (message.charAt(message.length()-1)=='%')
							updateddisp3(message);
					else
						b8.setText(message);
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}