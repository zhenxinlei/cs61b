package Algorithm;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RadixSortTest {
	
	 @Parameter //(value =  {234,435,565,23,803,7,00,23,579,2})
	    public  Integer[] a;
	/*private int []a= {234,435,565,23,803,7,00,23,579,2};
	
	public  RadixSortTest(int[] p) {
		// TODO Auto-generated constructor stub
		this.a=a;
	}
	*/
	 
	 @Parameters
     public static Collection<Integer[][]> data() {
    	 return Arrays.asList(
            	 new  Integer[][][]  {           		 
            			{ {234,234,234,234,234}},
            			{{0,0,0,0,0}},{{}},{{1,4}},{{2}},{{234,435,565,23,803,7,00,23,579,2}}
            			 
     		});
               
     }

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		//int []a= {234,435,565,23,803,7,00,23,579,2};
		int []b= {};
		int []c ={1};
		int []d={0,0};
		
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("teardown");
	}

	@Test
	public void testSortLSD() {
		RadixSort radix=new RadixSort();
	//	int []a= {234,435,565,23,803,7,00,23,579,2};
		int []b= {};
		int []c ={1};
		int []d={0,0};
		
		
		int[] pra = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			pra[i] = a[i].intValue();
		}
		
		//radix.sortLSD(pra);
		
		int copy[]=Arrays.copyOf(pra, pra.length);
		System.err.println("c"+copy);
		System.err.println(radix.sortLSD(pra));
		Arrays.sort(copy);
		assertArrayEquals(copy, radix.sortLSD(pra));
		
		
		//fail("Not yet implemented");
	}

}
