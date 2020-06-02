package Programs;

import java.util.Arrays;
import java.util.Comparator;

public class RussianEnvelop {

    public static void main(String[] args) {

        int[][] envelopes = { {5,4},{6,4},{6,7},{2,3} };
        int i = maxEnvelopes(envelopes);
        System.out.println(i);
    }

    private static int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });
        for (int i = 0; i < envelopes.length; i++) {
            System.out.println(envelopes[i][0] + " " + envelopes[i][1]);
        }
        int max=1;
        int[] dp = new int[envelopes.length];
        for(int i=0; i<envelopes.length; i++){
            dp[i]=1;
            for(int j=i-1; j>=0; j--){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
