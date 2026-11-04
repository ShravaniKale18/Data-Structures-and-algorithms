package Recursion;
/** 
 * Approach:
    * 1. We can either include the coin or exclude the coin.
    * 2. If we include the coin, we will reduce the amount by 
        the value of the coin and keep the index same.
    * 3. If we exclude the coin, we will keep the amount same and
        increase the index by 1.
    * 4. We will keep doing this until the amount becomes 0 or
        the index becomes greater than or equal to the length of the coins array.
    * 5. If the amount becomes 0, we will return 0 as we don't need to add any more coins.
    * 6. If the amount becomes less than 0 or the index becomes greater than or equal to the length of the coins array, we will return -1 as we can't make the amount with the given coins.
    * 7. We will return the minimum of the two answers (include and exclude) and add 1 to the include answer as we are including the current coin.
    * 8. If both answers are -1, we will return -1 as we can't make the amount with the given coins.
 * time complexity: O(2^n)
 * space complexity: O(n) 
 */
public class CoinChange_I {
    public static int changeCoin(int[]coins, int amount) {

        int index = 0;
        int ans = solve(coins, amount, index);

        return ans;
    }

    public static int solve(int[]coins, int amount, int index) {
        if (amount == 0) {
            return 0; //no need to add coin if amout becomes zero
        }

        if(amount < 0 || index >= coins.length) {
            return -1;
        }

        int includeAns = solve(coins, amount - coins[index], index);
        int excludeAns = solve(coins, amount, index + 1);

        int mini = 0;

        if (includeAns < 0 && excludeAns < 0) {
            return -1;
        }else if(includeAns < 0) {
            mini = excludeAns;
        }else if(excludeAns < 0) {
            mini = includeAns + 1; //add 1 to include current coin as well
        }else{
            mini = Math.min(includeAns + 1, excludeAns);
        }

        return mini;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        int ans = changeCoin(coins, amount);

        System.out.println("Number of ways: "+ans);
    }
}
