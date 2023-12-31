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

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Observable;
import java.util.Observer;

public class Client_Observer extends PrintWriter implements Observer {
	public Client_Observer(OutputStream out) {
		super(out);
		}
		@Override
		public void update(Observable o, Object arg) {
		this.println(arg); //writer.println(arg);
		this.flush(); //writer.flush();
		}
}
