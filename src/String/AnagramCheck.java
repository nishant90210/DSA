package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AnagramCheck {

	public static void main(String[] args) {

		try{
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the first String");
			String str1 = br1.readLine();
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the second String for anagram check");
			String str2 = br2.readLine();
			if(str1.length() == str2.length()){
				boolean checkAnagram = checkAnagram(str1, str2);
				if(checkAnagram){
					System.out.println("YUP");
				}
				else{
					System.out.println("NOPE");
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	private static boolean checkAnagram(String word, String anagram) {
		char[] charArray = word.toCharArray();
		for (char c : charArray) {
			int index = anagram.indexOf(c);
			if(index == -1){
				return false;
			}else{
				anagram = ((anagram.substring(0, index)) + anagram.substring(index+1, anagram.length()));
			}
		}
		return anagram.isEmpty();
	}
}