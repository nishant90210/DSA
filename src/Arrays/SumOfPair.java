package Arrays;

import java.util.HashSet;

/**
 * Created by NISHANT on 2/26/18.
 */
// https://www.geeksforgeeks.org/count-pairs-with-given-sum/
public class SumOfPair {

    public static void main(String args[])
    {
//        int[] arr = { 1, 5, 7, -1, 5 }; //first method
        int[] arr = { 1, 3, 8, 7 }; //second method
        int sum = 6;
        getPairsCount(arr, sum);
    }

    // First Method
    // Complexity O(n^2)
//    private static void getPairsCount(int[] arr, int sum) {
//        int count = 0;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i+1; j < arr.length; j++) {
//                if (arr[i] + arr[j] == sum){
//                    count++;
//                    System.out.print("Found " + count + " pair");
//                    System.out.println(" At index " + i + " with value " + arr[i] + " and index " + j + " with value " + arr[j]);
//                    System.out.println();
//                }
//            }
//        }
//    }

    // Second Method
//    private static void getPairsCount(int[] arr, int sum) {
//
//        int low = 0;
//        int hi = arr.length-1;
//        while (low < hi){
//            if (arr[low] + arr[hi] > sum){
//                hi--;
//            }else if (arr[low] + arr[hi] < sum){
//                low++;
//            }else {
//                System.out.println("Found at index " + low + " with value " + arr[low] + " and index " + hi + " with value " + arr[hi]);
//                return;
//            }
//        }
//    }

    private static void getPairsCount(int[] arr, int sum) {

        HashSet<Integer> compliment = new HashSet<>();
        for (int i : arr) {
            if (compliment.contains(i)){
                System.out.println("Found ");
            }else {
                compliment.add(sum-i);
                System.out.println("Not found");
            }
        }
    }

}
