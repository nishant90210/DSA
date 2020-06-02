package TopInterviewQuestions;

public class LongestPalindromicSubsequence {

    //    Recursion
    public static void main(String[] args)
    {
        String X = "ABBDCACB";
        int n = X.length();

//        System.out.print("The length of Longest Palindromic Subsequence is " + longestPalindrome(X, 0, n - 1));
        System.out.print("The length of Longest Palindromic Subsequence Using DP is " + longestPalindromeDP(X));
    }

    private static int longestPalindrome(String str, int i, int j) {

        if (i > j){
            return 0;
        }
        if (i == j){
            return 1;
        }
        if (str.charAt(i) == str.charAt(j)){
            return longestPalindrome(str, i+1, j-1) + 2;
        }
        return Math.max(longestPalindrome(str, i, j-1),longestPalindrome(str, i+1, j));
    }

    //Dynamic Programming

    // Every single character is a palindrome of length 1
    //  L(i, i) = 1 for all indexes i in given sequence

    // IF first and last characters are not same
    //  If (X[i] != X[j])  L(i, j) =  max{L(i + 1, j),L(i, j - 1)}

    // If there are only 2 characters and both are same
    //  Else if (j == i + 1) L(i, j) = 2

    // If there are more than two characters, and first and last characters are same
    //  Else L(i, j) =  L(i + 1, j - 1) + 2
    private static int longestPalindromeDP(String s) {

        int[][] dp = new int[s.length()][s.length()];
        for(int i = s.length()-1; i >= 0; i--){
            dp[i][i] = 1;
            for(int j= i+1; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
