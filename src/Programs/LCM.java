package Programs;

import java.util.Scanner;

/**
 * Created by NISHANT on 3/16/18.
 */
public class LCM {

//        public static void main(String[] args) {
//            int a = 4;
//            int b = 6;
//            int big;
//            int small;
//            // print the two numbers for which the Programs.LCM to be calculate
//            System.out.println("the value of a:" + a);
//
//            System.out.println("the value of b:" + b);
//            {
//                if (a > b) // check whether a is big or b is big
//                {
//                    big = a;
//                    small = b;
//                } else {
//                    big = b;
//                    small = a;
//                }
//                for (int i = 1; i <= big; i++) {
//                    if (((big * i) % small) == 0) {
//                        int lcm = big * i; // condition to calculate the Programs.LCM of two
//                        // numbers
//                        System.out.println("The least common multiple is " + (lcm));
//                        // print the Programs.LCM of two numbers
//                        break;
//                    }
//                }
//            }
//        }

    public static void main(String[] args) {

        int a ,b ,x ,y ,t, gcd, lcm;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two integers");
        x = scanner.nextInt();
        y = scanner.nextInt();

        a = x;
        b = y;
        while (b != 0){
            t = b;
            b = a % b;
            a = t;
        }

        gcd = a;
        lcm = (x*y) / gcd;
        System.out.println("GCD "  + gcd);
        System.out.println("LCM " + lcm);
    }


}
