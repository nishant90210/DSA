package TopInterviewQuestions;

import java.util.Scanner;

/**
 * Created by NISHANT on 4/25/18.
 */
public class NElementsOfFibonacci {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number");
        int num = scanner.nextInt();
        printFibo(num);

    }

    private static void printFibo(int num) {

        int first = 1, second = 0, next;
        for (int i = 1; i <= num; i++) {
            System.out.print(first + " ");
            next = first + second;
            second = first;
            first = next;

        }
    }
}
