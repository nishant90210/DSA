package TopInterviewQuestions;

//  EXPLANATION
//If last characters of both sequences MATCH(IS SAME) (or X[m-1] == Y[n-1]) then L(X[0..m-1], Y[0..n-1]) = 1 + L(X[0..m-2], Y[0..n-2])
//If last characters of both sequences do not match (or X[m-1] != Y[n-1]) then L(X[0..m-1], Y[0..n-1]) = MAX(L(X[0..m-2], Y[0..n-1]), L(X[0..m-1], Y[0..n-2]))
public class LongestCommonSubsequence {

    public static void main(String[] args) {

        String s1 = "AAB";
        String s2 = "AZB";
        System.out.println("LCS is " + calculateLCS(s1, s2));
    }

//       "" A A B
//     ""  | | | |
//     A   | |*| |      What does * field mean
//     Z   | | | |      It means LCS(A, AA) which is 1 + LCS("", A) which is turn is the diagonal field we calculated earlier
//     B   | | | |
    private static int calculateLCS(String text1, String text2) {

        int s1Length = text1.length();
        int s2Length = text2.length();
        int[][] mat = new int[s1Length+1][s2Length+1];
        if (s1Length == 0 || s2Length == 0){
            return 0;
        }
        for(int i = 0; i <= s1Length; i++){
            for (int j = 0; j <= s2Length; j++) {
                if (i == 0 || j == 0){
                    mat[i][j] = 0;
                }
                else if (text1.charAt(i-1) == text2.charAt(j-1)){
                    mat[i][j] = 1 + mat[i-1][j-1];
                }
                else {
                    mat[i][j] = Math.max(mat[i][j-1], mat[i-1][j]);
                }
            }
        }
        return mat[s1Length][s2Length];
    }
}
