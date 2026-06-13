package Array;

import java.util.Arrays;

public class SuperiorElements {

    static int[] replaceElements(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int maxEle = Integer.MIN_VALUE;

            for (int j = i+1; j < arr.length; j++) {
                maxEle = Math.max(maxEle, arr[j]);
                ans[i] = maxEle;  
            }
        }
        ans[arr.length - 1] = -1;
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};
        int[] ans = replaceElements(arr);
        System.out.println(Arrays.toString(ans));
    }
}
