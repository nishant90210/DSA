package ALGO;

/**
 * Created by NISHANT on 10/25/17.
 */
public class QuickSortDifferent {

    public static void main(String args[]){

        QuickSortDifferent sorter = new QuickSortDifferent();
        int[] array = {1, 12, 5, 26, 7, 14, 3, 9, 2};
        int length = array.length;
        sorter.quicksort(array, 0, length-1);
        printArray(array);
    }

    private void quicksort(int[] array, int left, int right) {

        if (left >= right){
            return;
        }
        int pivot = array[(left+right)/2];
        int index = partition(array, pivot, left, right);
        quicksort(array, left, index - 1);
        quicksort(array, index, right);
    }

    private int partition(int[] array, int pivot, int left, int right) {

        while (left <= right) {
            while (array[left] < pivot)
                left++;
            while (array[right] > pivot)
                right--;
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void printArray(int[] input) {
        for(int i:input){
            System.out.print(i);
            System.out.print(" ");
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
