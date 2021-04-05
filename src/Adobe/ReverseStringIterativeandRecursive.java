package Adobe;

import java.util.Stack;

public class ReverseStringIterativeandRecursive {

    public static void main(String[] args) {

        String str = "geeksforgeeks";
        reverseNotReallyRecursiveUsingStack(str);
        System.out.println();
        reverseIterative(str);
        reverseRecursive(str);
    }

    private static void reverseRecursive(String input) {

        recur(input, 0);
    }

    private static void recur(String input, int loopCounter) {

        if (loopCounter == input.length()) {
            return;
        }
        recur(input, loopCounter+1);
        System.out.print(input.charAt(loopCounter));
    }

    private static void reverseIterative(String str) {

        char[] result = str.toCharArray();
        int start = 0;
        int end = str.length() - 1;
        swap(start, end, result);
        System.out.println(result);
    }

    private static void swap(int start, int end, char[] result) {

        while (start < end) {
            char tempChar = result[start];
            result[start] = result[end];
            result[end] = tempChar;
            start++;
            end--;
        }
    }

    //Time complexity : O(n)
    //Auxiliary Space : O(n)
    private static void reverseNotReallyRecursiveUsingStack(String str) {

        Stack<Character> stack = new Stack<>();
        helper(stack, str, 0);
    }

    private static void helper(Stack<Character> stack, String input, int i) {

        stack.add(input.charAt(i));
        if (stack.size() == input.length()) {
            System.out.print(stack.pop());
            return;
        }
        helper(stack, input, i+1);
        System.out.print(stack.pop());
    }
}
