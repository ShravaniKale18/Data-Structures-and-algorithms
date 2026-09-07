public class PrimeNumbercheck {

    static String check(int n) {

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }

        if (count == 2) {
            return "Prime Number";
        }else{
            return "Not Prime Number";
        }
    }
    public static void main(String[] args) {
        int n = 15;

        String ans = check(n);

        System.out.println(ans);
    }
}
