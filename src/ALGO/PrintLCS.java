package ALGO;

/**
 * Created by NISHANT on 11/13/17.
 */
public class PrintLCS {

        public static void main(String[] args) {
            String str1 = "AGTABA";
            String str2 = "GTABGTAB";

            int m = str1.length(),n=str2.length();

            String[][] LCS = new String[m+1][n+1];
            for(int i=0;i<=m;i++) {
                for(int j=0;j<=n;j++) {

                    if(i==0 || j==0) {
                        LCS[i][j]="";
                    }
                    else if(str1.charAt(i-1)==str2.charAt(j-1)){
                        LCS[i][j]=LCS[i-1][j-1]+str1.charAt(i-1);
                    }
                    else {
                        LCS[i][j] = maximum(LCS[i][j-1], LCS[i-1][j]);
                    }
                }
            }
            System.out.println(LCS[m][n]);
        }

    private static String maximum(String s1, String s2) {

        return (s1.length() > s2.length()) ? s1 : s2;
    }

}
