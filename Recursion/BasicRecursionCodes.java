package Recursion;


public class BasicRecursionCodes {
    
    //Print hello n times using recursion
    public static void printHello(int n) {

        if(n == 0) {
            return;
        }

        printHello(n - 1);
        System.out.println("Hello");
    }

    //print 1 to n numbers using recursion
    public static void printNumbers1ToN(int n) {
        if(n == 0) {
            return;
        }

        printNumbers1ToN(n-1);
        System.out.println(n);
    }

    //Print numbers for n to 1 using recursion
    public static void printNumbersNTo1(int n) {
        if(n == 0) {
            return;
        }

        System.out.println(n);
        printNumbersNTo1(n-1);
    }

    //factorial of a number using recursion
    public static int factorial(int n) {
        if(n == 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    //Fibonacci series using recursion
    public static int fibonacci(int n) {
        if(n == 0) {
            return 0;
        }

        if(n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    //print fibbonacci series from 0 to n using recursion
    public static void printFibonacciSeries(int n) {
        if(n == 0) {
            System.out.print(0);
            return;
        }
        if(n == 1) {
            System.out.print(0 + " " + 1);
            return;
        }

        printFibonacciSeries(n - 1);
        System.out.print(" " + fibonacci(n));
    }

    //power calculation using recursion
    public static int power(int x, int n) {
        if(n == 0) {
            return 1;
        }

        return x * power(x, n - 1);
    }

    public static void main(String[] args) {
        int n = 10;
        printHello(n);
        System.out.println();
        printNumbers1ToN(n);
        System.out.println();
        printNumbersNTo1(n);
        System.out.println();
        System.out.println("Factorial of " + n + " is: " + factorial(n));
        System.out.println("Fibonacci of " + n + " is: " + fibonacci(n));
        System.out.print("Fibonacci series up to " + n + ": ");
        printFibonacciSeries(n);
        System.out.println();
        int x = 2;
        System.out.println(x + " raised to the power " + n + " is: " + power(x, n));
    }
}
