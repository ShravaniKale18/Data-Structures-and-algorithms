public class PrintDivisors {

    static void print(int n) {
        int num = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i+ " ");
            }
        }
    }
    
    public static void main(String[] args) {
        int n = 100;

        print(n);
    }
}
