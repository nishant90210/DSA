package String;

import java.util.HashSet;
import java.util.Set;

public class PermutationOfString {

	public static void main(String[] args) {

		String input = "SIM";
//		Set<String> strings = permutationFinder(input);
//		System.out.println(strings);
		permutationC("123");
	}

	private static void permutationC(String string) {
		printPermutation(string,"");
	}

	private static void printPermutation(String string, String permutation) {

		if(string.length()==0){
			System.out.println(permutation);
			return;
		}

		for (int i = 0; i < string.length(); i++) {
			char toAppendToPermutation = string.charAt(i);
			String remaining = string.substring(0, i) + string.substring(i + 1);

			printPermutation( remaining,  permutation + toAppendToPermutation);
		}
	}

	private static Set<String> permutationFinder(String str) {

		Set<String> perm = new HashSet<>();
		//Handling error scenarios
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			perm.add("");
			return perm;
		}
		char initial = str.charAt(0); // first character
		String rem = str.substring(1); // Full string without first character
		Set<String> words = permutationFinder(rem);
		for (String strNew : words) {
			for (int i = 0;i<=strNew.length();i++){
				perm.add(charInsert(strNew, initial, i));
			}
		}
		return perm;
	}

	private static String charInsert(String strNew, char c, int j) {

		String begin = strNew.substring(0, j);
		String end = strNew.substring(j);
		return begin + c + end;
	}

	private static void permutation(String input) {

		permutationHelper(input, "");
	}


	private static void permutationHelper(String input, String chosenString) {

		System.out.println("helper (\"" + input + "\"" + ", \"" + chosenString + "\"" + ")" );
		if (input.isEmpty()) {
			System.out.println(chosenString);
		} else {
			char[] chars = input.toCharArray();
			for (int i = 0; i < input.length(); i++) {
				char c = chars[i];
				chosenString += c;

				input = input.substring(0, i-1) + input.substring(i+1, input.length());
				permutationHelper(input, chosenString);
				input = input + chosenString;
				chosenString = chosenString.substring(chosenString.length()-1);
			}
		}
	}
}