package TopInterviewQuestions;

import java.util.Stack;

/*
    Loop over the input array and maintain a stack of increasing bar lengths. This can be called an Increasing Stack
    If current element is greater than stack-top, push it to stack top.
    If current element is smaller than stack-top, then start removing elements from stack till it has elements greater than the current.
    For each popped element, find largest histogram area using:
    Right boundary as current element or current element - 1 (as explained above)
    Left boundary as next stack-top element or 0 (Because our stack stores only increasing length of bars,
    it implies that all bars absent between two consecutive bars in the stack must be longer than both of them)
    If all elements of the stack have been popped, this means that all bars before the current bar were longer and
    so their rectangles ended here. To begin afresh for the others, current bar is put into the stack.
    If any elements are left in stack after the above loop, then pop them one by one and repeat #3
*/
public class AreaOfHistogram {

    public static void main(String[] args) {

        int[] hist = {2,1,5,10,5,2};
        System.out.println(hist.length);
//        int[] hist = {6, 2, 5, 4, 5, 1, 6};
//        int[] hist = {3,4,5,1,2};
        int area = calculateAreaOfHistogram(hist, hist.length);
        System.out.println("Area of Histogram :- " + area);
    }

    public static int calculateAreaOfHistogram(int[] hist, int length) {

        int i = 0;
        int maxArea = 0;//maxArea = what is the height * (where are we now - where did that rectangle start)
        Stack<Integer> stack = new Stack();
        while (i < length) {
            if (stack.isEmpty() || hist[i] > hist[stack.peek()]) {
                stack.push(i);
                i++;
            }else {
                maxArea = calculateArea(hist, stack, i, maxArea);
            }
        }
        while (!stack.isEmpty()){
            maxArea = calculateArea(hist, stack, i, maxArea);
        }
        return maxArea;
    }

    private static int calculateArea(int[] hist, Stack<Integer> stack, int i, int maxArea) {

        int height = hist[stack.pop()];
        int width;
        if (stack.isEmpty()){
            width = i;
        }else {
            width = (i - stack.peek() - 1);
        }
        maxArea = Math.max(height * width, maxArea);
        System.out.println("i :- " + i);
        System.out.println("height :- " + height);
        System.out.println("weight :- " + width);
        System.out.println(maxArea);
        return maxArea;
    }
}
