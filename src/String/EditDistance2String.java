package String;

import java.util.ArrayList;
import java.util.List;

public class EditDistance2String {

	public static void main(String[] args) {
		
		List<Character> extraCharList = new ArrayList<Character>();
//		String loopingStr = null;
//		String comparingStr = null;
		String str1 = "acd";
		String str2 = "abcd";
		int j;
		int i;
//		int x = 0;
		int count = 1;

//		int strLength = str1.compareTo(str2);
//		if(strLength > 0){
//			loopingStr = str2;
//			comparingStr = str1;
//		}else if (strLength == 0) {
//			loopingStr = str2;
//			comparingStr = str1;
//		}else{
//			loopingStr = str1;
//			comparingStr = str2;
//		}

		String loopingStr = "geek";
		String comparingStr = "gesaek";
		
		char[] loopingCharArray = loopingStr.toCharArray();
		char[] comparingCharArray = comparingStr.toCharArray();
		for (i = 0; i < loopingCharArray.length; ) {
			for (j = i; j < comparingCharArray.length;) {
//				System.out.println("looping----" +loopingCharArray[i]);
//				System.out.println("comparing----" +comparingCharArray[j]);
				if(loopingCharArray[i] != comparingCharArray[j]){
					extraCharList.add(comparingCharArray[j]);
					j++;
					continue;
				}else{
					i++;
					j++;
					continue;
				}
			}
		}
		System.out.println("Given two strings can be EQUAL by removing " + extraCharList.toString());
	}

}
