package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class FindDuplicateCharacter {

	public static void main(String[] args) throws IOException {

		String str = null;
		int count = 0;
		HashMap<Character, Integer> hashMap = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the String in which you want to find the Duplicate character");
		str = br.readLine();
		if(str != null){
			char[] charArray = str.toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				if (hashMap.containsKey(charArray[i])) {
					count = hashMap.get(charArray[i]);
					count++;
					hashMap.put(charArray[i], count);
				} else {
					hashMap.put(charArray[i], 1);
				}
			}
		}
		
		Iterator<Entry<Character, Integer>> iterator = hashMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Character, Integer> entry = iterator.next();
			System.out.println("WORD - " + entry.getKey() + " / " + "COUNT - " + entry.getValue());
			iterator.remove();
		}

	}

}
