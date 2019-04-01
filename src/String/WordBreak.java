package String;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nishant on Dec, 2018
 */
public class WordBreak {

    private static Set<String> DICTIONARY = new HashSet<>();

    static {
        DICTIONARY.add("mobile");
        DICTIONARY.add("samsung");
        DICTIONARY.add("sam");
        DICTIONARY.add("sung");
        DICTIONARY.add("man");
        DICTIONARY.add("mango");
        DICTIONARY.add("icecream");
        DICTIONARY.add("and");
        DICTIONARY.add("go");
        DICTIONARY.add("i");
        DICTIONARY.add("lov");
        DICTIONARY.add("love");
        DICTIONARY.add("ice");
        DICTIONARY.add("cream");
    }

    private static boolean existInDictionary(String string) {
        return DICTIONARY.contains(string.toLowerCase());
    }

    private static void wordutil(String input) {
        processInputString(input, input.length(), "");
    }

    private static void processInputString(String input, int size, String result) {

        for (int i = 1; i <= size; i++) {
            if (existInDictionary(input.substring(0, i))) {

                if (i == size) {
                    System.out.println(result + " " + input);
                    break;
                } else {
                    processInputString(input.substring(i, size), size - i,
                            result + " " + input.substring(0, i) + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        wordutil("ilovesamsungmobile");
    }
}
