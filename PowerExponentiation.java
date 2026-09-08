public class PowerExponentiation {

    static double myPow(double x, int n) {

        double ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= x;
        }

        return ans;
    }
    public static void main(String[] args) {
        float x = 2.00000f;
        int n = 10;

        System.out.println(myPow(x, n));
        System.out.println(Math.pow(x, n));
    }
}
