package CTCI.ArraysAndString;

public class PalindromePerm {

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

        int count = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        char[] ch = input.toCharArray();
        for(Character character : ch){
            int value = getNumbericValue(character);
            if(value != -1){
                table[value]++;
                if(table[value] % 2 == 1){
                    count++;
                }else {
                    count--;
                }
            }
        }
        if(count < 2){
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
