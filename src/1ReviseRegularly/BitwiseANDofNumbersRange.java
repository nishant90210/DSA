package Programs;

//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3308/
public class BitwiseANDofNumbersRange {

    public static void main(String[] args) {

        int m = 4;
        int n = 8;
        System.out.println(rangeBitwiseAnd(m, n));
    }

    public static int rangeBitwiseAnd(int m, int n) {

        if (m == n) {
            return m;
        }
        int result = m;
        for (int i = m + 1; i <= n; i++) {
            result = result & i;
            if (result == 0){
                return 0;
            }
            if(i == Integer.MAX_VALUE){// For Interger Max Value
                return m;
            }
        }
        return result;
    }
}
