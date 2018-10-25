package String;

public class PermutationOfString {

	public static void main(String[] args) {

		String input = "SIM";
		permutation(input);

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