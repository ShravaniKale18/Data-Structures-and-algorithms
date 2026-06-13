package Recursion;

import java.util.Arrays;

public class reverseArray {

    static void demo(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]+" ");
        }
    }

    static void reverseArrayFun(int[] arr, int start, int end) {
        if(start >= end) return;

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        reverseArrayFun(arr, start+1, end-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};

        // demo(arr);

        // reverseArrayFun(arr, 0, arr.length - 1);

        String s = "shravani";

        char[] ch = s.toCharArray();

        for (char c : ch) {
            System.out.print(c+" ");
        }

        int start = 0;
        int end = ch.length - 1;

        while (start <= end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;

            start++;
            end--;

        }

        System.out.print(ch);
    }
}
