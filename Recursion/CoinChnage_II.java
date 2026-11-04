package Recursion;
/** 
 * Approach:
 * 1. We can use recursion to solve the coin change problem.
 * 2. At each coin, we have two choices: either include the current coin and
 * decrease the amount by the value of the coin, or skip the current coin and move to the next one.
 * 3. We can use a base case to stop the recursion when the amount becomes zero
 *  or when the amount becomes negative or we have considered all the coins.
 * 4. Finally, we can return the sum of the two choices.
 * 
 * Time complexity: O(2^n) where n is the number of coins. This is because for each coin, we have two choices: include it or skip it.
 * Space complexity: O(n) for the recursion stack.
 */
public class CoinChnage_II {
    public static int change(int amount, int[] coins) {

        int index = 0;
        int ans = solve(coins, amount, index);

        return ans;
    }

    public static int solve(int[] coins, int amount, int index) {
        if (amount == 0) {
            return 1;
        }

        if (amount < 0 || index >= coins.length) {
            return 0;
        }

        //include
        int includeAns = solve(coins, amount - coins[index], index);
        //exclude
        int excludeAns = solve(coins, amount, index + 1);

        return includeAns + excludeAns;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        int ans = change(amount, coins);
        System.out.println(ans);
    }
}
