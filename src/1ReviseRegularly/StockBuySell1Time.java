package Programs;

public class StockBuySell1Time {

    public static void main(String[] args) {
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        int n = prices.length;
        System.out.println(n);
        calculateProfit1(prices, n);
        calculateProfit2(prices, n);
        calculateProfitN(prices, n);
    }

    public static void calculateProfitN(int[] prices, int n) {

        int profit = 0;
        for(int i = 0; i < n-1; i++){
            int diff = prices[i+1] - prices[i];
            if (diff > 0){
                profit += diff;
            }
        }
        System.out.println("Transact N time " + profit);
    }

    public static void calculateProfit2(int[] prices, int n) {

        if (prices == null || prices.length < 2) {
            System.out.println(0);
        }
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }
        System.out.println("Transact 2 time " + profit);
    }

    public static void calculateProfit1(int[] prices, int n) {

        if (prices.length == 0) {
            System.out.println("0");
        }
        // Only 1 thing matters: lowest price seen so far, 'globalMin'
        int globalMax = 0;
        int globalMin = prices[0];

        for (int i = 1; i < prices.length; i++) {
            globalMin = Math.min(globalMin, prices[i]);
            globalMax = Math.max(globalMax, prices[i] - globalMin);
        }
        System.out.println("Transact 1 time " + globalMax);
    }
}
