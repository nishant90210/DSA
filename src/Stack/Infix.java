package Stack;

import java.util.Stack;

/**
 * Created by NISHANT on 9/7/17.
 */
public class Infix {

    public static void main(String[] args) {
        String s = "a+b*(c^d-e)^(f+g*h)-i";
//        String s = "A*(B+C/(D-E))";
        System.out.println("Infix to PostFix " + infixToPostfix(s));
    }

    // A utility function to return precedence of a given operator
    // Higher returned value means higher precedence
    public static int priority(char ch){

        switch (ch){
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
            case '^':
            case '$':
                return 3;
        }
        return 0;
    }

    private static String infixToPostfix(String str) {

        // initializing empty String for result
        String result = new String("");

        // initializing empty stack
        java.util.Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);

            // If the scanned character is an operand, add it to output.
            boolean letterOrDigit = Character.isLetterOrDigit(ch);
            if (letterOrDigit){
                result += ch;
            }

            // If the scanned character is an '(', push it to the stack.
            else if (ch == '('){
                stack.push(ch);
            }

            //  If the scanned character is an ')', pop and output from the stack
            // until an '(' is encountered.
            else if (ch == ')'){
                while (!stack.isEmpty() && stack.peek() != '('){
                    result += stack.pop();
                }
                stack.pop();
            }
            else {
                if (stack.isEmpty() || (priority(ch) > priority(stack.peek()))) {
                    stack.push(ch);
                }
                else {
                    while (!stack.isEmpty() && priority(ch) <= priority(stack.peek())){
                        result += stack.pop();
                    }
                    stack.push(ch);
                }
            }
        }
        while (!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}
