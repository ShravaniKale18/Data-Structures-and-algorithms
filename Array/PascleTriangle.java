package Array;

public class PascleTriangle {

    static void generate(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                int NcR = calculateNcR(i, j);
                System.out.print(NcR+" ");
            }
            System.out.println();
        }
    }


    static int calculateNcR(int n, int k) {
        int res = 1;
        k = Math.min(k, n - k);

        for(int i = 0; i < k; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }
    public static void main(String[] args) {
        int n = 4;
        generate(n);
        // calculateNcR(n, 3);
    }
}
