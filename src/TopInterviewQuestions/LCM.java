package TopInterviewQuestions;

import java.util.Scanner;

/**
 * Created by NISHANT on 3/16/18.
 * given a and b, find the value of x and y such that ax-by = 0
 *         Since ax - by = 0,
 *         ax = by, which means x/y = b/a
 *         So we can calculate gcd and directly do as -
 *         Value of x = b / gcd;
 *         Value of y = a / gcd;
 */
public class LCM {

    public static void main(String[] args) {

        int x ,y;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two integers");
        x = scanner.nextInt();
        y = scanner.nextInt();

        int gcd = gcd(x, y);
        int lcm = (x * y) / gcd(x, y);
        System.out.println("GCD "  + gcd);
        System.out.println("LCM " + lcm);
    }

    static int gcd(int a, int b)
    {
        if (b == 0) {
            return a;
        }
        int gcd = gcd(b, a % b);
        return gcd;
    }
}
