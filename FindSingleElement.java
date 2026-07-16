/**
 * Approach
 * - Handle the edge cases:
 *   - If the array contains only one element, return it.
 *   - If the first element is different from the second, return the first element.
 *   - If the last element is different from the second last, return the last element.
 * - Initialize low = 1 and high = n - 2 since the edge cases are already handled.
 * - Perform Binary Search:
 *   - Find the middle index.
 *   - If arr[mid] is different from both its adjacent elements, it is the single element.
 *   - Otherwise, determine which half to search using the index parity:
 *     - If mid is odd and arr[mid] == arr[mid - 1], or
 *       mid is even and arr[mid] == arr[mid + 1],
 *       then the single element lies in the right half.
 *     - Otherwise, it lies in the left half.
 * - Continue until the single element is found.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

public class FindSingleElement{

    static int findSingleElement(int[] arr) {

        int n = arr.length;

        if (n == 1) {
            return arr[0];
        }

        if(arr[0] != arr[1]) {
            return arr[0];
        }   

        if (arr[n - 1] != arr[n - 2]) {
            return arr[n - 1];
        }

        int low = 1;
        int high = n - 2;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            }

            if((mid % 2 == 1 && arr[mid] == arr[mid - 1]) || (mid % 2 == 0 && arr[mid] == arr[mid + 1])) {
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 5, 5};

        System.out.println(findSingleElement(arr));;
    }
}