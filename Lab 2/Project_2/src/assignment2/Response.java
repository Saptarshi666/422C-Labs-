/* If you submit this file, it will be ignored. Do not modify. */
package assignment2;
// DO NOT SUBMIT THIS FILE

public class Response {
	int b; int w;

	public Response(int b, int w) {
		this.b = b; this.w = w;
	}
	
	@Override 
	public boolean equals(Object o) {
		if (!(o instanceof Response))
			return false;
		Response r = (Response)o;
		return r.b == b && r.w == w;
	}
	
	public boolean won () {
		return (b == GameConfiguration.pegNumber && w == 0);
	}
}