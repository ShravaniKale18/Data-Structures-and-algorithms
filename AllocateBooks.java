import java.util.ArrayList;
import java.util.Arrays;

/**
 * Approach:
 * 1. If the number of students is greater than the number of books,
 *    allocation is not possible, so return -1.
 * 2. Initialize 'low' as the maximum number of pages in a single book
 *    because a student must read at least one complete book.
 * 3. Initialize 'high' as the sum of all pages, which represents the
 *    maximum possible pages assigned to one student.
 * 4. Apply Binary Search on the range [low, high].
 * 5. For each 'mid' (maximum pages allowed per student),
 *    check if all books can be allocated to 'm' students.
 * 6. If allocation is possible, store the answer and search for a
 *    smaller maximum (high = mid - 1).
 * 7. Otherwise, search for a larger maximum (low = mid + 1).
 *
 * Time Complexity:
 * O(N * log(sumOfPages))
 * - Finding low and high: O(N)
 * - Binary Search: O(log(sumOfPages))
 * - Allocation check: O(N) for each binary search iteration
 *
 * Space Complexity:
 * O(1)
 */

public class AllocateBooks {
    public static int findPages(ArrayList<Integer> arr, int m) {
        
        if (m > arr.size()) {
            return -1;
        }

        int low = 0;
        int high = 0;
        int ans = 0;

        for (int i = 0; i < arr.size(); i++) {
            low = Math.max(low, arr.get(i));
            high += arr.get(i);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canAllocatedBooks(arr, mid, m) == true) {
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    static boolean canAllocatedBooks(ArrayList<Integer> arr, int pages, int students) {
        int sumPages = 0, cntStudent = 1;

        for (int i = 0; i < arr.size(); i++) {

            if (sumPages + arr.get(i) <= pages) {
                sumPages += arr.get(i);
            }else{
                cntStudent++;
                sumPages = arr.get(i);

                if (cntStudent > students) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(12, 34, 67, 90));
        int m = 2;

        System.out.println(findPages(arr, m));;
    }
}
