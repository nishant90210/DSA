package TopInterviewQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NISHANT on 3/28/18.
 */

public class CreatePermuation {
    static void permuteBySwapping(int[] a, int k) {
        if (k == a.length) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(" [" + a[i] + "] ");
            }
            System.out.println();
        } else {
            for (int i = k; i < a.length; i++) {
                int temp = a[k];
                a[k] = a[i];
                a[i] = temp;

                permuteBySwapping(a, k + 1);

                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
    }

    public static void main(String args[]) {

        //permuteBySwapping(new int[]{1,2,3} , 0);

        int[] input = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> items = new ArrayList<>();
        createPermutation(input, result, items);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    private static void createPermutation(int[] input, List<List<Integer>>result, List<Integer> items) {

        if (items.size() == input.length){
            result.add(new ArrayList<>(items));
            return;
        }
        for(int i = 0; i < input.length; i++){
            if(items.contains(input[i])) {
                continue;
            }
            items.add(input[i]);
            createPermutation(input, result, items);
            items.remove(items.size()-1);
        }
    }
}