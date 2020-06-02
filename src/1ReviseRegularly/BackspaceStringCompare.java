package Programs;

import java.util.Stack;

//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3291/
public class BackspaceStringCompare {

    public static void main(String[] args) {

//        "xywrrmp"
//        "xywrrmu#p"
        String S = "a#c";
        String T = "b";

        Stack<Character> sStack = new Stack();
        Stack<Character> tStack = new Stack();

        for(int i = 0; i< S.length(); i++) {
            if (S.charAt(i) != '#') {
                sStack.push(S.charAt(i));
            } else if (!sStack.isEmpty()) {
                sStack.pop();
            }
        }
        for(int i = 0; i< T.length(); i++){
            if (T.charAt(i) != '#') {
                tStack.push(T.charAt(i));
            }else if(!tStack.isEmpty()){
                tStack.pop();
            }
        }
        while(!sStack.isEmpty()) {
            char current = sStack.pop();
            if (tStack.isEmpty() || tStack.pop() != current){
                System.out.println("false");
            }
        }
//        return sStack.isEmpty() && tStack.isEmpty();
    }
}
