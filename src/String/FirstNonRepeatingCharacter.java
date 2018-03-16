package String;

import java.util.LinkedHashMap;
import java.util.Map;

//	http://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		
		int count;
		String str = "geeksforgeeks";
		Map<Character, Integer> charCountMap = new LinkedHashMap<Character, Integer>();
		
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
