import java.util.ArrayList;

/**
 * Approach
 * - Use two pointers i and j for arr1 and arr2.
 * - Compare elements at i and j.
 * - Add the smaller element to mergedList and move its pointer.
 * - After one list is exhausted, add the remaining elements
 *   from the other list.
 * - Return the element at index k - 1 because k is 1-based.
 *
 * TC -> O(n + m)
 * SC -> O(n + m)
 */

public class KthElementofTwoSortedArrays {

    static int kthElement(int[] arr1, int[] arr2, int n, int m, int k) {
        
        int len = arr1.length + arr2.length;
        int i = 0,  j = 0, index = 0;

        int[] mergedArray = new int[len];

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                mergedArray[index++] = arr1[i++];
            }else{
                mergedArray[index++] = arr2[j++];
            }
        }

        while (i < n) {
            mergedArray[index++] = arr1[i++];
        }

        while (j < m) {
            mergedArray[index++] = arr2[j++];
        }

        return mergedArray[k - 1];
    }

    static int kthElement1(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
        
        int i = 0,  j = 0;

        ArrayList<Integer> mergedList = new ArrayList<>();
        

        while (i < n && j < m) {
            if (arr1.get(i) < arr2.get(j)) {
                mergedList.add(arr1.get(i++));
            }else{
                mergedList.add(arr2.get(j++));
            }
        }

        while (i < n) {
            mergedList.add(arr1.get(i++));
        }

        while (j < m) {
            mergedList.add(arr2.get(j++));
        }

        return mergedList.get(k - 1);
    }
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 45};
        int[] arr2 = {4, 6, 7, 8};

        ArrayList<Integer> nums1 = new ArrayList<>();
        ArrayList<Integer> nums2 = new ArrayList<>();

        for (int num : arr1) {
            nums1.add(num);
        }

        for (int num : arr2) {
            nums2.add(num);
        }

        int k = 4;

        System.out.println(kthElement1(nums1, nums2, nums1.size(), nums2.size(), k));
    }
}
