package Array;

public class Power {
    static double myPow(double x, int n) {
        double ans = 1;
        if(n < 0) {
            x = 1 / x;
            n = -n;
        }
        for (int i = 0; i < n; i++) {
            ans *= x;
        }
        return ans;
    }
    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2;
        double ans = myPow(x, n);
        System.out.println(ans);
    }
}
