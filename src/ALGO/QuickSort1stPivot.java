package ALGO;

/**
 * Created by NISHANT on 4/25/18.
 */
public class QuickSort1stPivot {

    public static void main(String a[]){

        QuickSort1stPivot sorter = new QuickSort1stPivot();
        int[] input = {24,2,45,20,56,81,75};
        sorter.sort(input);
        printArray(input);
    }

    private void sort(int[] input) {

        int left = 0;
        int right = input.length-1;

        // If both cursor scanned the complete array quicksort exits
        if (left >= right){
            return;
        }

        // For the simplicity, we took the right most item of the array as a pivot
        int pivot = input[right];
        int partition = partition(input, left, right, pivot);



    }

    private static int partition(int[] input, int left, int right, int pivot) {

        int leftCursor = left-1;
        int rightCursor = right;
        while (leftCursor < rightCursor){
            while (input[leftCursor] < pivot){
                leftCursor++;
            }
            while (input[leftCursor] < pivot){
                leftCursor++;
            }
        }
        return 0;
    }

    private static void printArray(int[] input) {
        for(int i:input){
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
