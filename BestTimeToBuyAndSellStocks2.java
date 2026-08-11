/**
 * Approach:
 * - Loop through the entire array starting from index 1.
 * - Check if the current day's price is greater than the previous day's price.
 * - If yes, add the difference to maxProfit.
 * - This works because we can make multiple transactions.
 * - We collect every positive price increase.
 *
 * TC => O(N)
 * SC => O(1)
 */

public class BestTimeToBuyAndSellStocks2 {

    static int maxProfit(int[] prices) {

        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        int[] prices = {1, 2, 3, 4, 5};

        System.out.println(maxProfit(prices));
    }
}