package String;

import java.util.Scanner;

public class Practise {

    static void countVowels(String s) {
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == 'a' || ch == 'e' || ch == 'o' || ch == 'i' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                count++;
            }
        }
        System.out.println("Number of Vowels = "+count);
    }


    static void reverseString(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            System.out.print(s.charAt(i));
        }
    }

    static boolean palindromeString(String s) {
        String originalString = s;
        String reversedString = "";
        boolean isPalindrome = false;

        for (int i = s.length() - 1; i >= 0; i--) {
            reversedString += s.charAt(i);
        }

        if (reversedString.equals(originalString)) {
            isPalindrome = true;
        }else{
            isPalindrome = false;
        }

        return isPalindrome;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "shravani";
        // char[] ch = s.toCharArray();

        // int count = 0;

        // for (char c : ch) {
        //     count++;
        // }

        // System.out.println("Count of Charcaters = "+count);
        // countVowels(s);
        // reverseString(s);
        boolean ans = palindromeString(s);
        System.out.println(ans);
        sc.close();
    }
}
