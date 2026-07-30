public class MedianOfTwoSortedArrays {

    /**
     * Approach
     * - Use two pointers i and j for nums1 and nums2.
     * - Compare elements from both sorted arrays.
     * - Add the smaller element to mergedArray.
     * - Add remaining elements after one array is exhausted.
     * - Find the median from the merged sorted array.
     *
     * TC -> O(n + m)
     * SC -> O(n + m)
     */

    static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len = nums1.length + nums2.length;

        int[] mergedArray = new int[len];
        int index = 0;

        int n = nums1.length; 
        int m = nums2.length;
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                mergedArray[index++] = nums1[i++];
            }else{
                mergedArray[index++] = nums2[j++];
            }
        }

        while (i < n) {
            mergedArray[index++] = nums1[i++];
        }

        while (j < m) {
            mergedArray[index++] = nums2[j++];
        }

        int mid = mergedArray.length / 2;

        if (mergedArray.length % 2 == 0) {
            return (mergedArray[mid - 1] + mergedArray[mid]) / 2.0;
        } else {
            return mergedArray[mid];
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4};
        int[] nums2 = {2};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
