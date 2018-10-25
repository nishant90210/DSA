package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;


//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
public class AnagramCheck {
	
	
	
	
	
//	public static void main(String[] args) {
//		boolean iAnagram = iAnagram("rare", "aeoi");			ARRAYS SORT
//		if (iAnagram) {
//			System.out.println("yup");
//		} else {
//			System.out.println("nope");
//		}
//	}
//	
//	public static boolean iAnagram(String word, String anagram){
//		char[] charFromWord = word.toCharArray();
//		char[] charFromAnagram = anagram.toCharArray();
//		Arrays.sort(charFromWord);
//        Arrays.sort(charFromAnagram);
//        return Arrays.equals(charFromWord, charFromAnagram);
//		
//	}
	
//}




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
	
	
		
		
		
		
		
		
		
		
		
		
//		int count = 0;
//		String str1 = null;
//		String str2 = null;
//		HashMap<Character, Integer> hashMapStr1 = new HashMap<>();
//		HashMap<Character, Integer> hashMapStr2 = new HashMap<>();
//		try {
//			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
//			System.out.println("Enter the first String");
//			str1 = br1.readLine();
//			char[] ch1 = str1.toCharArray();
//			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
//			System.out.println("Enter the second String");
//			str2 = br2.readLine();
//			char[] ch2 = str2.toCharArray();
//			if(str1.length() == str2.length()){
//				for(int index1 = 0; index1 < ch1.length; index1++){
//					if(hashMapStr1.containsKey(ch1[index1])){
//						count = hashMapStr1.get(ch1[index1]);
//						count++;
//						hashMapStr1.put(ch1[index1], count);
//					}
//					else{
//						hashMapStr1.put(ch1[index1], 1);
//					}
//				}
//				for(int index1 = 0; index1 < ch2.length; index1++){
//					if(hashMapStr2.containsKey(ch2[index1])){
//						count = hashMapStr2.get(ch2[index1]);
//						count++;
//						hashMapStr2.put(ch2[index1], count);
//					}
//					else{
//						hashMapStr2.put(ch2[index1], 1);
//					}
//				}
//				boolean flag=false;
//				for (char c : hashMapStr1.keySet()) {
//					if(!hashMapStr2.containsKey(c)) {
//						System.out.println("String are not anagram");
//						break;
//					}else if(hashMapStr2.get(c) == hashMapStr1.get(c)){
//						flag=true;
//					}else{
//						flag=false;
//					}
//				}
//				if(flag){
//					System.out.println("Both string are anagram");
//				}else{
//					System.out.println("Both string are not anagram");
//				}
//			}
//			else{
//				System.out.println("String entered are not equal");
//			}
//		} 
//		catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}

