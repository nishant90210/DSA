package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class RemoveCharFromString {

	public static void main(String[] args) throws IOException {
		
			String inputString = null;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter The String");
			inputString = br.readLine();
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter The Char");
			char ch = br1.readLine().charAt(0);
			String newString = removeRecursive(inputString, ch);
			System.out.println(newString);

//			StringBuilder sb = new StringBuilder(inputString);
//			for (int i = 0; i < sb.length(); i++) {
//				if(sb.charAt(i) == ch){
//					sb.deleteCharAt(i);
//				}
//			}
//			System.out.println(sb.toString());
			
	}
	
	public static String removeRecursive(String inputString, char ch1){
		int index = inputString.indexOf(ch1); 
			if(index == -1){ 
				return inputString; 
			} 
		return removeRecursive(inputString.substring(0, index) + inputString.substring(index +1, inputString.length()), ch1);
	}

}
