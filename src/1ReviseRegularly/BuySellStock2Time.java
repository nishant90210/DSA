package TopInterviewQuestions;

public class BuySellStock2Time {

    public static void main(String[] args) {

        int prices[] = {1,4,5,7,6,3,2,9};
        int n = prices.length;
        calculateProfit(prices, n);
    }

    private static void calculateProfit(int[] prices, int n) {

        if (prices == null || prices.length < 2) {
            return;
        }
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int maxVal = 0;
        left[0] = 0;
        right[prices.length-1] = 0;
        for(int i = 1; i < prices.length; i++){
            maxVal = Math.max(maxVal, prices[i] - prices[0]);
            System.out.println("left maxval "+maxVal);
            left[i] = maxVal;
        }
        maxVal = 0;
        for(int i = prices.length-2; i >= 0; i--){
            maxVal = Math.max(maxVal, prices[prices.length-1] - prices[i]);
            System.out.println("right maxval "+maxVal);
            right[i] = maxVal;
        }
        maxVal = 0;
        for(int i = 0; i < left.length; i++){
            maxVal = Math.max(maxVal, left[i] + right[i]);
            System.out.println("maxval "+maxVal);
        }

    }
}
