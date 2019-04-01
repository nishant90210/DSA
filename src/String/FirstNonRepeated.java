package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map.Entry;


public class FirstNonRepeated {

	public static void main(String[] args) {

		try{
			int count;
			int index;
			LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<>();  // LinkedHashMap maintains insertion order
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the String");
			String str = br.readLine();
			char[] charArray = str.toCharArray();
			for (index = 0; index < charArray.length; index++) {
				char ch = charArray[index];
				if(linkedHashMap.containsKey(ch)){
					count = linkedHashMap.get(charArray[index]);
					count++;
					linkedHashMap.put(charArray[index], count);
				}
				else{
					linkedHashMap.put(charArray[index], 1);
				}
			}
			for(Entry<Character, Integer> entrySet : linkedHashMap.entrySet()){
				Integer value = entrySet.getValue();
				if(value == 1){
					System.out.println("The First Non-Repeated Character is : " + entrySet.getKey());
					break;
				}
			}
			
//			Iterator iterator = linkedHashMap.entrySet().iterator();
//			while (iterator.hasNext()) {
//				Entry entry = (Entry)iterator.next();
//				System.out.println("The Entries are : " + entry);
//				Object value = entry.getValue();
//				System.err.println(value);
////				System.out.println("The First Non-Repeated Character is : " + charArray[index]);
//			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
}
