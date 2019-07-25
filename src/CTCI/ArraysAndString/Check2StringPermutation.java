package CTCI.ArraysAndString;

import java.util.Arrays;

public class Check2StringPermutation {

    //  First Method is to sort both strings and check for equal

//    public static void main(String[] args) {
//
//        String s1 = "";
//        String s2 = "";
//        boolean isPalin = isPalindrome(s1, s2);
//        if(isPalin) {
//            System.out.println("Palindrome");
//        }else {
//            System.out.println("Not Palindrome");
//        }
//    }
//
//    private static boolean isPalindrome(String s1, String s2) {
//        String s1Sorted = sort(s1);
//        String s2Sorted = sort(s2);
//        if (s1.length() != s2.length()){
//            return false;
//        }
//        return s1Sorted.equals(s2Sorted);
//    }
//
//    private static String sort(String s1){
//        char[] strCharArray = s1.toCharArray();
//        Arrays.sort(strCharArray);
//        return new String(strCharArray);
//    }


    //  Check if 2 Strings have identical character counts
    public static void main(String[] args) {

        String s1 = "abca";
        String s2 = "abad";
        boolean isPalin = isPalindrome(s1, s2);
        if(isPalin) {
            System.out.println("Palindrome");
        }else{
            System.out.println("Nope");
        }
    }

    private static boolean isPalindrome(String s1, String s2){

        if (s1.length() != s2.length()){
            return false;
        }
        int letterCount[] = new int[128];
        for(int i = 0; i < s1.length(); i++){
            int s1CharVal = s1.charAt(i);
            letterCount[s1CharVal]++;
        }
        for(int j = 0; j < s2.length(); j++){
            int s2CharVal = s2.charAt(j);
            letterCount[s2CharVal]--;
            if(letterCount[s2CharVal] < 0){
                return false;
            }
        }
        return true;
    }


}
