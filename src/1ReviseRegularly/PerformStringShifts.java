package Programs;
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3299/
public class PerformStringShifts {

    public static void main(String[] args) {

        String subString = "abc";
//        int[][] shift = {{1,1},{1,1},{0,2},{1,3}};
        int[][] shift = {{0,1},{1,2}};
        for(int i = 0; i < shift.length; i++) {
            if (shift[i][0] == 1) {
                subString = rightRotate(subString, shift[i][1]);
                System.out.println(subString);
            }else {
                subString = leftRotate(subString, shift[i][1]);
                System.out.println(subString);
            }
        }
    }

    static String leftRotate(String str, int d) {
        String ans = str.substring(d) + str.substring(0, d);
        return ans;
    }

    static String rightRotate(String str, int d) {
        return leftRotate(str, str.length() - d);
    }
}
