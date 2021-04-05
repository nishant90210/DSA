package Recursion;

public class Recurssion {

	public static void main(String[] args) {

		String s = "ABC";
		System.out.println(permutation(s, ""));
	}

	private static String permutation(String string, String output) {

		if (string.length() == 0) {
			System.out.println(output);
		} else {
			for (int i = 0; i < string.length(); i++) {
				char charToAppend = string.charAt(i);
				String remaining = string.substring(0, i) + string.substring(i+1);
				permutation(remaining, charToAppend + output);
			}
		}
		return output;
	}


}
