package String;

import com.sun.istack.internal.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseStringAndNumber {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter The String");
		String inputString = br.readLine();

		reverseSentence(inputString);
        reverseString(inputString);
		reverseNumber(1234);
	}

    private static void reverseNumber(int i) {

	    int reversed = 0;
	    while (i != 0){
            int digit = i % 10;
            reversed = reversed * 10 + digit;
            i = i / 10;
        }
        System.out.println(reversed);
    }


    private static void reverseString(@NotNull String inputString) {

        char[] chars = inputString.toCharArray();
        for (int i = chars.length-1; i >= 0 ; i--) {
            System.out.print(chars[i]);
        }
    }

	private static void reverseSentence(@NotNull String inputString) {

		String newString = "";
		String[] split = inputString.split("\\W+");
		int length = split.length;
		for (int i = length-1; i >= 0; i--) {
			newString += split[i] + " ";
		}
		System.out.println(newString);
	}

}
