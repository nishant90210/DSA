package String;

/**
 * Created by Nishant on Dec, 2018
 */
public class PalindromicSubString {

    public static void main(String[] args) {
        String str = "ananananddd";

        System.out.println(countPalindrome(str));

    }

    public static int countPalindrome(String str) {
        int n = str.length();
        int sum = 0;

        // calculate frequency
        int hashTable[] = new int[26];
        for (int i = 0; i < n; i++) {
            hashTable[str.charAt(i) - 'a']++;
        }

        // calculate count of palindromic sub-string
        for (int i = 0; i < 26; i++) {
            if (hashTable[i] != 0) {
                sum += (hashTable[i] * (hashTable[i] + 1) / 2);
            }
        }

        // return result
        return sum;
    }
}
