package TopInterviewQuestions;

public class MinimumPathSum {

    public static void main(String args[])
    {

        int cost[][] = { {1, 2, 3},
                         {4, 8, 2},
                         {1, 5, 3}
        };

        System.out.print(minCost(cost));
    }

    private static int minCost(int[][] cost) {

        int dp[][] = new int[cost.length][cost[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] += cost[i][j];
                if (i > 0 && j > 0){
                    dp[i][j] += Math.min(dp[i-1][j], dp[i][j-1]);
                } else if (i > 0){
                    dp[i][j] += dp[i-1][j];
                } else if (j > 0){
                    dp[i][j] += dp[i][j-1];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
