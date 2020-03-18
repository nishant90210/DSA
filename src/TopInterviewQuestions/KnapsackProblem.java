package TopInterviewQuestions;

/**
 * Created by NISHANT on 7/5/18.
 * https://www.youtube.com/watch?v=xCbYmUPvc2Q
 */
public class KnapsackProblem {

    public static void main(String args[]) {

        int maxWeight = 5;
        int[] value = {60, 50, 70, 30};
        int[] weight = {5, 3, 4, 2};
        System.out.println("The maximum value that can be put in a " +
                "knapsack of capacity W is: " + knapSack(maxWeight, weight, value));

    }

    private static int knapSack(int maxWeight, int[] weight, int[] value) {

        int dp[][] = new int[weight.length+1][maxWeight+1];

        for(int i = 0; i <= weight.length; i++){
            for(int j = 0; j <= maxWeight; j++){
                if (i == 0 || j == 0){
                    dp[i][j] = 0;
                } else if (weight[i-1] <= j){
                    dp[i][j] = Math.max(dp[i-1][j], (dp[i-1][j-weight[i-1]] + value[i-1]));
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[weight.length][maxWeight];
    }
}
