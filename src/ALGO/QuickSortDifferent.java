package ALGO;

/**
 * Created by NISHANT on 10/25/17.
 */
public class QuickSortDifferent {

    public static void main(String args[]){

        QuickSortDifferent sorter = new QuickSortDifferent();
        int[] array = {1, 12, 5, 26, 7, 14, 3, 9, 2};
        int length = array.length;
        System.out.println(length);
        sorter.quickSort(array, 0, length-1);
        printArray(array);
    }


    public void quickSort(int[] nums, int start, int end) {
        if(start >= end){
            return;
        }
        int pivot = nums[(start + end) / 2];
        int partition = sortPartition(nums, pivot, start, end);
        quickSort(nums, start, partition-1);
        quickSort(nums, partition, end);
    }

    public int sortPartition(int[] nums, int pivot, int start, int end) {

        while(start <= end) {
            while(nums[start] < pivot) {
                start++;
            }
            while(nums[end] > pivot) {
                end--;
            }
            if (start <= end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    public void swap(int[] nums, int start, int end) {

        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    private static void printArray(int[] input) {
        for(int i:input){
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
