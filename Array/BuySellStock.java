package Array;

public class BuySellStock {
    static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (minPrice > price) {
                minPrice = price;
            }
            // minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        System.out.println(minPrice);
        // System.out.println(maxProfit);
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int ans = maxProfit(nums);
        System.out.println(ans);
    }
}
