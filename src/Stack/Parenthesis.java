package Stack;

import java.util.HashMap;
import java.util.Stack;

public class Parenthesis {

    public static void main(String[] args) {

        if(ifBalanced("()[]{}")){
            System.out.println("Balanced");
        }else{
            System.out.println("UnBalanced");
        }
    }

    private static boolean ifBalanced(String str) {

        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            if (map.keySet().contains(curr)) {
                stack.push(curr);
            } else if (map.values().contains(curr)) {
                if (!stack.empty() && map.get(stack.peek()) == curr) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
