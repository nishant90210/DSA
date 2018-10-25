package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter The String");
		String inputString = br.readLine();
//		char[] charArray = inputString.toCharArray();
//		for (int i = charArray.length-1 ; i >= 0; i--) {
//			char c = charArray[i];
//			System.out.println(c);
//		}
//		StringBuilder builder = new StringBuilder(inputString);
//		StringBuilder reverse = builder.reverse();
//		System.out.print(reverse);

		reverseString(inputString);
	}

	private static void reverseString(String inputString) {

		String newString = "";
		String[] split = inputString.split("\\W+");
		int length = split.length;
		for (int i = length-1; i >= 0; i--) {
			newString += split[i] + " ";
		}
		System.out.println(newString);
	}

}
