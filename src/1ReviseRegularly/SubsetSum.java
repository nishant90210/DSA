package TopInterviewQuestions;

import java.util.ArrayList;

public class SubsetSum {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        ArrayList<ArrayList<Integer>> arrayLists = printSubset(arr);
        for (ArrayList<Integer> arrayList : arrayLists) {
            System.out.println(arrayList);
        }
    }

    private static ArrayList<ArrayList<Integer>> printSubset(int[] arr) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        dfs(arr, result, new ArrayList<>(), 0);
        return result;
    }

    private static void dfs(int[] arr, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> integers, int index) {

        result.add(new ArrayList<>(integers));
        for(int i = index; i < arr.length; i++){
            integers.add(arr[i]);
            dfs(arr, result, integers, i+1);
            integers.remove(integers.size()-1);
        }
    }
}
