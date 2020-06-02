package TopInterviewQuestions;

//https://www.programcreek.com/2013/02/leetcode-permutations-java/

//Given a collection of numbers, return all possible permutations.
//For example,
//[1,2,3] have the following permutations:
//[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

import java.util.HashSet;
import java.util.Set;

public class Permutations {

    public static void main(String[] args) {

        Set set = new HashSet();
        String str = "112";
        permute(str, set);
        for (Object o : set) {
            System.out.println(o);
        }
    }

    private static void permute(String str, Set set) {

        permutationHelper(str, "", set);
    }

    private static void permutationHelper(String str, String perm, Set set) {

        if (str.length() == 0){
            set.add(perm);
            return;
        }else {
            for(int i = 0; i < str.length(); i++){
                char word = str.charAt(i);
                String remainingWord = str.substring(0, i) + str.substring(i+1);
                permutationHelper(remainingWord, perm + word, set);
            }
        }
    }
}
