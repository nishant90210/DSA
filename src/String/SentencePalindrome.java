package Programs;

/**
 * Created by NISHANT on 4/11/18.
 */
public class SentencePalindrome {

    public static void main(String[] args) {

        String a = "A man, a plan, a canal: Panama";
        /*This will leave only letters and digits and remove whitespace and punctuation,
        i.e. m will become "amanaplanacanalpanama" and you can run you regular palindrome test on that string.*/
//        a = a.toLowerCase().replaceAll("\\W", "");
        boolean palindrome = isPalindrome(a);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(String str) {

        str = str.toLowerCase();
        int start = 0;
        int end = str.length()-1;
        while (start <= end){
            char getStartChar = str.charAt(start);
            char getEndChar = str.charAt(end);
            if (!((getStartChar >= '0' && getStartChar <= '9') || (getStartChar >= 'a' && getStartChar <= 'z'))){
                start++;
            }
            else if (!((getEndChar >= '0' && getEndChar <= '9') || (getEndChar >= 'a' && getEndChar <= 'z'))){
                end--;
            }
            else if (getStartChar == getEndChar){
                start++;
                end--;
            }else {
                return false;
            }
        }
        return true;
    }
}
