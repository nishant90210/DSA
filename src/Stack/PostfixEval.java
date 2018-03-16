package Stack;

import java.util.Stack;

/**
 * Created by NISHANT on 9/7/17.
 */
public class PostfixEval {

    public static void main(String[] args) {
        String str = "231*+9-";
        System.out.println(evaluatePostfix(str));
    }

    private static int evaluatePostfix(String str) {

        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int strLength = str.length();
        for (int i = 0; i < strLength; i++) {
            char ch = str.charAt(i);
            boolean letterOrDigit = Character.isDigit(ch);
            if (letterOrDigit){
                stack.push(ch-'0');
            }
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch (ch){
                    case '+':
                        stack.push(val2+val1);
                        break;
                    case '-':
                        stack.push(val2-val1);
                        break;
                    case '/':
                        stack.push(val2/val1);
                        break;
                    case '*':
                        stack.push(val2*val1);
                        break;
                    case '^':
                    case '$':
                        stack.push(val2-val1);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
