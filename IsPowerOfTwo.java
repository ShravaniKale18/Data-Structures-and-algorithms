/** 
 * Approach 1: Iterative Division
 * The function checks if the given integer n is a power of two by repeatedly dividing n by 2 until n becomes 1. If n is less than or equal to 0, it
 * returns false. If n is divisible by 2, it continues dividing until n is no longer divisible by 2. Finally, it checks if n equals 1, indicating that n is a power of two. 
 * 
 * time complexity: O(log n) - The while loop runs until n becomes 1, which takes logarithmic time in relation to n.
 * space complexity: O(1) - The function uses a constant amount of space regardless of
 */

public class IsPowerOfTwo {
    public static boolean isPowerOfTwo1(int n) {
        if (n <= 0) {
            return false;
        }
        
        while(n % 2 == 0) {
            n /= 2;
        }

        return n == 1;
    }

    public static boolean isPowerOfTwo(int n) {
        for (int i = 0; i <= n; i++) {
            if (Math.pow(2, i) == n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int n = 16; // Example input
        System.out.println(n + " is a power of two: " + isPowerOfTwo(n));
    }
}
