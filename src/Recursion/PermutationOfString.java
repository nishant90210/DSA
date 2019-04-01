package Recursion;


public class PermutationOfString {

//	public static void main(String[] args) {

//		String[] str = {"NIKA"};
//		for (String string : str) {
//			for (int i = 0; i < string.length(); i++) {
//				System.out.println("With index " + string.substring(0,i));
//				System.out.println("Without index " + string.substring(i));
//			}
//		}



//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("Enter the String");
//		String inputString = scanner.next();
//		
//		
//		scanner.close();


//		System.out.println(permutation(input));
//		Set<String> perm = new HashSet<String>();
//		
//		System.out.println(perm);
//		System.out.println(permutation("ABC"));
//	}

//	private static Set<String> permutation(String input) {
//
//		
//		if(input.length() == 0){
//			return 
//					
//		}
//		return null;
//	}


//	public static Set<String> permutation(String input)
//	{
//		
//		Set<String> set = new HashSet<String>();
//		if (input == ""){
//			return set;
//		}
//		Character a = input.charAt(0);
//		input = input.substring(1);
//		if (input.length() > 1)
//		{
//			Set<String> permSet = permutation(input);
//			for (String x : permSet)
//			{
//				for (int i = 0; i <= x.length(); i++)
//				{
//					set.add(x.substring(0, i) + a + x.substring(i));
//				}
//			}
//		}
//		else
//		{
//			set.add(a + "");
//		}
//		return set;
//	}


//	private static Set<String> permutation(String input) {
//		
//		TreeSet<String> perm = new TreeSet<String>();
//		
//		if (input == null) {
//            return null;
//        } else if (input.length() == 0) {
//            perm.add("");
//            return perm;
//        }
//		
//		char firstChar = input.charAt(0);
//		String remainingString = input.substring(1);
//		Set<String> words = permutation(remainingString);
//		for (String strNew : words) {
//            for (int i = 0;i<=strNew.length();i++){
//                perm.add(charInsert(strNew, firstChar, i));
//            }
//        }
//        return perm;
//		
//	}
//
//	private static String charInsert(String strNew, char firstChar, int i) {
//		 String begin = strNew.substring(0, i);
//	        String end = strNew.substring(i);
//	        return begin + firstChar + end;
//	}
//}



	public static void main(String args[]) {

		permuteString("", "ABC");
	}

	public static void permuteString(String beginningString, String endingString) {
		if (endingString.length() <= 1)
			System.out.print(beginningString + endingString + ",");
		else
			for (int i = 0; i < endingString.length(); i++) {
				try {
					String newString = endingString.substring(0, i) + endingString.substring(i + 1);

					permuteString(beginningString + endingString.charAt(i), newString);
					System.out.print("");
				} catch (StringIndexOutOfBoundsException exception) {
					exception.printStackTrace();
				}
			}
	}
}