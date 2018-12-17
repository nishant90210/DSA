package String;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nishant on Dec, 2018
 */
public class WordBreakTrueFalse {

    private static Set<String> DICTIONARY = new HashSet<>();

    static {
        DICTIONARY.add("i");
        DICTIONARY.add("like");
        DICTIONARY.add("circles");
        DICTIONARY.add("li");
        DICTIONARY.add("life");
    }

    public static boolean wordBreak(String s, Set<String> dict) {
        return wordBreakHelper(s, dict, 0);
    }

    public static boolean wordBreakHelper(String s, Set<String> dict, int start){
        if(start == s.length())
            return true;

        for(String a: dict){
            int len = a.length();
            int end = start+len;

            //end index should be <= string length
            if(end > s.length())
                continue;

            if(s.substring(start, start+len).equals(a))
                if(wordBreakHelper(s, dict, start+len))
                    return true;
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println(wordBreak("ilikecircleslife", DICTIONARY));
    }
}
