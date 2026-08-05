import java.util.Arrays;
import java.util.HashSet;

/**
 * Approach:
 * - Use a HashSet.
 * - Store all the elements of nums1 in the set.
 * - Loop through nums2.
 * - If the set contains the nums2 element, increment count1.
 * - Clear the set.
 * - Store all the elements of nums2 in the set.
 * - Loop through nums1.
 * - If the set contains the nums1 element, increment count2.
 *
 * TC = O(N + M)
 * SC = O(max(N, M))
 */

public class FindCommonElementsInTwoArrays {

    static int[] findIntersectionValues(int[] nums1, int[] nums2) {
        
        HashSet<Integer> set = new HashSet<>();
        // HashSet<Integer> set2 = new HashSet<>();

        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                count1++;
            }
        }

        set.clear();

        for (int i = 0; i < nums2.length; i++) {
            set.add(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            if (set.contains(nums1[i])) {
                count2++;
            }
        }
        return new int[]{count2, count1};
    }
    public static void main(String[] args) {
        int[] nums1 = {4,3,2,3,1}; 
        int[] nums2 = {2,2,5,2,3,6};

        System.out.println(Arrays.toString(findIntersectionValues(nums1, nums2)));;
    }
}
