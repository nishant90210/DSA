package ALGO;

/**
 * Created by NISHANT on 5/11/17.
 */

/**
 * The array is searched sequentially and unsorted items are moved and inserted into the sorted sub-list (in the same array).
 * This algorithm is not suitable for large data sets as its average and
 * worst case complexity are of Ο(n2), where n is the number of items.
 */
public class InsertionSort {

    public static void main(String[] args) {

        int[] a = {7, 4, 5, 2, 9, 1};
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i-1;
            while (j >= 0 && a[j] > temp){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = temp;
        }
        for (int x = 0; x < a.length; x++) {
            System.out.print(a[x] + " ");
        }
    }
}
