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

//    public static int[] partition(int[] table, int first, int last) {
//        int pivot = table[0];
//        int up = first;
//        int down = last;
//
//        do{
//            while(table[up] < pivot && up < down) {
//                up++;
//            }
//            while(table[down] > pivot) {
//                down--;
//            }
//            swap(table, up, down);
//        }
//        while(up < down);
//        swap(table, first, down);
//        return table;
//    }

    private static <E extends Comparable<E>> void qsswap(E[] a, int i, int j) {
        E temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static <E extends Comparable<E>> void qs(E[] a) {
        qs(a, 0, a.length - 1);
    }

//    private static <E extends Comparable<E>> int partition(E[] a, int first, int last) {
//        int up = first;
//        int down = last;
//        int pivot = first;
//
//        do{
//            while(a[up].compareTo(a[pivot]) <= 0 && up < down) {
//                up++;
//            }
//            while(a[down].compareTo(a[pivot]) > 0) {
//                down--;
//            }
//            if (up < down) {
//                qsswap(a, up, down);
//            }
//        }
//        while(up < down);
//
//        qsswap(a, first, down);
//        return down;
//    }

    private static <E extends Comparable<E>> int partition2(E[] a, int first, int last) {
        if (last - first > 2) {
            int left = first;
            int right = last;
            int middle = (last = first) / 2;



            qsswap(a, left, middle);
        }

        return partition(a, first, last);
    }

    private static <E extends Comparable<E>> void qs(E[] a, int first, int last) {
        if(first < last) {
            int pivIndex = partition(a, first, last);
            qs(a, first, pivIndex - 1);
            qs(a, pivIndex + 1, last);
        }
    }

//    public static <E extends Comparable<E>> int partition(E[] a, int first, int last) {
//        int up = first;
//        int down = last;
//        int pivot = first;
//        int temp = 0;
//        do{
//            while(a[pivot].compareTo(a[down]) <0){
//                down--;
//            }
//            if(a[pivot].compareTo(a[down]) > 0){
//                temp = pivot;
//                a[pivot] = a[down];
//                a[down] = a[temp];
//            }
//            while(a[pivot].compareTo(a[up]) > 0){
//                up++;
//            }
//            if(a[pivot].compareTo(a[up]) <0){
//                temp = pivot;
//                a[pivot] = a[up];
//                a[up] = a[temp];
//            }
//        }
//        while(!(up+1 == pivot && down-1 == pivot));
//        return pivot;
//    }

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


    public static void main(String[] args) {
        int[] simpleTest = {10, 7, 5, 4, 2, 30, 22, 19};
//
//         int[] sorted1 = bubbleSort(simpleTest);
//         int[] sorted2 = selectionSort(simpleTest);
//         int[] sorted3 = insertionSort(simpleTest);
//
//         System.out.println(Arrays.toString(sorted1));
//         System.out.println(Arrays.toString(sorted2));
//         System.out.println(Arrays.toString(sorted3));
        Integer[] test = {3, 0, 1, 8, 7, 2, 5, 4, 9, 6};
        System.out.println((partition(test, 3, 6)));

    }

}