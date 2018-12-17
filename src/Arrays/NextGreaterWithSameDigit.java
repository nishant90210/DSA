package Arrays;

import java.util.Arrays;

public class NextGreaterWithSameDigit {

    public static void main(String[] args)
    {
        char digits[] = { '5','3','4','9','7','6' };
        int n = digits.length;
        findNext(digits, n);
    }

    private static void findNext(char[] digits, int n) {

        int i;
        for (i = digits.length-1; i > 0; i--) {
            if (digits[i] > digits[i-1]){
                break;
            }
        }
        if (i==0){
            System.out.println("NP");
        }
        else {
            int min = i;
            for (int j = i+1; j < digits.length; j++) {
                if (digits[j] > digits[j-1] && digits[j] < digits[min]){
                    min = j;
                }
            }
            swap(digits, i - 1, min);
            Arrays.sort(digits, i, n);
            System.out.print("Next number with same" + " set of digits is ");
            for (i = 0; i < n; i++)
                System.out.print(digits[i]);
        }
    }

    private static void swap(char[] digits, int i, int j) {

        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }
}
