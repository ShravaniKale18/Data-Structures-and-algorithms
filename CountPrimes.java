import java.util.Arrays;

public class CountPrimes {
    static int countPrimes1(int n) {
        int count = 0;

        for(int i = 2; i < n; i++) {
            if(isPrime(i)) {
                count++;
            }
        }

        return count;
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

    static int countPrimes(int n) {

        if(n <= 2){
            return 0;
        }
        
        int[] arr = new int[n];
        Arrays.fill(arr, 1);

        arr[0] = 0;
        arr[1] = 0;

        for (int i = 2; i * i < n; i++) {
            if (arr[i] == 1) {
                for (int j = i * i; j < n; j = j + i) {
                    arr[j] = 0;
                }
            }
        }

        int count = 0;

        for(int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 10;

        System.out.println(countPrimes(n));
    }
}
