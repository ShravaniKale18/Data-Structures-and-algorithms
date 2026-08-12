import java.util.Arrays;

public class SortColors {

    /*
     * Approach 1: Using Built-in Sorting
     *
     * Idea:
     * Use Arrays.sort() to sort the array in ascending order.
     *
     * Time Complexity: O(N log N)
     * Space Complexity: O(1)
     */
    static void sortColors1(int[] arr) {
        Arrays.sort(arr);
    }

    /*
     * Approach 2: Counting
     *
     * Idea:
     * Since the array contains only 0, 1 and 2,
     * count the occurrences of each number.
     * Then overwrite the array with:
     * all 0s, followed by all 1s, followed by all 2s.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    static void sortColors2(int[] arr) {

        // Count the number of 0s, 1s and 2s
        int count0 = 0, count1 = 0, count2 = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count0++;
            } else if (arr[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        // Fill the array with 0s
        for (int i = 0; i < count0; i++) {
            arr[i] = 0;
        }

        // Fill the array with 1s
        for (int i = count0; i < count0 + count1; i++) {
            arr[i] = 1;
        }

        // Fill the remaining positions with 2s
        for (int i = count0 + count1;
             i < count0 + count1 + count2;
             i++) {
            arr[i] = 2;
        }
    }

     /*
     * Dutch National Flag Algorithm
     *
     * Idea:
     * Divide the array into 3 sections:
     * 0s -> left
     * 1s -> middle
     * 2s -> right
     *
     * low  -> position where next 0 should go
     * mid  -> current element
     * high -> position where next 2 should go
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    static void sortColors(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        while (mid <= high) {

            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            }else if (arr[mid] == 1) {
                mid++;
            }else{
                swap(arr, mid, high);
                high--;
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 0, 1, 2};

        sortColors(arr);

        System.out.println(Arrays.toString(arr));
    }
}