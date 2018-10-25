package Programs;

/**
 * Created by NISHANT on 3/23/18.
 */

// https://www.geeksforgeeks.org/pascal-triangle/
public class PascalTriangle {

    public static void main(String[] args) {

        int n = 7;
        int pascal[][] = new int[n][n];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                if (k == 1 || k == i){
                    pascal[i][k] = 1;
                }else {
                    pascal[i][k] = pascal[i-1][k-1] + pascal[i-1][k];
                }
                System.out.print(pascal[i][k] + " ");
            }
            System.out.println();
        }
    }

//    public static void main(String[] args) {
//
//        int n = 6;
//        for (int i = 1; i < 2; i++) {
//            for (int j = 0; j < n - i; j++) {
//                System.out.print(" ");
//            }
//            for (int line = 1; line <= n; line++) {
//                int C = 1;  // used to represent C(line, i)
//                for (int k = 1; k <= line; k++) {
//                    System.out.print(C+" ");  // The first value in a line is always 1
//                    C = C * (line - k) / k;
//                }
//                System.out.println();
//            }
//        }
//    }
}
