package TopInterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class FactorsCombination {

    public static void main(String[] args) {

        int n = 16;
        int product = 1;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> items = new ArrayList<>();
        dfs(result, items, product, n, 2);
        for (List<Integer> integers : result) {
            System.out.println(integers);
        }
    }

    private static void dfs(List<List<Integer>> result, List<Integer> items, int product, int n, int start) {

        if (start > n || n == 0) {
            return;
        }
        if (product == n){
            result.add(new ArrayList<>(items));
            return;
        }

        for(int i = start; i <= n/2; i++){
            if (product > n){
                break;
            }
            if (i % 2 == 0){
                items.add(i);
                dfs(result, items, i*product, n, i);
                items.remove(items.size() - 1);
            }
        }
    }
}
