package Adobe.ArraysNStrings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubsstringWithoutRepeatingCharacter {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("aab"));
    }

    /*
    Time complexity : O(n)O(n). Index jj will iterate nn times.
    Space complexity (Set) : O(min(m, n))O(min(m,n)). Same as the previous approach.
    Space complexity (Table): O(m)O(m). mm is the size of the charset.
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet();
        int i = 0, j = 0;
        int max = 0;
        while(j < s.length()) {
            if(set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            } else {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            }
        }
        return max;
    }
}
