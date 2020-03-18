package TopInterviewQuestions;

import java.util.Arrays;

/**
 * Created by NISHANT on 3/28/18.
 */
import java.util.Random;
import java.util.Scanner;

public class CreateNumber {
    static void permute(int[] a, int k)
    {
        if (k == a.length)
        {
            for (int i = 0; i < a.length; i++)
            {
                System.out.print(" [" + a[i] + "] ");
            }
            System.out.println();
        }
        else
        {
            for (int i = k; i < a.length; i++) {
                int temp = a[k];
                a[k] = a[i];
                a[i] = temp;

                permute(a, k + 1);

                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
    }

    public static void main(String args[]) {

        permute(new int[]{1,2,3} , 0);

//        Random random = new Random();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the length of list: ");
//        int N = sc.nextInt();
//        int[] sequence = new int[N];
//
//        for (int i = 0; i < N; i++)
//            sequence[i] = Math.abs(random.nextInt(10));
//
//        System.out.println("The original sequence is: ");
//        for (int i = 0; i < N; i++)
//            System.out.print(sequence[i] + " ");
//
//        System.out.println("\nThe permuted sequences are: ");
//        permute(sequence, 0);
//
//        sc.close();
    }
}