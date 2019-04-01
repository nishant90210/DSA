package Queue;

import java.util.*;
import java.util.Queue;

/**
 * Created by NISHANT on 9/15/17.
 */


/**
 * Problem :
 * ;
 * Find the largest multiple of 3
 * Given an array of non-negative integers. Find the largest multiple of 3 that can be formed from array elements.
 * For example, if the input array is {8, 1, 9}, the output should be “9 8 1”, and
 * if the input array is {8, 1, 7, 6, 0}, output should be “8 7 6 0”.
 * ;
 * Solution:
 * ;
 * Number three has some special property
 * -  A number is multiple of 3 if and only if the sum of digits of number is multiple of 3.
 * For example, let us consider 8760, it is a multiple of 3 because sum of digits is 8 + 7+ 6+ 0 = 21,
 * which is a multiple of 3.
 * -  If a number is multiple of 3, then all permutations of it are also multiple of 3.
 * For example, since 6078 is a multiple of 3, the numbers 8760, 7608, 7068, ….. are also multiples of 3.
 * - We get the same remainder when we divide the number and sum of digits of the number.
 * For example, if divide number 151 and sum of it digits 7, by 3, we get the same remainder 1.
 * </p>
 *
 */

public final class LargestMultipleOfThree {

    private static boolean getDiv(java.util.Queue<Integer> queue1, Queue<Integer> queue2) {
        if (!queue1.isEmpty()) {
            queue1.remove();
        } else {
            if (!queue2.isEmpty()) {
                queue2.remove();
            } else {
                return true;
            }
            if (!queue2.isEmpty()) {
                queue2.remove();
            } else {
                return true;
            }
        }
        return false;
    }

    public static int divThree(int[] a) {
        final java.util.Queue<Integer> queue0 = new LinkedList<Integer>(); // if num % 3 == 0, store num in queue0.
        final java.util.Queue<Integer> queue1 = new LinkedList<Integer>(); // if num % 3 == 1, store num in queue1.
        final java.util.Queue<Integer> queue2 = new LinkedList<Integer>(); // if num % 3 == 2, store num in queue2.

        Arrays.sort(a);

        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum  + a[i];

            int remainder = a[i] % 3;

            if (remainder == 0) {
                queue0.add(a[i]);
            } else  if (remainder == 1) {
                queue1.add(a[i]);
            } else {
                queue2.add(a[i]);
            }
        }

        if (sum % 3 == 1) {
            if (getDiv(queue1, queue2)) return -1;
        } else if (sum % 3 == 2) {
            if (getDiv(queue2, queue1)) return -1;
        }

        final List<Integer> list = new ArrayList<Integer>();
        list.addAll(queue0);
        list.addAll(queue1);
        list.addAll(queue2);

        Collections.sort(list);

        int result = 0;
        int pow = 1;
        for (int i = 0; i < list.size(); i++) {
            result = result  + pow * list.get(i);
            pow = pow * 10;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4};
        System.out.println(divThree(a1));
    }
}



//public class LargestMultipleOfThree {
//
//    public static int find(int[] array) {
//
//        /** sort in ascending order **/
//        Arrays.sort(array);
//
//                /** To hold those digits such that digit % 3 == 0 **/
//                Queue<Integer> queue0 = new Queue<>();
//        /** To hold those digits such that digit % 3 == 1 **/
//        Queue<Integer> queue1 = new Queue<>();
//        /** To hold those digits such that digit % 3 == 2 **/
//        Queue<Integer> queue2 = new Queue<>();
//
//        /** Separating digits based on their remainder **/
//        int sum = 0;
//        for (int i = 0; i < array.length; i++) {
//        sum += array[i];
//        switch (array[i] % 3) {
//        case 0:
//        queue0.enqueue(array[i]);
//        break;
//        case 1:
//        queue1.enqueue(array[i]);
//        break;
//default:
//        queue2.enqueue(array[i]);
//        break;
//        }
//        }
//
//        // @// TODO: 20/11/16 deep dive
//
//        /** Remove some digit **/
//        switch (sum % 3) {
//        case 1:
//        if (!queue1.isEmpty()) {
//        dequeueX(queue1, 1);
//        } else {
//        dequeueX(queue2, 2);
//        }
//        break;
//        case 2:
//        if (!queue2.isEmpty()) {
//        dequeueX(queue2, 1);
//        } else {
//
//        dequeueX(queue1, 2);
//        }
//        break;
//        }
//
//        /** Merge all digits from did**/
//        Integer[] digits = mergeQueue(queue0, queue1, queue2);
//
//        /** Sort digit in reverse order **/
//        Arrays.sort(digits, Collections.reverseOrder());
//
//        return formNumber(digits);
//
//        }
//
//private static int formNumber(Integer[] digits) {
//        StringBuilder sb = new StringBuilder(digits.length);
//        for (int i = 0; i < digits.length; i++) {
//        sb.append(digits[i]);
//        }
//
//        return Integer.valueOf(sb.toString());
//        }
//
//private static Integer[] mergeQueue(Queue<Integer> queue0, Queue<Integer> queue1, Queue<Integer> queue2) {
//
//        Integer[] array = new Integer[queue0.getSize() + queue1.getSize() + queue2.getSize()];
//
//        int i = 0;
//        while (!queue0.isEmpty()) {
//        array[i++] = queue0.dequeue();
//        }
//
//        while (!queue1.isEmpty()) {
//        array[i++] = queue1.dequeue();
//        }
//        while (!queue2.isEmpty()) {
//        array[i++] = queue2.dequeue();
//        }
//        return array;
//        }
//
//private static void dequeueX(Queue<Integer> queue, int numberOfTimes) {
//        try {
//        for (int i = 0; i < numberOfTimes; i++) {
//        queue.dequeue();
//        }
//        } catch (Exception e) {
//        throw new RuntimeException("Number not possible ");
//        }
//        }
//
//        }
//
//
//class LargestMultipleOfThreeTest {
//    public static void main(String[] args) {
//        int[] digits = {8, 1, 7, 6, 0};
//        System.out.println(LargestMultipleOfThree.find(digits));
//    }
//}