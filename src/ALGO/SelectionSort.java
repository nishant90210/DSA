package ALGO;

/**
 * Created by NISHANT on 6/12/17.
 */

//The selection sort is a combination of searching and sorting. During each pass,
//the unsorted element with the smallest (or largest) value is moved to its proper position in the array.
//The number of times the sort passes through the array is one less than the number of items in the array. In the selection sort,
//the inner loop finds the next smallest (or largest) value and the outer loop places that value into its proper location.

public class SelectionSort {

    public static void main(String[] args) {

        int min;
        int[] a = {23, 42, 4, 16, 8, 15};
        for (int i = 0; i < a.length; i++) {
            min = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j] < a[min]){
                    min = j;
                }
            }
            swap(min, a, i);
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }
    }

    private static void swap(int min, int[] a, int i) {
        int temp;
        temp = a[min];
        a[min] = a[i];
        a[i] = temp;
    }
}
