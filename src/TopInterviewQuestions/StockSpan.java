package TopInterviewQuestions;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {

    public static void main(String args[]){
        int prices[] = {100, 60, 70, 65, 80, 85};
        int[] span = stockSpan(prices);
        Arrays.stream(span).forEach(System.out::println);
    }

    private static int[] stockSpan(int[] prices) {

        int[] span = new int[prices.length];
        Stack<Integer> stack = new Stack();
        span[0] = 1;
        stack.push(0);

        for(int i = 1; i < prices.length; i++){
            while(prices[i] > prices[stack.peek()] && !stack.isEmpty()) {
                stack.pop();
            }
            if (stack.isEmpty()){
                span[i] = 1;
            }else {
                span[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return span;
    }
}
