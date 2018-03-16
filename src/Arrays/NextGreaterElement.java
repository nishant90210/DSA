package Arrays;

import java.util.Stack;

/**
 * Created by NISHANT on 11/10/17.
 */
public class NextGreaterElement {

    public static void main(String[] args) {

        int[] arr = {5,3,2,10,6,8,1,4,12,7,4};
//        nextGreaterElement(arr);
        nextGreaterElementStack(arr);
    }

    private static void nextGreaterElement(int[] arr) {

        for (int i = 0; i <= arr.length-1 ; i++) {
            for (int j = i; j < arr.length-1; j++) {
                if (arr[i] < arr[j+1]){
                    System.out.println("Next Greater Element of " + arr[i] + " is " + arr[j+1]);
                    break;
                }
            }
        }
    }

    private static void nextGreaterElementStack(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                System.out.println("Next greater element for " + stack.pop() + "\t = "  + arr[i]);
            }
            stack.push(arr[i]);
        }
//        while (!stack.isEmpty()) {
//            int top = (int) stack.pop();
//            System.out.println("Next greater element for "  + top + "\t = "  + null);
//        }
    }
}
