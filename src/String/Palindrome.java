package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the String");
		String inputString = br.readLine();
//		boolean palindrome = isPalindrome(inputString);
		boolean palindrome = isPalindromeCharAt(inputString);
		if(palindrome){
			System.out.println("Palindrome");
		}
		else{
			System.out.println("Not Palindrome");
		}
	}

	private static boolean isPalindromeCharAt(String inputString) {

		for (int i = 0; i < inputString.length()/2; i++) {
			if (inputString.charAt(i) != inputString.charAt(inputString.length() - 1 -i)){
				return false;
			}
		}
		return true;
	}

	private static boolean isPalindrome(String inputString) {

		boolean flag = true;
		int start = 0;
		int end = inputString.length()-1;
		while(start < end){
			char startingChar = inputString.charAt(start);
			char endingChar = inputString.charAt(end);
			if(startingChar != endingChar){
				flag = false;
				break;
			}
			start++;
			end--;
		}
		return flag;
	}

//	private static boolean isPalindrome(String inputString) {
//
//		if(inputString==null){
//			return false;
//		}
//		StringBuilder builder = new StringBuilder(inputString);
//		StringBuilder reverseString = builder.reverse();
//		if(reverseString.toString().equals(inputString)){
//			return true;
//		}
//		else{
//			return false;
//		}
//	}
}
