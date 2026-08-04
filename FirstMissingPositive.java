import java.util.HashSet;

public class FirstMissingPositive {

    /**
     * Approach 1: HashSet
     *
     * Store all positive numbers in a HashSet.
     * Then check numbers from 1 to n + 1.
     * The first number not present in the set is the answer.
     *
     * TC: O(N)
     * SC: O(N)
     */
    static int firstMissingPositive1(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Store all positive numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                set.add(nums[i]);
            }
        }

        // Find the first missing positive number
        for (int i = 1; i <= nums.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Approach 2: Index Placement / Cyclic Sort
     *
     * For every positive number x, its correct index is x - 1.
     *
     * Example:
     * 1 -> index 0
     * 2 -> index 1
     * 3 -> index 2
     *
     * Ignore numbers <= 0 and numbers > n.
     *
     * After placing numbers at their correct indices,
     * nums[i] should be equal to i + 1.
     *
     * The first index where nums[i] != i + 1 gives
     * the first missing positive number.
     *
     * TC: O(N)
     * SC: O(1)
     */
    static int firstMissingPositive(int[] nums) {

        // Place each number at its correct index
        for (int i = 0; i < nums.length; i++) {

            while (nums[i] >= 1
                    && nums[i] <= nums.length
                    && nums[i] != nums[nums[i] - 1]) {

                int correctIndex = nums[i] - 1;

                // Swap
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        // Find the first missing positive
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If all numbers from 1 to n are present
        return nums.length + 1;
    }

    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 3, 5, 4};

        System.out.println(firstMissingPositive(arr));
    }
}