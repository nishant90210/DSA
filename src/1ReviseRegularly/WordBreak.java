package TopInterviewQuestions;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    public static void main(String[] args)
    {
        // List of Strings to represent dictionary
        List<String> dict = Arrays.asList("mobile","samsung","sam","sung","man","mango",
                "icecream","and","go","i","love","ice","cream");

        // input String
        String str = "ilovesamsungmobile";

        wordBreak(dict, str, "");
    }

    private static void wordBreak(List<String> dict, String str, String output) {

        if (str.length() == 0){
            System.out.println(output);
            return;
        }
        for (int i = 1; i <= str.length(); i++){

            String prefix = str.substring(0, i);
            if (dict.contains(prefix)){
                wordBreak(dict, str.substring(i), output + " " + prefix);
            }
        }
    }
}
