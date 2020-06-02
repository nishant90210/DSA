package Programs;

public class UncrossedLines {

    public static void main(String[] args) {

        int[] A = {1, 3, 7, 1, 7, 5};
        int[] B = {1, 9, 2, 5, 1};
        int i = maxUncrossedLines(A, B);
        System.out.println(i);
    }

    public static int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[A.length+1][B.length+1];
        for(int i = 1; i <= A.length; i++){
            for(int j = 1; j <= B.length; j++){
                if (A[i-1] == B[j-1]){
                    dp[i][j] = 1 + Math.max(dp[i][j-1], dp[i-1][j]);
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[A.length][B.length];
    }
}
