public class PrintDivisors {

    static void print1(int n) {

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i+ " ");
            }
        }
    }

    static void print(int n) {

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                System.out.print(i+ " ");
                if (n / i != i) {
                    System.out.print(" " +n / i+ " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 100;

        print(n);
    }
}
