package TopInterviewQuestions;

import java.util.*;

public class ConcatenationWord {

    public static void main(String args[]) {
        String[] dictionary = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        List<String> allConcatenatedWordsInADict = findAllConcatenatedWordsInADict(dictionary);
        for (String s : allConcatenatedWordsInADict) {
            System.out.println(s);
        }

    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {

        List<String> result = new ArrayList();
        Set<String> wordSet = new HashSet();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (String word : words) {
            if (canBeConcatenated(word, wordSet)) {
                result.add(word);
            }
            wordSet.add(word);
        }
        return result;
    }

    public static boolean canBeConcatenated(String word, Set<String> wordSet) {

        if (wordSet.isEmpty()) {
            return false;
        }
        boolean[] fullWordCheck = new boolean[word.length() + 1];
        fullWordCheck[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                String subString = word.substring(j, i);
                if (fullWordCheck[j] && wordSet.contains(subString)) {
                    fullWordCheck[i] = true;
                    break;
                }
            }
        }
        return fullWordCheck[word.length()];
    }
}
