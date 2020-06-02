package TopInterviewQuestions;

//  EXPLANATION
//If last characters of both sequences MATCH(IS SAME) (or X[m-1] == Y[n-1]) then L(X[0..m-1], Y[0..n-1]) = 1 + L(X[0..m-2], Y[0..n-2])
//If last characters do not match, then result is 0, i.e., LCSuff(X, Y) = 0 if (X[m-1] != Y[n-1])
public class LongestCommonSubstring {

    public static void main(String[] args) {

        String s1 = "GEEKSFORGEEKS";
        String s2 = "GEEKSQUIZ";
        System.out.println("LCSubstring is " + calculateLCSS(s1, s2));

    }

    private static int calculateLCSS(String text1, String text2) {

        int result = 0;
        int endIndex = 0;
        int[][] mat = new int[text1.length()+1][text2.length()+1];
        if (text1.length() == 0 || text2.length() == 0){
            return result;
        }
        for(int i = 0; i <= text1.length(); i++){
            for(int j = 0; j <= text2.length(); j++){
                if (i == 0 || j ==0){
                    mat[i][j] = 0;
                } else if (text1.charAt(i-1) == text2.charAt(j-1)){
                    mat[i][j] = 1 + mat[i-1][j-1];
                    result = Math.max(result, mat[i][j]);
                    endIndex = i;
                } else {
                    mat[i][j] = 0;
                }
            }
        }
        if (endIndex > result){
            System.out.println((text1.length() > text2.length() ? text1 : text2).substring(endIndex - result, endIndex));
        }
        return result;
    }
}
