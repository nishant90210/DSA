package ALGO;

/**
 * Created by NISHANT on 11/13/17.
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {

        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String s1 = "AGTABA";
        String s2 = "GTABGTAB";
        int s1Length = s1.length();
        int s2Length = s2.length();
        System.out.println("LCS is " + lcs.calculateLCS(s1, s2, s1Length, s2Length));
    }

    private int calculateLCS(String s1, String s2, int s1Length, int s2Length) {

        int i, j = 0;
        int matrix[][] = new int[s1Length+1][s2Length+1];
        for (i = 0; i <= s1Length; i++) {
            for (j = 0; j <= s2Length; j++) {
                if (i == 0 || j == 0){
                    matrix[i][j] = 0;
                }
                else if (s1.charAt(i-1) == s2.charAt(j-1)){
                    matrix[i][j] = 1 + matrix[i-1][j-1];
                }
                else {
                    matrix[i][j] = maximum(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }
        return matrix[s1Length][s2Length];
    }

    private int maximum(int i, int j) {

        return (i > j) ? i : j;
    }

}
