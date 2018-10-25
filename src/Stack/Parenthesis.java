package Stack;

import java.util.HashMap;
import java.util.Stack;

public class Parenthesis {

    public static final HashMap<Character, Character> brackets = new HashMap<Character, Character>(){
        {
            put('[',']');
            put('{','}');
            put('(',')');
        }
    };

    public static final Stack<Character> stack = new Stack<Character>();


    public static void main(String[] args) {

        if(ifBalanced("{(}[]{)}")){
            System.out.println("Balanced");
        }else{
            System.out.println("UnBalanced");
        }
    }



    private static boolean ifBalanced(String str) {

        for (int i = 0; i < str.length(); i++) {
            if(brackets.containsKey(str.charAt(i))){
                stack.push(str.charAt(i));
                continue;
            }
            else if (stack.isEmpty()){
                return false;
            }
            else if (str.charAt(i) == brackets.get(stack.pop())){
                continue;
            }
        }
        if (!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
