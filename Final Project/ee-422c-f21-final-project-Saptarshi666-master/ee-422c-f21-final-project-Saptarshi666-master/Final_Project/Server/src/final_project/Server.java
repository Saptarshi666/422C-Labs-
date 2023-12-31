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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Scanner;

public class Server extends Observable  {
	private ArrayList<PrintWriter> clientOutputStreams;

	static HashMap<String,String> user_password = new HashMap<>();
	static ArrayList<Double> price_Item = new ArrayList<>(); 
	static ArrayList<String> Item_name = new ArrayList<>();
	static HashMap<String,Double> valid_bid = new HashMap<>();
	ArrayList<Double> minimum_bid = new ArrayList<>();
	static HashMap<String,Double> max_bid = new HashMap<>();
	static ArrayList<Double> maximum_bid = new ArrayList<>();
	static HashMap<PrintWriter,String> user_check = new HashMap<>();
	static HashMap<String,Double> min_bid = new HashMap<>();
	
	public static void main(String[] args) {
		Scanner name = null;
		try {
			name = new Scanner(new File("user_password.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Read1(name);
		/*user_password.put("Harry","Alpha");
		user_password.put("Louis","Beta");
		user_password.put("Jane","Gamma");
		user_password.put("John", "Jolie");*/
		
		try {
			name = new Scanner(new File("Valid_bid.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Read(name);
		try {
			new Server().setUpNetworking();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void setUpNetworking() throws Exception {
		clientOutputStreams = new ArrayList<PrintWriter>();
		@SuppressWarnings("resource")
		ServerSocket serverSock = new ServerSocket(8000);
		while (true) {
			Socket clientSocket = serverSock.accept();
		 Client_Observer writer = new Client_Observer(clientSocket.getOutputStream());
			//clientOutputStreams.add(writer);
this.addObserver(writer);
			Thread t = new Thread(new ClientHandler(clientSocket,writer));
			t.start();
		//	System.out.println("got a connection");
			System.out.println(t);
		}

	}
	private static void Read1(Scanner kb)
	{
		while(kb.hasNext())
		{
			String a = kb.next();
			String b=null,c= null;
					if(a.equals("Username:"))
					{
						b = kb.next();
					}
			a = kb.next();
			if(a.equals("Password:"))
			{
				c = kb.next();
			}
			user_password.put(b, c);
		}
	}
	private static void Read(Scanner kb) {
		while(kb.hasNext()) {
			String a = kb.next();
			if(a.equals("Item:"))
			{
				String b = kb.next();
				Item_name.add(b);
			}
			else if (a.equals("Price:"))
			{
				double b = kb.nextDouble();
				price_Item.add(b);
			}
			else if(a.equals("Max:"))
			{
				double b  = kb.nextDouble();
				maximum_bid.add(b);
			}
		}
		for(int i = 0; i<Item_name.size(); i++)
		{
			min_bid.put(Item_name.get(i), price_Item.get(i));
		}
		for(int i = 0 ; i<Item_name.size(); i++)
		{
			valid_bid.put(Item_name.get(i), price_Item.get(i));
		}
		for(int i = 0 ; i<Item_name.size(); i++)
		{
			max_bid.put(Item_name.get(i), maximum_bid.get(i));
		}
	}

	private void checkUsers(String message,PrintWriter clientwriter)
	{
		String[] arrOfStr = message.split(" ", -1);
		arrOfStr[1] = arrOfStr[1].replace("!", "");
		if(user_password.containsKey(arrOfStr[0])||arrOfStr[0].equalsIgnoreCase("Guest"))
		{
			if(arrOfStr[0].equalsIgnoreCase("Guest"))
			{
				user_check.put(clientwriter, arrOfStr[0]);
				String a = valid_bid.toString()+"!";
				clientwriter.println(a);
				clientwriter.flush();
			}
			else if(user_password.get(arrOfStr[0]).equals(arrOfStr[1]))
			{
				user_check.put(clientwriter, arrOfStr[0]);
				String a = valid_bid.toString()+"!";
				clientwriter.println(a);
				clientwriter.flush();

			}
			else
			{
				clientwriter.println("The password is incorrect");
				clientwriter.flush();
			}
		}
	}
	private void checkbid(String message,PrintWriter clientwriter)
	{
		String[] arrOfStr = message.split(" ", 2);
		double a = Double.parseDouble(arrOfStr[1]);
		if(valid_bid.containsKey(arrOfStr[0])&& max_bid.get(arrOfStr[0])<=a)
		{
			valid_bid.remove(arrOfStr[0]);
			String b = user_check.get(clientwriter);
			b = b +" has bought the " + arrOfStr[0] + " for " + arrOfStr[1] + " dollars. " + "@";
			setChanged();
			notifyObservers(b);
		}
		else if(valid_bid.containsKey(arrOfStr[0]) && a >= min_bid.get(arrOfStr[0]))
		{   if(a> valid_bid.get(arrOfStr[0]))
			{valid_bid.put(arrOfStr[0], a);
			String b = user_check.get(clientwriter);
			b = b + " has placed a bid for " + arrOfStr[0] + " for " + arrOfStr[1] + " dollars. " + "#";
			setChanged();
			notifyObservers(b);
			}
		else
		{
			String b = user_check.get(clientwriter);
			b = b + " has placed a bid for " + arrOfStr[0] + " for " + arrOfStr[1] + " dollars. " + "$";
			setChanged();
			notifyObservers(b);
		}
		}
		else if(a<=min_bid.get(arrOfStr[0]))
		{
			String message2 = "The bid is not enough";
			clientwriter.println(message2);
			clientwriter.flush();
		}
		else
		{
			String message2 = "The object has already been sold";
			clientwriter.println(message2);
			clientwriter.flush();
		}
	}


	private void notifyClients(String message) {


		for (PrintWriter writer : clientOutputStreams) {
			writer.println(message);
			writer.flush();
		}
	}
	private void addUser(String message,PrintWriter clientwriter)
	{
		File Obj = new File("user_password.txt");
		 try {
			if (Obj.createNewFile()) {
				  FileWriter name = new FileWriter(Obj,true);
				  BufferedWriter bw = new BufferedWriter(name);
				  String[] arrOfStr = message.split(" ", -1);
				  arrOfStr[1] = arrOfStr[1].replace("@", "");
				  if(!(user_password.containsKey(arrOfStr[0])&& user_password.get(arrOfStr[0]).equals(arrOfStr[1])))
				  { bw.newLine();
					  bw.write("Username:" + " " +arrOfStr[0]+ " " + "Password:"+" "+ arrOfStr[1]);
					  user_password.put(arrOfStr[0], arrOfStr[1]);
					//  name.close();
					  clientwriter.println("The account has been created.%");
					  clientwriter.flush();
				  }
				  else
				  {
					  clientwriter.println("The account already exists.%");
					  clientwriter.flush();
				  }
				  bw.close();
				  name.close();
			 }
			else
			{
				 FileWriter name = new FileWriter(Obj,true);
				 BufferedWriter bw = new BufferedWriter(name);
				  String[] arrOfStr = message.split(" ", -1);
				  arrOfStr[1] = arrOfStr[1].replace("@", "");
				  if(!(user_password.containsKey(arrOfStr[0])&& user_password.get(arrOfStr[0]).equals(arrOfStr[1])))
				  {
					  bw.newLine();
					  bw.write("Username:" + " " +arrOfStr[0]+ " " + "Password:"+" "+ arrOfStr[1]);
					 
					  clientwriter.println("The account has been created.%");
					  clientwriter.flush();
					  user_password.put(arrOfStr[0], arrOfStr[1]);
				  }
				  else
				  {
					  clientwriter.println("The account already exists.%");
					  clientwriter.flush();
				  }
				  bw.close();
				  name.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	class ClientHandler implements Runnable {
		private BufferedReader reader;
		private PrintWriter clientwriter;
		public ClientHandler(Socket clientSocket,PrintWriter clientwriter) throws IOException {
			Socket sock = clientSocket;
			this.clientwriter = clientwriter;
			reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		}

		public void run() {
			String message;
			try {
				//System.out.println("Thread is running");
			//	System.out.println(reader);
				while ((message = reader.readLine()) != null) {
					//System.out.println("read " + message);
					// check the message to see if it is  a vlaid bid
					// if not, valid, then  send a message to THIS client
					// by writing using this client's writer.
				//	System.out.println("Print" + message);
					if(message.charAt(message.length()-1) == '!')
						checkUsers(message,clientwriter);
					else if(message.charAt(message.length()-1) == '@')
						addUser(message,clientwriter);
					else
						checkbid(message,clientwriter);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
