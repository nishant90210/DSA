package Stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by NISHANT on 9/12/17.
 */
public class LengthLongestValidSubstring {

    static HashMap<Character, Character> brackets = new HashMap<Character, Character>(){
        {
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }
    };

    static Stack<Character> stack = new Stack<Character>();

    public static void main(String[] args) {

//        String str = ")()()";
//        System.out.println(findMaxLen(str));

//        String str = "((()()";
//        System.out.println(findMaxLen(str));

        String str = "()(()))))";
        System.out.println(findMaxLen(str));
    }

    public static int findMaxLen(String str) {

        int maxLen = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (brackets.containsKey(ch)){
                stack.push(ch);
            }
            else if (!stack.isEmpty() && brackets.get(stack.pop()) == ch){
                maxLen +=2;
            }
        }
        return maxLen;
    }

}
