public class FibonacciSeries {

    /** 
     * This method returns the nth Fibonacci number using recursion.
     * 
     * time complexity: O(2^n)
     * space complexity: O(n)
     */

    static int fibonacci1(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }

    /** 
     * This method prints the Fibonacci series up to the nth number.
     * 
     * time complexity: O(n)
     * space complexity: O(1)
     */
    
    static void fibonacci(int n) {
        if(n <= 1) {
            System.out.println(n);
            return;
        }

        int a = 0, b = 1, c;
        System.out.print(a+" "+b+" ");
        for(int i = 2; i <= n; i++) {
            c = a + b;
            System.out.print(c+" ");
            a = b;
            b = c;
        }

        System.out.println();

    }
    public static void main(String[] args) {
        fibonacci(10);
    }
}
