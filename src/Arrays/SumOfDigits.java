package Arrays;

import java.util.Scanner;

/**
 * Created by NISHANT on 4/30/18.
 */
public class SumOfDigits {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer sumOfDigits = 0;

        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == '.'){
                continue;
            }
            int numericValue = Character.getNumericValue(aChar);
            sumOfDigits += numericValue;
        }
        System.out.println(sumOfDigits);
    }
}
