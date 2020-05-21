package Programs;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String str = "AZJKSFZTS";
        String pat = "SZ";

//        System.out.println("Found string :\n " + checkIfPatternPresentInSearchString(str, pat));
        System.out.print("Smallest window is :\n " + findSubString(str, pat));
    }

//    public static String checkIfPatternPresentInSearchString(String searchString, String pattern) {
//
//        int[] letterCount = new int[128];
//        int count = 0;
//        int left = 0;
//        for (char ch : pattern.toCharArray()) {
//            //Count the letters in Pattern String
//            letterCount[ch]++;
//        }
//        for (int index = 0; index < searchString.length(); index++) {
//            //Check if searchString contains pattern string, just check if it contains
//            char charAtIndex = searchString.charAt(index);
//            if (letterCount[charAtIndex] > 0){
//                letterCount[charAtIndex]--;
//                count++;
//            }
//            while (count == pattern.length()){
//                //what does this 'while' mean, it means that we have found a substring that contains pattern string
//                return searchString.substring(0, index+1);
//            }
//        }
//        return "";
//    }

    public static String findSubString(String searchString, String pattern) {

        if (searchString == null || pattern == null){
            return "";
        }
        String res = "";
        int[] letterCount = new int[128];
        int left = 0, count = 0, minLen = Integer.MAX_VALUE;
        for (char c : pattern.toCharArray()) {
            // Count the letters in Pattern String and increment the value of that character in letterCount array
            letterCount[c]++;
        }
        for(int right = 0; right < searchString.length(); right++){
            // Check if searchString contains pattern string, just check if it contains
            char charAtRightIndex = searchString.charAt(right);
            letterCount[charAtRightIndex]--;
            if (letterCount[charAtRightIndex] >= 0){
                count++;
            }
            while (count == pattern.length()){
                if (minLen > right - left + 1){
                    minLen = right - left + 1;
                    res = searchString.substring(left, right + 1);
                }
                letterCount[searchString.charAt(left)]++;
                if(letterCount[searchString.charAt(left)] > 0){
                    count--;
                }
                left++;
            }
        }
        return res;
    }
}
