package String;

/**
 * Created by Nishant on Apr, 2019
 */
// https://www.geeksforgeeks.org/minimum-characters-added-front-make-string-palindrome/
public class AddFrontPalindrome {

    public static void main(String[] args) {

        String str = "ABC";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i+1)){
                str = str.charAt(i)+str;
                System.out.println(str);
            }
        }
    }
}
