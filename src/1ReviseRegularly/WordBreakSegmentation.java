package TopInterviewQuestions;

import java.util.Arrays;
import java.util.List;

public class WordBreakSegmentation {

    public static void main(String[] args)
    {
        // List of Strings to represent dictionary
        List<String> dict = Arrays.asList("a" , "have", "Jain", "Sumit", "am", "this", "dog");

        // input String
        String str = "thisamadog";

        boolean b = wordBreak(str, dict);
        System.out.println(b);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {

        if(s.length() == 0){
            return true;
        }

        for(int i = 1; i <= s.length(); i++){
            String prefix = s.substring(0, i);
            if(wordDict.contains(prefix) && wordBreak(s.substring(i), wordDict)){
                return true;
            }
        }
        return false;
    }
}
