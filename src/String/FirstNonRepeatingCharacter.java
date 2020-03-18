package String;

import java.util.LinkedHashMap;
import java.util.Map;

//	http://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/

public class FirstNonRepeatingCharacter {

	static final int NO_OF_CHARS = 256;
	static char count[] = new char[NO_OF_CHARS];

	public static void main(String[] args) {

		String str = "geeksforgeeks";
		int index =  firstNonRepeating(str);
		System.out.println(index == -1 ? "Either all characters are repeating or string " +
				"is empty" : "First non-repeating character is " +  str.charAt(index));
	}

	static void getCharCountArray(String str)
	{
		for (int i = 0; i < str.length();  i++)
			count[str.charAt(i)]++;
	}

	static int firstNonRepeating(String str) {
		getCharCountArray(str);
		int index = -1, i;

		for (i = 0; i < str.length();  i++) {
			if (count[str.charAt(i)] == 1) {
				index = i;
				break;
			}
		}
		return index;
	}

	private static void getChar(String str, Map<Character, Integer> charCountMap) {
		int count;
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if(charCountMap.containsKey(charArray[i])){
				count = charCountMap.get(charArray[i]);
				count++;
				charCountMap.put(charArray[i], count);
			}
			else{
				charCountMap.put(charArray[i], 1);
			}
		}

		for (Map.Entry search : charCountMap.entrySet()) {
			if(search.getValue().equals(1)){
				System.out.println("First non-repeating character is " + search.getKey() + " with a value of ofcourse " + search.getValue());
				break;
			}
		}
	}
}
