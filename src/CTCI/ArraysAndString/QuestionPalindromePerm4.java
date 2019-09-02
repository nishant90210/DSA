package CTCI.ArraysAndString;
//Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
//A palindrome is a word or phrase that is the same forwards and backwards. A permutation
//is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.

public class QuestionPalindromePerm4 {

    public static void main (String[] args) {

        String input = "Tact Coa";
        boolean bool = isPermOfPalind(input.toLowerCase());
        if(bool) {
            System.out.println("Valid");
        }else {
            System.out.println("In-Valid");
        }

    }

    public static boolean isPermOfPalind(String input) {

        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        char[] ch = input.toCharArray();

        for(Character character : ch){
            int value = getNumbericValue(character);
            if(value != -1){
                table[value]++;
                if(table[value] % 2 == 1){
                    countOdd++;
//                    System.out.println("in IF " + countOdd);
                }else {
                    countOdd--;
//                    System.out.println("in Else " + countOdd);
                }
            }
        }
        if(countOdd <= 1){
            return true;
        }else{
            return false;
        }
    }

    public static int getNumbericValue(Character ch) {

        int a= Character.getNumericValue('a');
        int z= Character.getNumericValue('z');
        int val= Character.getNumericValue(ch);
        if (val >= a && val <= z){
            return val - a;
        }else {
            return -1;
        }
    }
}
