public class BestTimeToBuyAndSellStocks {
    static int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int maxProfit= 0;
        
        for (int j = 0; j < prices.length; j++) {
            minBuy = Math.min(minBuy, prices[j]);
            maxProfit = Math.max(maxProfit, prices[j] - minBuy);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] stocks = {7,6,4,3,1};

        System.out.println(maxProfit(stocks));
    }
}
