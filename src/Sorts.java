/*
                    _-====-__-======-__-========-_____-============-__
                  _(                                                 _)
               OO(          @author				                     )_
              0  (_                  Kendall Niles Peretz             _)
            o0     (_                                                _)
           o         '=-___-===-_____-========-___________-===-___-='
         .o                                _________
        . ______          ______________  |         |      _____
      _()_||__|| ________ |            |  |_________|   __||___||__
     (         | |      | |            | __Y______00_| |_         _|
    /-OO----OO""="OO--OO"="OO--------OO"="OO-------OO"="OO-------OO"=P
   #####################################################################

 */

import java.util.ArrayList;

public class Sorts {

	public static void perfectSort(int[]a){
		for(int i = 0; i < a.length; i++){
			a[i] = i+1;
		}
	}

	public static void bubbleSort(int[] a){
		for(int i = 0; i < a.length - 1; i++)
			for(int j = 0; j < a.length - 1; j++)
				if(a[j] > a[j + 1]){
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
	}

	//special selection sort that keeps track of both min and max
	public static void selectionSort(int[] a){
		for(int i = 0, k = a.length-1; i <= k; i++, k--){
			int temp;
			int min = i;
			for(int j = i; j <= k; j++){
				if(a[min] > a[j])
					min = j;
			}
			temp = a[min];
			a[min] = a[i];
			a[i] = temp;

			int max = k;
			for(int j = i; j <= k; j++)
				if(a[max] < a[j])
					max = j;
			temp = a[max];
			a[max] = a[k];
			a[k] = temp;
		}
	}

	public static void insertionSort(int[] a){
		for(int i = 0;

				i < a.length-1; i++){
			int temp = a[i+1];
			int j = i + 1;
			for(;j > 0 && temp < a[j-1]; j--)
				a[j] = a[j-1];
			a[j] = temp;
		}
	}

	public static void cocktailSort(int[] a){
		cocktailSort(a, 0, a.length - 1, true);
	}
	public static void cocktailSort(int[] a, int start, int end, boolean dir){
		if(start<end){
			if(dir){
				for(int j = start; j<end; j++)
					if(a[j] > a[j + 1]){
						int temp = a[j];
						a[j] = a[j + 1];
						a[j + 1] = temp;
					}
				cocktailSort(a, start+1, end, !dir);
			} else {
				for(int j = end; j>=start; j--)
					if(a[j] < a[j -1]){
						int temp = a[j];
						a[j] = a[j-1];
						a[j-1] = temp;
					}
				cocktailSort(a, start, end-1, !dir);
			}
		}
	}

	public static void quickSort(int[] a){
		quickSort(a, 0, a.length - 1);
	}
	public static void quickSort(int[] a, int lo, int hi){
		if (lo < hi)
		{
			int pivot = quickSplit(a, lo, hi);

			quickSort(a, lo, pivot-1);
			quickSort(a, pivot+1, hi);
		}
	}
	public static int quickSplit(int[] a, int lo, int hi){
		int pivot = a[lo];
		int i= hi+1;
		for(int j = hi; j >= lo+1; j--){
			if(a[j] > pivot){
				i--;
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		int temp = a[i-1];
		a[i-1] = a[lo];
		a[lo] = temp;

		return i-1;
	}

	public static void shellSort(int[] a){
		shellSort(a, a.length/2 - 1);
	}
	public static void shellSort(int[]a, int gap){
		if(gap >= 1){
			for(int i = 0; i+gap < a.length; i+=gap){
				int temp = a[i+gap];
				int j = i + gap;
				for(;j >= gap && temp < a[j-gap]; j-=gap)
					a[j] = a[j-gap];
				a[j] = temp;
			}
			shellSort(a, gap/2);
		}
	}

	public static int[] subArray(int[] array, int start, int end){
		int[] a = new int[end - start + 1];
		for(int i = start, j = 0; i <= end; i++, j++)
			a[j] = array[i];
		return a;
	}
	public static void mergeSort(int[] a){
		mergeSort(a, 0, a.length - 1);
	}
	public static void mergeSort(int[] a, int start, int end){
		if (start<end)
		{
			int mid = (start+end)/2;

			mergeSort(a, start, mid);
			mergeSort(a , mid+1, end);

			merge(a, start, mid, end);
		}  
	}
	public static void merge(int[] array, int start, int mid, int end){
		int[] a = subArray(array, start, mid);
		int[] b = subArray(array, mid+1, end);
		int i=0, j=0, k=start;
		for(;i < a.length && j < b.length; k++)
			if(a[i] < b[j])
				array[k] = a[i++];
			else
				array[k] = b[j++];
		while (i < a.length)
			array[k++] = a[i++];
		while (j < b.length)
			array[k++] = b[j++];
	}

	public static void bubbleSort(ArrayList<String> a){
		for(int i = 0; i < a.size(); i++){
			for(int j = 0; j < a.size() - 1; j++){
				if(a.get(j).compareTo(a.get(j + 1)) > 0){
					String temp = a.get(j);
					a.set(j, a.get(j + 1));
					a.set(j+1, temp);
				}
			}
			if(i == a.size() - 1)
				break;
		}
	}

	public static void selectionSort(ArrayList<String> a){
		for(int i = 0; i < a.size(); i++){
			int min = i;
			for(int j = i; j < a.size(); j++)
				if(a.get(min).compareTo(a.get(j)) > 0)
					min = j;
			String temp = a.get(min);
			a.set(min, a.get(i));
			a.set(i, temp);
		}
	}

	public static void insertionSort(ArrayList<String> a){
		for(int i = 0; i < a.size()-1; i++){
			String temp = a.get(i + 1);
			int j = i+1;
			for(; j>0 && temp.compareTo(a.get(j-1)) < 0; j--)
				a.set(j, a.get(j-1));
			a.set(j, temp);
		}
	}

	public static void quickSort(ArrayList<String> a){
		quickSort(a, 0, a.size() - 1);
	}
	public static void quickSort(ArrayList<String> a, int lo, int hi){
		if (lo < hi)
		{
			int pivot = quickSplit(a, lo, hi);

			quickSort(a, lo, pivot-1);
			quickSort(a, pivot+1, hi);
		}
	}
	public static int quickSplit(ArrayList<String> a, int lo, int hi){
		String pivot = a.get(lo);
		int i= hi+1;
		for(int j = hi; j >= lo+1; j--){
			if(a.get(j).compareTo(pivot) > 0){
				i--;
				String temp = a.get(i);
				a.set(i, a.get(j));
				a.set(j, temp);
			}
		}
		String temp = a.get(i-1);
		a.set(i-1, a.get(lo));
		a.set(lo, temp);

		return i-1;
	}

	public static void mergeSort(ArrayList<String> a){
		mergeSort(a, 0, a.size() - 1);
	}
	public static void mergeSort(ArrayList<String> a, int start, int end){
		if (start<end)
		{
			int mid = (start+end)/2;

			mergeSort(a, start, mid);
			mergeSort(a , mid+1, end);

			merge(a, start, mid, end);
		}  
	}
	public static void merge(ArrayList<String> array, int start, int mid, int end){
		ArrayList<String> a = subArray(array, start, mid);
		ArrayList<String> b = subArray(array, mid+1, end);
		int i=0, j=0, k=start;
		for(;i < a.size() && j < b.size(); k++)
			if(a.get(i).compareTo(b.get(j)) < 0)
				array.set(k,  a.get(i++));
			else
				array.set(k,  b.get(j++));
		while (i < a.size())
			array.set(k++, a.get(i++));
		while (j < b.size())
			array.set(k++, b.get(j++));
	}
	public static ArrayList<String> subArray(ArrayList<String> array, int start, int end){
		ArrayList<String> a = new ArrayList<String>();
		for(int i = start; i <= end; i++)
			a.add(array.get(i));
		return a;
	}

	public static String toString(int[] array){
		String s = "[";
		for(int i = 0; i < array.length; i++){
			s += array[i];
			if(i != array.length - 1)
				s += ", ";
		}
		s += "]";
		return s;
	}

	public static void main(String[] args) {
		int[][] ints = {{},
				{1, 2, 4, 3, 5, 6},
				{5, 4, 3, 2, 1},
				{23, -12, 7, 3, 0, 9, -21, -4},
				{135, 2, 2, 6, 7, 2},
				{2, 2, 1, 1, 3, 3},
				{4, 5, 2, 7, 4, 2},
				{1},
				{0, 1, 2, 3, 4, -1, -2, -3, -4, 0}
		};
		for(int[] x : ints){
			perfectSort(x);
			System.out.println(toString(x));
		}

//		ArrayList<String> list = new ArrayList<String>();		
//		list.add("beadf");
//		list.add("daga");
//		list.add("ccajedb");
//		list.add("flahb");
//		list.add("eajkb");
//		list.add("asdg");
//		System.out.println(list);
//		insertionSort(list);
//		System.out.println(list);
	}

}
