package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Nishant on Dec, 2018
 */
public class ConvertToPalindrome {

    public static void main(String[] args) throws IOException {

        convertToPalindrome("ameba");
    }

    private static void convertToPalindrome(String inputString) {

        StringBuilder stringBuilder = new StringBuilder(inputString);
        int count = 0;
        for (int i = 0; i < inputString.length()/2; i++) {
            if (inputString.charAt(i) == inputString.charAt(inputString.length() - 1 - i)){
                continue;
            } else {
                count++;
            }
            if (inputString.charAt(i) < inputString.charAt(inputString.length() - 1 - i)){
                stringBuilder.setCharAt(inputString.length() - 1 - i, inputString.charAt(i));
            }else {
                stringBuilder.setCharAt(i, inputString.charAt(inputString.length() - 1 - i));
            }
        }
        System.out.println(stringBuilder.toString());
        System.out.println(count);
    }
}
