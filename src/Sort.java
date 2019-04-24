import java.util.Arrays;

public class Sort {

	private static int[] merge(int[] a, int[] b) {
		   int[] c = new int[a.length+b.length];
		   int ia=0;
		   int ib=0;
		   int ic=0;
		   
		   while (ia<a.length && ib<b.length) {
			   if (a[ia]<b[ib]) {
				   c[ic] = a[ia];
				   ia++;
			   } else {
				   c[ic] = b[ib];
				   ib++;
			   }
			   ic++;
		   }
		   
		   while (ia<a.length) {
			   c[ic]=a[ia];
			   ia++;
			   ic++;
		   }
		   
		   while (ib<b.length) {
			   c[ic]=b[ib];
			   ib++;
			   ic++;
		   }
		   
		   
		   
		   return c;
	}
	
	private static <E extends Comparable<E>> void qs(E[] a) {
		qs(a, 0, a.length - 1);
	}

	private static <E extends Comparable<E>> int partition(E[] a, int first, int last) {
		int up = first;
		int down = last;
		int pivot = first;
		E  temp;
		while (a[pivot].compareTo(a[down]) < 0) {
			down--;
		}
		if (a[pivot].compareTo(a[down]) > 0) {
			temp = a[pivot];
			a[pivot] = a[down];
			a[down] = temp;
			pivot = down;
		}
		while (a[pivot].compareTo(a[up]) > 0) {
			up++;
		}
		if (a[pivot].compareTo(a[up]) < 0) {
			temp = a[pivot];
			a[pivot] = a[up];
			a[up] = temp;
			pivot = up;
		}
		return pivot;
	}


	private static <E extends Comparable<E>> void qs(E[] a, int first, int last) {
		if (first < last) { // There is data to be sorted. 
			int pivIndex = partition(a, first, last); 
			qs(a, first, pivIndex - 1); 
			qs(a, pivIndex + 1, last);
		}
		}
	
	public static void main(String[] args) {
		Integer[] a = {10, 7, 6 , 5};
		qs(a);
		System.out.println(Arrays.toString((a)));

	}
}
