package String;

/**
 * Created by Nishant on Apr, 2019
 */
// https://www.geeksforgeeks.org/minimum-characters-added-front-make-string-palindrome/
public class AddFrontPalindrome {

    public static void main(String[] args) {

        String str = "BABABAA";
        String originalStr = str;
        String newStr = "";
        int count = 0;
        int flag = 0;
        while (str.length() > 0){
            if (isPlaindrome(str)){
                flag = 1;
                break;
            } else {
                count++;
                newStr += str.substring(str.length() - 1);
                str = str.substring(0, str.length() - 1);
            }
        }
        if (flag == 1) {
            System.out.println("Minimum characters to be added = " + count);
            System.out.println("New Palindrome String = " + newStr + originalStr);
        }
    }

    private static boolean isPlaindrome(String str) {

        for(int i = 0; i < str.length()/2 ; i++){
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
