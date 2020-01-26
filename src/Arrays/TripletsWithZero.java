package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NISHANT on 3/19/18.
 */
public class TripletsWithZero {

    public static void main(String[] args)
    {
        int arr[] = {1, 0, -1, 0, -2, 2};
        int n =arr.length;
        findTriplets(arr, n);
        List<List<Integer>> list = tripLetsSum(arr);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }

    private static List<List<Integer>> tripLetsSum(int[] arr) {

        int total;
        List<List<Integer>> result = new ArrayList();
        List<Integer> sum = new ArrayList();
        for(int i = 0 ; i <= arr.length-1 ; i++){
            for(int j = i+1; j< arr.length-1 ; j++){
                total = arr[i] + arr[j] + arr[j+1];
                if(total == 0){
                    sum.add(arr[i]);
                    sum.add(arr[j]);
                    sum.add(arr[j+1]);
                }
            }
        }
        result.add(sum);
        return result;
    }

    private static void findTriplets(int[] arr, int n) {

        boolean tripletsFound = false;
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < arr.length; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0){
                        System.out.println(arr[i] + " " + arr[j] + " " + arr[k] );
                        tripletsFound = true;
                    }
                }
            }
        }
        if (!tripletsFound){
            System.out.println("Not found");
        }
    }
}
