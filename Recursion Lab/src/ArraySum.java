
public class ArraySum {

	private int result;

		public int sumOfArray (Integer[] a,int index) {
	     if (index == 0) {  
	         result = 0;
	     }
	     else {
	    	 result = a[index-1] + sumOfArray(a,(index-1));
	     }
	     return result;
	}//end of sumOfArray
}
