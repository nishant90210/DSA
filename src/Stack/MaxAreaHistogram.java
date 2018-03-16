package Stack;

import java.util.Stack;

/**
 * Created by NISHANT on 9/13/17.
 */

/*Loop over the input array and maintain a stack of increasing bar lengths. This can be called an Increasing Stack
If current element is greater than stack-top, push it to stack top.
If current element is smaller than stack-top, then start removing elements from stack till it has elements greater than the current.
For each popped element, find largest histogram area using:
Right boundary as current element or current element - 1 (as explained above)
Left boundary as next stack-top element or 0 (Because our stack stores only increasing length of bars, it implies that all bars absent between two consecutive bars in the stack must be longer than both of them)
If all elements of the stack have been popped, this means that all bars before the current bar were longer and so their rectangles ended here. To begin afresh for the others, current bar is put into the stack.
If any elements are left in stack after the above loop, then pop them one by one and repeat #3
*/

public class MaxAreaHistogram {

    public static void main(String[] args)
    {
        int hist[] = {3,4,5,1,2};
        System.out.println("Maximum area is " + getMaxArea(hist, hist.length));
    }

    private static int getMaxArea(int[] hist, int length) {

        int maxArea = 0;
        int area = 0;
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < length){
            if(stack.isEmpty() || hist[i] >= hist[stack.peek()]){
                stack.push(i);
                i++;
            }else {
                maxArea = calculateArea(hist, maxArea, i, stack);
            }
        }
        while (!stack.isEmpty()){
            maxArea = calculateArea(hist, maxArea, i, stack);
        }
        return maxArea;
    }

    private static int calculateArea(int[] hist, int maxArea, int i, Stack<Integer> stack) {
        int pop = stack.pop();
        int height = hist[pop];
        int width;

        if (stack.isEmpty()){
            width = i;
        }else {
            width = i - stack.peek() -1;
        }
        maxArea = Math.max(height * width, maxArea);
        return maxArea;
    }
}
