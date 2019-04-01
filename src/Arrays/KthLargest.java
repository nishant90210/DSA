package Arrays;

import java.util.PriorityQueue;

/**
 * Created by NISHANT on 10/26/17.
 */
public class KthLargest {

    public static void main(String[] args) {

        KthLargest kth = new KthLargest();
        int[] array = {24,2,45,20,56,81,75};
        //             2 20 24 45 56 75 81
        int length = array.length;
        System.out.println(length);
        int k = 3;
        int quicksort = kth.quicksort(array, 0, length - 1, length-k+1);
        System.out.println(quicksort);

        //Using Priority Queue
//        int kthLargest = kthLargestPQueue(array, k);
//        System.out.println(kthLargest);
    }

    private static int kthLargestPQueue(int[] array, int k) {

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for (Integer i : array) {
            pQueue.offer(i);
            if (pQueue.size() > k){
                pQueue.poll();
            }
        }
        return pQueue.peek();
    }

    private int quicksort(int[] array, int left, int right, int k) {

        if (left > right) {
            return 0;
        }

        int pivot = partition(array, left, right);
        if (pivot == k - 1) {
            return array[pivot];
        }
        if (pivot > k-1){
            return quicksort(array, left, pivot, k);
        }else {
            return quicksort(array, pivot+1, right, k);
        }
    }

    private int partition(int[] array, int left, int right) {

        int pivot = left;
        int i = left+1;
        int j = right;
        while (i <= j){
            while (array[i] < array[pivot]){
                i++;
            }
            while (array[j] > array[pivot]){
                j--;
            }
            if (i <= j){
                swap(array, i , j);
            }
        }
        swap(array, j, pivot);
        return j;
    }


    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
