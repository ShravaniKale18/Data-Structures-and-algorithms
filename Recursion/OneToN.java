package Recursion;

import java.util.Scanner;

public class OneToN {

    static void print1ToN(int n, int m) {
        if (n > m) {
                return;
        }

        print1ToN(n + 1, m);
        System.out.print(n+" ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        print1ToN(1, n);
        sc.close();
    }
}
