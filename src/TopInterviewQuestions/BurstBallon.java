package TopInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BurstBallon {

    public static void main(String[] args) {

//        DP
        int[] ballons = {3, 1, 5, 8};
        int i = maxCoins(ballons);
        System.out.println(i);
    }

    private static int maxCoins(int[] ballons) {

        List<Integer> list = new ArrayList<>();
        if (ballons == null || ballons.length == 0){
            return 0;
        }
        for (int ballon : ballons) {
            list.add(ballon);
        }
        return maxCoins(list);
    }

    private static int maxCoins(List<Integer> list) {

        int max = 0;
        if (list.size() == 1){
            return list.get(0);
        }
        for (int i = 0; i < list.size(); i++) {
            int left = i == 0 ? 1 : list.get(i-1);
            int right = i == list.size()-1 ? 1 : list.get(i+1);
            int product = left * list.get(i) * right;
            List<Integer> tmp = new ArrayList<>(list);
            tmp.remove(i);
            max = Math.max(max, product + maxCoins(tmp));
        }
        return max;
    }
}
