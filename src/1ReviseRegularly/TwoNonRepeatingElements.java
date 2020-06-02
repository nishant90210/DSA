package TopInterviewQuestions;

/**
 * Created by NISHANT on 4/4/18.
 */
// https://www.geeksforgeeks.org/find-the-two-numbers-with-odd-occurences-in-an-unsorted-array/
// Also for printing two odd numbers
public class TwoNonRepeatingElements {

    /*
        1) XOR of any number n with itself gives us 0, i.e., n ^ n = 0
        2) XOR of any number n with 0 gives us n, i.e., n ^ 0 = n
        3) XOR is cumulative and associative.
    */
    public static void main(String[] args) {

        int arr[] = {2, 3, 7, 9, 11, 2, 3, 11};
        get2NonRepeatingNumbers(arr);
    }

    /* Prints two numbers that occur odd number of times. The function assumes that the array size is at least 2 and
       there are exactly two numbers occurring odd number of times. */
    private static void get2NonRepeatingNumbers(int[] arr) {

        int x = 0;
        int y = 0;
        int xor = arr[0];/* Will hold xor of all elements */
        int set_bit_no = 0; /* Will have only single set bit of xor */

        /* Get the xor of all elements in arr[]. The xor will basically be xor of two odd occurring elements */
        for (int i = 1; i < arr.length; i++) {
            xor ^= arr[i];
        }

        /* Get one set bit in the xor2. We get rightmost set bit in the following line as it is easy to get */
        set_bit_no = xor & ~(xor-1);

        /* Now divide elements in two sets:
            1) The elements having the corresponding bit as 1.
            2) The elements having the corresponding bit as 0.  */
        for (int i = 0; i < arr.length; i++) {
                /* XOR of first set is finally going to hold one odd occurring number x */
            if ((arr[i] & set_bit_no) > 0){
                x = x ^ arr[i];
                /* XOR of second set is finally going to hold the other odd occurring number y */
            }else {
                y = y ^ arr[i];
            }
        }
        System.out.println("The two ODD elements are "+ x + " & " + y);
    }
}
