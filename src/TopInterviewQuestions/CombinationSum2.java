package TopInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/
public class CombinationSum2 {

    public static void main(String[] args) {

        int[] arr = {10,1,6,7,2,1,5};
//        int[] arr = {1,2,3,2,1};
        Arrays.sort(arr);
        int target = 8;
        int sum = 0;
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> items = new ArrayList<>();
        dfs(answer, items, arr, target, 0);
        for (List<Integer> integers : answer) {
            System.out.println(integers);
        }
    }

    private static void dfs(List<List<Integer>> result, List<Integer> items, int[] arr, int target, int start) {

        if (target < 0) {
            return;
        }
        if (target == 0){
            result.add(new ArrayList<>(items));
            return;
        }

        for(int i = start; i < arr.length; i++){
            //arr[i] != arr[i-1] , this is done coz we dont want duplicates figure it how
            if (i == start || arr[i] != arr[i-1]) {
                items.add(arr[i]);
                dfs(result, items, arr,target-arr[i], i+1);
                items.remove(items.size()-1);
            }
        }
    }
}
