package TopInterviewQuestions;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";

        Set<String> set = new HashSet<>();
        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("lot");
        set.add("log");
        set.add("cog");

        int leng = ladderLength(beginWord, endWord, set);

        System.out.println("rst " + leng );
        System.out.println("END");
    }

    public static int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if (beginWord == null || endWord == null){
            return 0;
        }
        Queue<String> q = new LinkedList();
        LinkedList<Integer> levels = new LinkedList<>();
        q.add(beginWord);
        levels.add(1);
        while (q.size() > 0){
            String current = q.poll();
            int level = levels.pollFirst();
            StringBuilder sb = new StringBuilder(current);
            for (int i = 0; i < current.length(); i++){
                for (char ch = 'a'; ch < 'z'; ch++){
                    char newchar = ch;
                    char oldchar = current.charAt(i);
                    if (newchar != oldchar){
                        sb.setCharAt(i, newchar);
                        if (sb.toString().equals(endWord)){
                            return level + 1;
                        }
                        if (wordDict.contains(sb.toString())){
                            String cand = sb.toString();
                            wordDict.remove(sb.toString());
                            q.add(cand);
                            levels.add(level+1);
                        }
                        sb.setCharAt(i, oldchar);
                    }//if !=
                }//for j
            }//for i
        }//while
        return 0;
    }
}
