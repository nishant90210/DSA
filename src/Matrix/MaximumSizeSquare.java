package Matrix;

public class MaximumSizeSquare {

    public static void main(String[] args) {

        int[][] mat = { {1, 0, 1, 0, 0},
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 1, 1},
                        {1, 0, 0, 1, 0}
        };

        int maxSquare = calculateMaxSquare(mat);
        System.out.println("Maximum Square :- " + maxSquare);
    }

    private static int calculateMaxSquare(int[][] matrix) {

        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(i == 0 || j == 0 || matrix[i][j] == 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    dp[i][j] = 1 + (Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1])));
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max*max;
    }
}
