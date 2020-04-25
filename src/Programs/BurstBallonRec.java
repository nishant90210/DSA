package Programs;

import java.util.ArrayList;

public class BurstBallonRec {

    public static void main(String[] args) {

        int[] ballons = {3, 1, 5, 8};
        int i = maxCoins(ballons);
        System.out.println(i);
    }

    private static int maxCoins(int[] ballons) {

        ArrayList<Integer> list = new ArrayList<>();
        for(int i : ballons){
            list.add(i);
        }
        return maxCoinUtil(list);
    }

    private static int maxCoinUtil(ArrayList<Integer> list) {

        int maxSum = 0;
        for (int i = 0; i < list.size(); i++){
            int left = i == 0 ? 1 : list.get(i-1);
            int right = i == list.size()-1 ? 1 : list.get(i+1);
            int product = left * list.get(i) * right;
            ArrayList<Integer> tmp = new ArrayList<>(list);
            tmp.remove(tmp.get(i));
            maxSum = Math.max(maxSum, product+maxCoinUtil(tmp));
        }
        return maxSum;
    }
}
