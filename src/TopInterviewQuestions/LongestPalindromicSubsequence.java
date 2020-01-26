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
    private static int longestPalindromeDP(String s1) {

        int s1length = s1.length();
        int matrix[][] = new int[s1length][s1length];
        for (int i = 0; i <= s1length; i++) {
            for (int j = 0, x = i; x <= s1length-1; j++, x++) {
                if (x == j){
                    matrix[j][x] = 1;
                } else if (s1.charAt(j) == s1.charAt(x)){
                    matrix[j][x] = 2 + matrix[j+1][x-1];
                } else if (s1.charAt(j) != s1.charAt(x)){
                    matrix[j][x] = Math.max(matrix[j][x-1], matrix[j+1][x]);
                }
            }
        }
        return matrix[0][s1length-1];
    }
}
