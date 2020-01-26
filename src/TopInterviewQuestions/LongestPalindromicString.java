package TopInterviewQuestions;

import Recursion.Fibonacci;

//For more explanation https://www.youtube.com/watch?v=UflHuQj6MVA

//For every i; palindrom[i][i] = true
//For every (i, j); palindrom[i][j] = true if str[i] == str[j] && j-i <= 2
//For every (i, j); palindrom[i][j] = true if str[i] == str[j] && palindrom[i+1][j-1]) == true

public class LongestPalindromicString {

    public static void main(String[] args) {

        String s1 = "BABAD";
        System.out.println("LCSubstring is " + calculateLPSS(s1));
    }

    public static String calculateLPSS(String input) {
        if(input.isEmpty()) {
            return "";
        }
        int n = input.length();
        int longestSoFar = 0, startIndex = 0, endIndex = 0;
        boolean[][] palindrom = new boolean[n][n];

        for(int j = 0; j < n; j++) {
            palindrom[j][j] = true;
            for(int i = 0; i < j; i++) {
//                System.out.println("i- " + i + " j- " + j);
                if(input.charAt(i) == input.charAt(j) && (j-i <= 2 || palindrom[i+1][j-1])) {
                    palindrom[i][j] = true;
                    if(j-i+1 > longestSoFar) {
                        longestSoFar = j-i+1;
                        startIndex = i;
                        endIndex = j;
                    }
                }
            }
        }
        return input.substring(startIndex, endIndex+1);
    }
}
