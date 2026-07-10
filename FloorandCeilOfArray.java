/**
 * Approach:
 * - The floor is the largest element less than or equal to x.
 * - The ceil is the smallest element greater than or equal to x.
 *
 * Floor:
 * - Use Binary Search to find the last element <= x.
 * - Whenever arr[mid] <= x, store mid as a possible answer and
 *   continue searching in the right half for a larger valid floor.
 * - Otherwise, search in the left half.
 *
 * Ceil:
 * - Use Binary Search to find the first element >= x.
 * - Whenever arr[mid] >= x, store mid as a possible answer and
 *   continue searching in the left half for a smaller valid ceil.
 * - Otherwise, search in the right half.
 *
 * Time Complexity:
 * - getFloor(): O(log n)
 * - getCeil(): O(log n)
 * - Overall: O(log n)
 *
 * Space Complexity:
 * - O(1)
 */

public class FloorandCeilOfArray {
    static int getFloor(int[] arr, int x) {
        int n = arr.length;

        int low = 0;
        int high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= x) {
                ans = mid;
                low = mid + 1;    
            }else{
                high = mid - 1;
            }
        }

        return ans;
    }


    static int getCeil(int[] arr, int x) {
        int n = arr.length;

        int low = 0;
        int high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1; 
            }
        }

        return ans; 
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int x = 25;

        // System.out.println("Floor = "+getFloor(arr, x));
        // System.out.println("Ceil = "+getCeil(arr, x));

        int floorIndex = getFloor(arr, x);
        int ceilIndex = getCeil(arr, x);

        System.out.println("Floor = " + (floorIndex == -1 ? "Does not exist" : arr[floorIndex]));
        System.out.println("Ceil = " + (ceilIndex == -1 ? "Does not exist" : arr[ceilIndex]));
    }
}
