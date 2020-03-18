package TopInterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class Combination_DFS {

    public static void main(String[] args) {

        List<List<Integer>> list = combinationDFS(4, 3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static List<List<Integer>> combinationDFS(int n, int k) {

        List<Integer> items = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (n < k || n <= 0){
            return new ArrayList<>();
        }
        int start = 1;
        dfs(result, items, start, n, k);
        return result;
    }

    private static void dfs(List<List<Integer>> result, List<Integer> items, int start, int n, int k) {

        if (items.size() == k){
            result.add(new ArrayList<>(items));
            return;
        }else {
            for(int i = start; i <= n ;i++){
                items.add(i);
                dfs(result, items, i+1, n, k);
                items.remove(items.size()-1);
            }
        }
    }
}
