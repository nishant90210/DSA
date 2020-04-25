package TopInterviewQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by NISHANT on 9/18/17.
 */
public class SlidingWindow {

    public static void main(String[] args)
    {
        int arr[]={1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k=4;
        printMax(arr, arr.length,k);
        printMaxSumInOn(arr, arr.length,k);
    }

    private static void printMax(int[] arr, int length, int k) {

        for (int i = 0; i <= length-k ; i++) {
            int max = arr[i];
            for (int j = 1; j < k; j++) {
                if (max < arr[i+j]){
                    max = arr[i+j];
                }
            }
            System.out.println("Print max in Quadratic time " + max);
        }
    }

    private static void printMaxSumInOn(int[] arr, int length, int k) {

        if(length < k){
            System.out.println("Invalid");
            return;
        }
        // Compute sum of first window of size k
        int max_sum = 0;
        for (int i = 0; i < k; i++) {
            max_sum += arr[i];
        }
        // Compute sums of remaining windows by removing first element of previous
        // window and adding last element of current window.
        int window_sum = max_sum;
        for (int i = k; i < length; i++) {
//            window_sum += arr[i] - arr[i - k];    // this is also working
            window_sum = (window_sum + arr[i]) - arr[i - k] ;
            max_sum = Math.max(max_sum, window_sum);
        }
        System.out.println("Print max SUM in Linear time " + max_sum);
    }
}
