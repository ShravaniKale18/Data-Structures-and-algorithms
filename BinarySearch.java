public class BinarySearch {

    /**
     * Approach
     * 1. Initialize low = 0 and high = n - 1.
     * 2. Find the middle element.
     * 3. If middle element equals target, return its index.
     * 4. If target is smaller, search the left half.
     * 5. Otherwise, search the right half.
     * 6. Repeat until low > high.
     *
     * TC - O(log n)
     * SC - O(1)
     */
    static int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 10};
        int target = 10;

        int index = search(arr, target);

        if (index == -1) {
            System.out.println("The element " + target + " is not in array");
        } else {
            System.out.println("The element " + target + " is found in array at index " + index);
        }
    }
}