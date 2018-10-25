package Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by NISHANT on 9/25/17.
 */
public class GenerateBinaryNumbers {

    public static void main(String[] args)
    {
        int n=6;
        generatePrintBinary(n);
    }

    private static void generatePrintBinary(int n) {

        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        while (n-- > 0){
            String s1 = queue.peek();
            queue.remove();
            System.out.println(" "+ s1);
            // Store s1 before changing it
            String s2 = s1;

            // Append "0" to s1 and enqueue it
            queue.add(s1 + "0");

            // Append "1" to s2 and enqueue it. Note that s2 contains
            // the previous front
            queue.add(s2 + "1");
        }
    }
}
