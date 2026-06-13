package Recursion;

public class SumOfN {
    static int calculateSum(int n) {
        if(n == 0) {
            return 1;
        }

        return n * calculateSum(n - 1);
    }
    public static void main(String[] args) {
        int ans = calculateSum(4);
        System.out.println(ans);
    }
}
