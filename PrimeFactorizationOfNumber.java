import java.util.ArrayList;

public class PrimeFactorizationOfNumber {

    /*
     * Time Complexity: O(sqrt(N))
     * Space Complexity: O(log(N))
     */

    static ArrayList<Integer> primeFactors(int n) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 2; i * i <= n; i++) {

            while (n % i == 0) {
                list.add(i);
                n = n / i;
            }
        }

        // If remaining n is greater than 1, it is prime
        if (n > 1) {
            list.add(n);
        }

        return list;
    }

    public static void main(String[] args) {

        int n = 25;

        System.out.println(primeFactors(n));
    }
}