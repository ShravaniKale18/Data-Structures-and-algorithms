package Recursion;

import java.util.Scanner;

public class First {

    static void printName(String s, int n) {
        if (n == 0) {
            return;
        }
        System.out.println(s);
        printName(s, n - 1);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printName("Shravani",n);

        sc.close();
    }
}
