import java.lang.reflect.Array;
import java.util.Arrays;

public class Sorting {

    /**
     * Helper - swaps two elements of an array and returns the array
     */
    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = b;
        array[b] = temp;
    }

    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length+b.length];
        int ia = 0;
        int ib = 0;
        int ic = 0;

        for(int i = 0; i < result.length; i++) {
            if(a[ia] < b[ib]) {
                result[ic] = a[ia];
                ia++;
                ic++;
            }
            else{
                result[ic] = b[ib];
                ib++;
                ic++;
            }
        }

        return result;
    }

    public static int[] bubbleSort(int[] array) {
        int length = array.length;
        while(length > 0) {
            int n = 0;
            for(int i = 1; i < length; i++) {
                if(array[i - 1] > array[i]) {
                    swap(array, i-1, i);
                    n = i;
                }
            }
            length = n;
        }
        return array;
    }

    public static int[] selectionSort(int[] array) {
        int length = array.length;
        for(int i = 0; i < length - 1; i++) {
            int minIndex = i, min = array[i];
            for(int j = i + 1; j < length; j++) {
                if(array[j] < min) {
                    minIndex = j;
                    min = array[j];
                }
            }
            if(minIndex != i) {
                swap(array, i, minIndex);
            }
        }
        return array;
    }

    public static int[] insertionSort(int[] array) {
        int length = array.length;
        for(int i = 0; i < length; i ++) {
            int temp = array[i];
            int j = i - 1;
            while(j >= 0 && array[i] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        return array;
    }



    public static void main(String[] args) {
//        int[] simpleTest = {6, 9, 5, 4, 3};
//
//         int[] sorted1 = bubbleSort(simpleTest);
//         int[] sorted2 = selectionSort(simpleTest);
//         int[] sorted3 = insertionSort(simpleTest);
//
//         System.out.println(Arrays.toString(sorted1));
//         System.out.println(Arrays.toString(sorted2));
//         System.out.println(Arrays.toString(sorted3));
        
        System.out.println();

    }

}