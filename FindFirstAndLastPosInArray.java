import java.util.Arrays;

public class FindFirstAndLastPosInArray {

    /**
     * Approach:
     * 1. Find the lower bound of the target (first index where element >= target).
     * 2. If the lower bound is out of range or the element at that index is not
     *    the target, then the target does not exist in the array.
     * 3. Find the upper bound of the target (first index where element > target).
     * 4. The first occurrence is the lower bound.
     * 5. The last occurrence is (upper bound - 1).
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int lb = lowerBound(nums, target, n);

        if (lb == n || nums[lb] != target) {
            return new int[]{-1, -1};
        }

        return new int[]{lb, upperBound(nums, target, n) - 1};
    }

    static int lowerBound(int[] arr, int x, int n) {
        int low = 0;
        int high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    static int upperBound(int[] arr, int x, int n) {
        int low = 0;
        int high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] ans = searchRange(nums, target);

        System.out.println(Arrays.toString(ans));
    }
}