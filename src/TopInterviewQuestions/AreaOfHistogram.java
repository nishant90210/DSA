package TopInterviewQuestions;

import java.util.Stack;

public class AreaOfHistogram {

    public static void main(String[] args) {

        int[] hist = {2,3,1,4,5,4,2};
        System.out.println(hist.length);
//        int[] hist = {6, 2, 5, 4, 5, 1, 6};
//        int[] hist = {3,4,5,1,2};
        int area = calculateAreaOfHistogram(hist, hist.length);
        System.out.println("Area of Histogram :- " + area);
    }

    public static int calculateAreaOfHistogram(int[] hist, int length) {

        int i = 0;
        int maxArea = 0;
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
