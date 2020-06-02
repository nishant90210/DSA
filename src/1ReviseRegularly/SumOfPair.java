package Arrays;

import java.util.HashSet;

/**
 * Created by NISHANT on 2/26/18.
 */
// https://www.geeksforgeeks.org/count-pairs-with-given-sum/
public class SumOfPair {

    public static void main(String args[])
    {
        int[] arr = { 1, 5, 7, -1, 5 }; //first method
//        int[] arr = { 1, 3, 8, 7 }; //second method
        int sum = 6;
        getPairsCount(arr, sum);
    }

    private static void getPairsCount(int[] arr, int sum) {

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(sum - arr[i])) {
                System.out.println("Pair found = " + arr[i] + " and " + (sum - arr[i]));
            } else {
                set.add(arr[i]);
            }
        }
    }
}
