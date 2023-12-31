package assignment1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.Timeout;

public class SampleTest {
    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);

    @Test
    public void sampleTest() {
        int[] x = new int[]{-5, -4, -3, -2, -1, 0};
        int[] original = x.clone();
        int n = x.length;

        assertEquals(2, SortTools.find(x, 3, -3));
        assertArrayEquals(original, x);
    }

    @Test
    public void sampleTest1() {
        int[] x = new int[]{-5, -4, -3, -2, -1, 0};
        int[] original = x.clone();
        int n = 1;

        assertEquals(-1, SortTools.find(x, n, -3));
        assertArrayEquals(original, x);
    }
    
  /*  @Test
   public void sampleTest2() {
	   int[] x = new int[] {};
	   boolean a = SortTools.isSorted(x, 0); 
	   assert(a);
   }*/
    @Test
    public void sampleTest3() {
    	int[] x = new int[] {1,2,3,7};
    	boolean a = SortTools.isSorted(x, 3);
    	assert (a);
    }
  /*@Test
   public void sampleTest4() {
	   int[] x = new int[] {2,1};
	   boolean a = SortTools.isSorted(x, 2);
   	assert (a);
   }
  @Test
  public void sampleTest5() {
	  int[] a = new int[] {1,3,3,7,8};
	  int b = SortTools.find(a, 5, 8);
	  assertEquals(4,b);
	  
  }*/
   @Test
   public void sampleTest5() {
	   int[] x = new int[] {0,1,2,3,4,50,89};
	   int[] z = SortTools.copyAndInsert(x, 7, 6);
	  int[] y = new int[] {0,1,2,3,4,6,50,89};
	  assertArrayEquals(y,z);
	   //fail();
	}
}
