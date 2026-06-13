package Array2;

import java.util.Arrays;

public class ThreeSumTriplate {

    public static int threeSumSmaller(int n, int[] arr, int target) {
        int ans = 0;
        Arrays.sort(arr);

		for(int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while(left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                 
                if(sum >= target) {
                    right--;
                }else{
                    ans += (right - left);
                    left++;
                }
            }
        }
        return ans;
	}
    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 3, 4, 6, 7};
        int target = 9;

        threeSumSmaller(0, nums, target);
    }
}
