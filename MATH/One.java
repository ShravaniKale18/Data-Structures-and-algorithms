package MATH;

public class One {
    static boolean palindromeCheck(int n) {
        int rem, reversed = 0;
        int originalNum = n;

        while(n != 0) {
            rem = n % 10;
            reversed = reversed * 10 + rem;
            n /= 10;
        }

        if(reversed == originalNum) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int num = 1549865;

        boolean ans = palindromeCheck(num);
        System.out.println(ans);
    }
}
