package CTCI.ArraysAndString;
//One Away: There are three types of edits that can be performed on strings: insert a character,
//remove a character, or replace a character. Given two strings, write a function to check if they are
//one edit (or zero edits) away.

public class QuestionOneAwayString5 {

    public static void main(String[] args) {

        //Convert s1 to s2
        String s1 = "pale";
        String s2 = "pasle";

        boolean b = oneEditAway(s1, s2);
        System.out.println(b);

    }

    private static boolean oneEditAway(String s1, String s2) {

        if (s1.length() == s2.length()){
            return oneEditReplace(s1, s2);
        }
        if (s1.length() + 1 == s2.length()){
            //insert
            return oneEditInsert(s1, s2);
        }
        if (s1.length() - 1 == s2.length()){
            //remove
            return oneEditInsert(s2, s1);
        }
        return false;
    }

    //s1 = pale , s2 = pape
    private static boolean oneEditReplace(String s1, String s2) {

        boolean foundDifference = false;
        for(int i = 0 ; i < s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)){
                if (foundDifference){
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    /* Check if you can insert a character into sl to make s2. */
    private static boolean oneEditInsert(String first, String second) {
//s1 = pale , s2 = pasle
        int index1 = 0;
        int index2 = 0;
        while (index2 < second.length() && index1 < first.length()) {
            if (first.charAt(index1) != second.charAt(index2)){
                if (index1 != index2){
                    return false;
                }
                index2++;
            }else {
                index1++;
                index2++;
            }
        }
        return true;
    }
}

/* Own Code */
//    public static void main(String[] args) {
//
//        String originalString = "pale";
//        String checkString = "ple";
//
//        char[] checkStringChar = checkString.toCharArray();
//        int originalSum = 0;
//        int checkSum = 0;
//        char[] originalStringChar = originalString.toCharArray();
//        for(int i = 0 ; i < originalStringChar.length ; i++){
//            originalSum += originalStringChar[i];
//        }
//        System.out.println(originalSum);
//
//        for(int i = 0 ; i < checkStringChar.length ; i++){
//            checkSum += checkStringChar[i];
//        }
//        System.out.println(checkSum);
//
//
//        char finalChar = (char) (originalSum - checkSum);
//        System.out.println(finalChar);
//    }