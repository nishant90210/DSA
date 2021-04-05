package String;

/**
 * Created by Nishant on Dec, 2018
 */
public class IntegerPalindrome {

    public static void main(String[] args) {

        int i = 122;
        int x = 0,m = 0,n;

        n = i;

        while (i > 0){
            x = i % 10;
            m = m * 10 + x;
//            m = 10 * m + i % 10;
            i = i / 10;
        }
        if (m == n){
            System.out.println("Given number "+n+" is Palindrome");
        }else {
            System.out.println("Given number "+n+" is Not a Palindrome");
        }
    }
}
