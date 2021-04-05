package Arrays;

//import javafx.util.Pair;

import java.util.Arrays;
import java.util.TreeMap;

class Pair<F, S> {
    F first;
    S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }


    public S getValue() {
        return second;
    }
}
public class NextGreaterWithSameDigit {

    public static void main(String[] args)
    {
//        char digits[] = { '5','3','4','9','7','6' };
//        int n = digits.length;
        String s = "218765";
        char[] digits = new char[s.length()];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = s.charAt(i);
        }
        int n = digits.length;
        findNextGreaterNumber(digits, n);
        findNextGreater(digits, n);
    }

    private static void findNextGreaterNumber(char[] digits, int n) {

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int i = n-1;
        while (true){
            // Find the first lowest number going from right to left
            if (digits[i] > digits[i-1]) {
                break;
            }else {
                i--;
            }
            if (i == 0){
                System.out.println("NP");
                return;
            }
        }

        //find the next just greater number towards right for the number you just find in the array
        Pair<Integer, Integer> greaterElement = getGreaterElement(digits, n, treeMap, i);
        //Swap the lowest number with the next just greater number towards right
        swap(digits, i-1, greaterElement.second);
        Arrays.sort(digits, i, n);
        System.out.print("Next number with same" + " set of digits is ");
        for (i = 0; i < n; i++) {
            System.out.print(digits[i]);
        }
        System.out.println();
    }

    private static Pair<Integer, Integer> getGreaterElement(char[] digits, int n, TreeMap<Integer, Integer> treeMap, int i) {
        for (int j = n-1; j >= i-1; j--){

            Integer ceiling = treeMap.ceilingKey(digits[j] - '0');
            if (ceiling == null){
                treeMap.put(digits[j] - '0', j);
            } else {
                return new Pair<>(ceiling, treeMap.get(ceiling));
            }
        }
        return null;
    }


    private static void findNextGreater(char[] digits, int n) {

        int i;
        // I) Start from the right most digit and find the first digit that is smaller than the digit next to it.
        for (i = digits.length-1; i > 0; i--) {
            if (digits[i] > digits[i-1]){
                break;
            }
        }
        // If no such digit is found, then all digits are in descending order means
        // there cannot be a greater number with same set of digits
        if (i==0){
            System.out.println("NP");
        }
        else {
            int x = digits[i - 1];
            int min = i;
            // II) Find the smallest digit on right side of (i-1)'th digit that is greater than number[i-1]
            for (int j = i + 1; j < n; j++) {
                if (digits[j] > x && digits[j] < digits[min]) {
                    min = j;
                }
            }
            // III) Swap the above found smallest digit with number[i-1]
            swap(digits, i - 1, min);

            // IV) Sort the digits after (i-1) in ascending order
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
