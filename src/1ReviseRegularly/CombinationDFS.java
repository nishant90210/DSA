package Programs;

import java.util.ArrayList;
import java.util.List;

public class CombinationDFS {

    public static void main(String[] args) {

        int n = 4;
        int k = 2;
        List<List<Integer>> combine = combine(4, 2);
        for (int i = 0; i < combine.size(); i++) {
            System.out.println(combine.get(i));
        }
    }

    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList();
        List<Integer> items = new ArrayList();
        if(n < k || n <= 0){
            return new ArrayList();
        }
        int start = 1;
        dfs(result, items, start, n, k);
        return result;
    }

    private static void dfs(List<List<Integer>> result, List<Integer> items, int start, int n, int k) {

        if (items.size() == k){
            result.add(new ArrayList(items));
            return;
        }
        for (int i = start; i <= n; i++) {
            items.add(i);
            dfs(result, items, i+1, n, k);
            items.remove(items.size()-1);
        }
    }
}
