// SortTools.java
/*
 * EE422C Project 1 submission by
 * Replace <...> with your actual data.
 * Saptarshi Mondal
 * sm72999
 * <5-digit Unique No.>
 * Fall 2021
 * Slip days used:
 */

package assignment1;

public class SortTools {
    /**
      * Return whether the first n elements of x are sorted in non-decreasing
      * order.
      * @param x is the array
      * @param n is the size of the input to be checked
      * @return true if array is sorted
      */
    public static boolean isSorted(int[] x, int n) {
        // stub only, you write this!
        // TODO: complete it
    	if(n == 1)
    		return true;
    	if((x.length == 0)||(n == 0) )
        return false;
    	for(int i = 0;i<n-1;i++)
    		{
    		if((x[i]>x[i+1]))
    			return false;
    		}
    	return true;
    }

    /**
     * Return an index of value v within the first n elements of x.
     * @param x is the array
     * @param n is the size of the input to be checked
     * @param v is the value to be searched for
     * @return any index k such that k < n and x[k] == v, or -1 if no such k exists
     */
    public static int find(int[] x, int n, int v) {
        // stub only, you write this!
        // TODO: complete it
       int l = 0;
       int r = n-1;
      int m = 0;
       while(l<=r)
       {
    	    m = (l+r)/2;
    	   if(x[m]==v)
    		   return m;
    	   else if(x[m] > v)
    		   r = m -1;
    	   else if(x[m]<v)
    		   l = m+1;   
       }
       return -1;
    }

    /**
     * Return a sorted, newly created array containing the first n elements of x
     * and ensuring that v is in the new array.
     * @param x is the array
     * @param n is the number of elements to be copied from x
     * @param v is the value to be added to the new array if necessary
     * @return a new array containing the first n elements of x as well as v
     */
    public static int[] copyAndInsert(int[] x, int n, int v) {
        // stub only, you write this!
        // TODO: complete it
    	int j = 0;
    	if(n==0)
    	{
    		int[] a = new int[]{v};
    		return a;
    	}
    	j = find(x,n,v);
    	if(j != -1)
    	{
    		int[] a = new int[n];
    		for(int i = 0; i<n;i++)
    			a[i]=x[i];
    		return a;
    	}
    	else
    	{
    		int[] a = new int[n+1];
    		if(x[n-1]<v)
    		{
    			for(int i = 0; i<n;i++)
    				a[i]=x[i];
    			a[n]= v;
    			return a;
    		}
    		else
    		{
    			int r=0,k=0,flag = 0;
    			while (k<(n+1))
    			{
    				if(x[r]<=v)
    				{
    					a[k] = x[r];
    					k++;r++;
    				}
    				else if((x[r]>v)&&(flag == 0))
    				{
    					a[k]= v;
    					k++;
    					flag = 1;
    				}
    				else if((x[r]>v)&&(flag == 1))
    				{
    					a[k] = x[r];
    					k++;r++;
    				}
    			}
    			return a;
    		}
    	}
    }

    /**
     * Insert the value v in the first n elements of x if it is not already
     * there, ensuring those elements are still sorted.
     * @param x is the array
     * @param n is the number of elements in the array
     * @param v is the value to be added
     * @return n if v is already in x, otherwise returns n+1
     */
    public static int insertInPlace(int[] x, int n, int v) {
        // stub only, you write this!
        // TODO: complete it
        for(int i = 0; i<n; i++)
        	if(x[i]==v)
        		return n;
       if(x[n-1] < v)
    	   {
    	   x[n] = v;
    	   return n+1;
    	   }
       else
       {
    	   int j=0,k=0,flag = 0;
    	   int[] a = new int[n+1];
    	   while (k<(n+1))
			{
				if(x[j]<=v)
				{
					a[k] = x[j];
					k++;j++;
				}
				else if((x[j]>v)&&(flag == 0))
				{
					a[k]= v;
					k++;
					flag = 1;
				}
				else if((x[j]>v)&&(flag == 1))
				{
					a[k] = x[j];
					k++;j++;
				}
			}
    	   for(int i = 0; i<n+1;i++)
    	   {
    		   x[i]= a[i];
    	   }
    	   return n+1;
       }
      }

    /**
     * Sort the first n elements of x in-place in non-decreasing order using
     * insertion sort.
     * @param x is the array to be sorted
     * @param n is the number of elements of the array to be sorted
     */
    public static void insertSort(int[] x, int n) {
        // stub only, you write this!
        // TODO: complete it
    	for(int i = 0; i<n; i++)
    	{
    		int a = x[i];
    		int b = i -1;
    		while(b>=0 && x[b]>a)
    		{
    			x[b+1]= x[b];
    			b = b-1;
    		}
    		x[b+1] = a;
    	}
    }
}
