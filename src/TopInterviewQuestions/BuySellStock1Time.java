package TopInterviewQuestions;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BuySellStock1Time {

    public static void main(String args[])
    {
        // stock prices on consecutive days
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        int n = prices.length;
        System.out.println("length" + n);
        calculateProfit(prices, n);
    }

    private static void calculateProfit(int[] prices, int n) {

        int buy = 0, sell = 0, profit = 0;
        for(int i = 1; i < n ; i++){
            if (prices[i] < prices[buy]){
                buy = i;
            }else {
                sell = i;
            }
            if (buy < sell){
                profit = Math.max(profit ,prices[sell] - prices[buy]);
            }
        }
        System.out.println(profit);
    }
}

