public class ValidPerfectSquare {

    /** 
     * Approach:
     * 1. Iterate from 1 to the square root of the given number.
     * 2. For each number, check if its square is equal to the given number.
     * 3. If a match is found, return true.
     * 
     * Time Complexity: O(sqrt(n)) - We iterate from 1 to the square root of the given number.
     * Space Complexity: O(1) - We use a constant amount of space.
     */
    
    static boolean isPerfectSquare(int num) {

        for(int i = 1; (long)i * i <= num; i++) {
            if((long)i * i == num) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
            
        int num = 14;
        boolean result = isPerfectSquare(num);
        System.out.println(result);
    }
}
