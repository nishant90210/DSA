package ALGO;

/**
 * Created by NISHANT on 11/14/17.
 */
public class LongestPalindromicSubsequence {

    public static void main(String[] args) {

        String s1 = "ADBBCA";
        int s1length = s1.length();
        int lps = LPS(s1, s1length);
        System.out.println("Longest Palindromic Subsequence is " + lps);
    }

    private static int LPS(String s1, int s1length) {

        int matrix[][] = new int[s1length][s1length];
        for (int i = 0; i <= s1length; i++) {
            for (int j = 0, x = i; x <= s1length-1; j++, x++) {
                if (x == j){
                    matrix[j][x] = 1;
                } else if (s1.charAt(j) == s1.charAt(x)){
                    matrix[j][x] = 2 + matrix[j+1][x-1];
                } else if (s1.charAt(j) != s1.charAt(x)){
                    matrix[j][x] = maximum(matrix[j][x-1], matrix[j+1][x]);
                }
            }
        }
        return matrix[0][s1length-1];
    }

    private static int maximum(int i1, int i2) {

        return (i1 > i2) ? i1 : i2;
    }
}
