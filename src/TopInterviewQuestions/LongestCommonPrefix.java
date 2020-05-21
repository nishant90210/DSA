package TopInterviewQuestions;

/**
 * Created by NISHANT on 4/11/18.
 */
// https://www.geeksforgeeks.org/longest-common-prefix-set-4-binary-search/
public class LongestCommonPrefix {

    public static void main(String[] args) {

        String arr[] = {"geeks", "geeksforgeeks", "geek", "geeker"};
        String s = longestCommonPrefix(arr);
        System.out.println(s);
    }

    // Pure functions(which only does some manipulation) should generally be declared "static"
    private static String longestCommonPrefix(String[] strings) {

        if (strings.length == 0){
            return "";
        }

        for (int prefixLen = 0; prefixLen < strings[0].length(); prefixLen++) {
            char c = strings[0].charAt(prefixLen);
            for (int i = 1; i < strings.length; i++) {
                if ( prefixLen >= strings[i].length() || strings[i].charAt(prefixLen) != c ) {
                    return strings[i].substring(0, prefixLen);
                }
            }
        }
        return strings[0];
    }
}
