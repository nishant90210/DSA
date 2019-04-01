package Programs;

import java.util.Scanner;

/**
 * Created by NISHANT on 3/19/18.
 */
public class Synopsis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the number");
//        int i = scanner.nextInt();
        print2(5);
    }

    private static void print2(int n) {

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {

            }
        }
    }



//    private static void print2(int n) {
//
//        /*
//                4
//              3 4 3
//            2 3 4 3 2
//          1 2 3 4 3 2 1
//         */
//        for (int i = 4; i >= 1; i--) {
//            for (int j = 1; j <= i*2; j++) {
//                System.out.print(" ");
//            }
//            for (int j = i; j <= 4; j++) {
//                System.out.print(j+" ");
//            }
//            for (int j = 4-1; j >= i; j--) {
//                System.out.print(j+" ");
//            }
//            System.out.println();
//        }
//    }

//    private static void print2(int a) {
//        /*
//            *
//           ***
//          *****
//         *******
//        *********
//         */
//        int i,j,k;
//        for(i=1; i<=5; i++) {
//            for(j=4; j>=i; j--) {
//                System.out.print(" ");
//            }
//            for(k=1; k<=(2*i-1); k++) {
//                System.out.print("*");
//            }
//            System.out.println("");
//        }
//    }

//    private static void print2(int x) {
//        /*
//         1
//         2 3
//         4 5 6
//         7 8 9 10
//         11 12 13 14 15
//         */
//        int no = 1;
//        for (int i = 1; i <= x; i++) {
//            for (int j = 0; j < i; j++) {
//                System.out.print(" " + no);
//                no++;
//            }
//            System.out.println();
//        }
//    }

//    private static void print2(int i) {
//
////       *
////     *  *
////   *  *  *
//// *  *  *  *
//        int t = 0;
//        for (i=1; i<=5; i++) {
//            for (int k=t; k<5; k++) {
//                System.out.print(" ");
//            }
//            for (int j=0; j< i; j++) {
//                System.out.print(" * ");
//                t = t + 1;
//            }
//            System.out.println();
//        }
//
//    }

    private static void print(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

/*
    *
   **
  ***
 ****
*****

*/
//    public static void print2(int n) {
//
//        int x;
//        int j;
//        for (x = n; x > 0; x--) {
//            for (j = 1; j <= x-1; j++){
//                System.out.print(" "); // switch for next pattern
//            }
//            for (int k = 0; k <= n-x ; k++) {
//                System.out.print("*"); //switch
//            }
//            System.out.println();
//        }
//        for (x = n; x > 0; x--) {
//            for (j = 1; j <= x-1; j++){
//                System.out.print("*"); // switch for next pattern
//            }
//            for (int k = 0; k <= n-x ; k++) {
//                System.out.print(" "); //switch
//            }
//            System.out.println();
//        }
//    }

//    public static void print2(int n) {
//
//        /*
//             *
//            * *
//           * * *
//          * * * *
//         * * * * *
//
//         */
//
//        for(int i=0;i<n;i++){
//                for(int j=0;j<n-i;j++){
//                    System.out.print(" ");
//                }
//                for(int k=0;k<=i;k++){
//                    System.out.print("* ");
//                }
//            System.out.println();
//        }
//
//    }


}

