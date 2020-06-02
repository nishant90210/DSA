package TopInterviewQuestions;

public class BuySellStockNTime {

    public static void main(String[] args) {

        int prices[] = {7,1,5,3,6,4};
        int n = prices.length;

        int i = maxProfit(prices, n);
        System.out.println(i);
    }

    public static int maxProfit(int[] prices, int n) {
        int profit = 0;
        for(int i=1; i<n; i++){
            int diff = prices[i]-prices[i-1];
            if(diff > 0){
                profit += diff;
            }
        }
        return profit;
    }
}