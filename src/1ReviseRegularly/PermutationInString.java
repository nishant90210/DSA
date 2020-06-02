package Programs;

public class PermutationInString {

    public static void main(String[] args) {

        String s1 = "ab"; String s2 = "eidbaooo";
        boolean b = checkInclusion(s1, s2);
        System.out.println(b);
    }

    public static boolean checkInclusion(String s1, String s2) {
        // Sliding window + hashtable: O(mn)
        // Edge cases
        if(s1 == null || s2 == null) {
            return false;
        }
        if(s1.length() > s2.length()) {
            return false;
        }
        if(s1.length() == s2.length()) {
            return isPermutation(s1, s2);
        }
        //1. Set window width = s1.length
        int width = s1.length();
        //2. Slide
        for(int i = 0; i <= s2.length() - width; i++) {
            String sub = s2.substring(i, i + width);
            //3. Check whether the window is a permutation of s1
            if(isPermutation(s1, sub)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPermutation(String a, String b) {
        int[] hashtable_a = new int[256];
        int[] hashtable_b = new int[256];
        for(int i = 0; i < a.length(); i++) {
            hashtable_a[a.charAt(i)] ++;
            hashtable_b[b.charAt(i)] ++;
        }
        boolean notSame = false;
        for(int i = 0; i < 256; i++) {
            if(hashtable_a[i] == hashtable_b[i]) {
                continue;
            } else {
                notSame = true;
                break;
            }
        }
        return !notSame;
    }
}
