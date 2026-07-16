/**
 * Approach
 * - Initialize low and high pointers.
 * - The answer is the index of the minimum element.
 * - Perform Binary Search until low <= high.
 * - If the current search space is already sorted
 *   (arr[low] <= arr[high]), then arr[low] is the minimum
 *   element in that range. Update the answer and break.
 * - Otherwise, determine which half is sorted.
 * - If the left half is sorted (arr[low] <= arr[mid]),
 *   then arr[low] is the smallest element in the left half.
 *   Update the answer if needed and search in the right half.
 * - Otherwise, the right half is sorted, so the minimum
 *   element lies in the left half including mid.
 *   Update the answer with arr[mid] if needed and search
 *   in the left half.
 * - Finally, return the index of the minimum element,
 *   which is equal to the number of rotations.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

public class FindKRotations {

    public static int findKRotation(int []arr){
        int index = 0;
        int ans = Integer.MAX_VALUE;
        int low = 0;
        int high = arr.length  - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[low] <= arr[high]) {
                if (arr[low] < ans) {
                    ans = arr[low];
                    index = low;
                }
                break;
            }

            if(arr[low] <= arr[mid]) {
                if(arr[low] < ans) {
                    ans = arr[low];
                    index =  low;

                }
                low = mid + 1;
            }else{
                if(arr[mid] < ans) {
                    index =  mid;
                    ans = arr[mid];
                }
                high = mid - 1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};

        System.out.println(findKRotation(arr));
    }
}