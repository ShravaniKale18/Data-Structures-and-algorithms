import java.util.Arrays;

public class FirstAndLastPositionInArray {

    static int[] searchRange(int[] nums, int target) {

        int firstPosition = -1;
        int secondPosition = -1;

        firstPosition = lowerBound(nums, target);
        secondPosition = upperBound(nums, target) - 1;

        return new int[]{firstPosition, secondPosition};
    }

    static int lowerBound(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    static int upperBound(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > target) {
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 4, 5};
        int target = 2;

        System.out.println(Arrays.toString(searchRange(arr, target)));
    }
}
