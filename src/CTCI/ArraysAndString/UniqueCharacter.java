package CTCI.ArraysAndString;

//You should first ask your interviewer if the string is an ASCII string or a Unicode string.


//One solution is to create an array of boolean values, where the flag at index i indicates whether character
//i in the alphabet is contained in the string. The second time you see this character you can immediately
//return false.

//We can also immediately return false if the string length exceeds the number of unique characters in the
//alphabet

//It's also okay to assume 256 characters. This would be the case in extended ASCII. You should
//clarify your assumptions with your interviewer.
public class UniqueCharacter {

//    public static void main(String[] args) {
//
//        String str = "Himanu";
//        boolean unique = isUnique(str.toLowerCase());
//        System.out.println(unique);
//    }

    private static boolean isUnique(String str) {

        if (str.length() > 128){
            return false;
        }
        boolean[] charSet = new boolean[128];
        for(int i = 0; i< str.length(); i++){
            int chVal = str.charAt(i);
            if (charSet[chVal]){
                return false;
            }
            charSet[chVal] =  true;
        }
        return true;
    }

//    public static void main(String[] args) {
//        int num1 = 10;
//        int num2 = 22;
//        num1 = num1+num2;
//        num2 = num1-num2;
//        num1 = num1-num2;
//        System.out.print("num1 = " + num1 +", num2 = "+num2);
//    }
}
