import java.util.ArrayList;
import java.util.Arrays;

public class ClosestPrimeNumberInRange {

    static int[] closestPrimes1(int left, int right) {

        ArrayList<Integer> primePairList = new ArrayList<>();

        for(int i = left; i <= right; i++) {

            if(isPrime(i)) {
                primePairList.add(i);
            }
        }

        if (primePairList.size() < 2) {
            return new int[]{-1, -1};
        }

        int first = -1;
        int second = -1;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < primePairList.size() - 1; i++) {
            int diff = primePairList.get(i + 1) - primePairList.get(i);

            if (diff < minDiff) {
                minDiff = diff;

                first = primePairList.get(i);
                second = primePairList.get(i + 1);
            }
        }

        return new int[]{first, second};
    }

    static boolean isPrime(int n) {
        if(n <= 1) {
            return false;
        }

        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static int[] closestPrimes(int left, int right) {
        
        boolean[] isPrime = new boolean[right + 1];

        Arrays.fill(isPrime, true);

        if (right >= 0) {
            isPrime[0] = false;
        }

        if (right >= 1) {
            isPrime[1] = false;
        }

        for (int i = 2; i * i <= right; i++) {

            if (isPrime[i]) {

                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int previousPrime = -1;
        int first = -1;
        int second = -1;

        int minDiff = Integer.MAX_VALUE;

        for (int i = left; i <= right; i++) {

            if (isPrime[i]) {

                if (previousPrime != -1) {

                    int diff = i - previousPrime;

                    if (diff < minDiff) {
                        minDiff = diff;
                        first = previousPrime;
                        second = i;
                    }
                }
                previousPrime = i;
            }
        }

        return new int[]{first, second};
    }

    public static void main(String[] args) {
        int left = 2, right = 3;

        System.out.println(Arrays.toString(closestPrimes(left, right)));
    }
}
