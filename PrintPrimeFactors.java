public class PrintPrimeFactors {

    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }

        if (count == 2) {
            return true;
        }else{
            return false;
        }
    }

    static void printPrimeFactors(int n) {
        for (int i = 2; i <= n; i++) {
            if (n % i == 0 && isPrime(i)) {
                System.out.println(i);
            }
        }
    }
    public static void main(String[] args) {
        int n = 36;

        printPrimeFactors(n);
    }
}
