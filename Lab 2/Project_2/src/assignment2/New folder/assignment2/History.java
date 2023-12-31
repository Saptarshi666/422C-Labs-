package assignment2;

public class History {
	int a = 0;
	String[] arr;
	int[] black;
	int[] white;
public History(int x){
	arr = new String[x];
	black = new int[x];
	white = new int[x];
}
public void addinfor(String d,int b,int w)
{
     arr[a] = d;
     black[a] = b;
     white[a] = w;
     a++;
}
public void recall()
{
	System.out.println();
	for(int i = 0; i<a;i++)
	{
		System.out.println(arr[i]+ " -> "+black[i]+"b_"+white[i]+"w");
	}
}
}
