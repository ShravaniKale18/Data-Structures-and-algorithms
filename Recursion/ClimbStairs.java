package Recursion;

public class ClimbStairs {
    /** 
     * Approach:
     *  The problem can be solved using recursion.
     *  The number of ways to climb to the nth stair is equal to the sum of the ways to climb to the (n-1)th stair and the (n-2)th stair. 
     *  This is because from the (n-1)th stair, you can take one step to reach the nth stair, and from the (n-2)th stair, you can take two steps to reach the nth stair.
     * 
     *  Time Complexity: O(2^n) - The recursive solution has an exponential time complexity due to the repeated calculations of the same subproblems.
     *  Space Complexity: O(n) - The space complexity is O(n) due to the recursion stack.
     */
    public static int climbStairs(int n) {

        if(n == 1) {
            return 1;
        }

        if(n == 2) {
            return 2;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Number of ways to climb " + n + " stairs: " + climbStairs(n));
    }
}
