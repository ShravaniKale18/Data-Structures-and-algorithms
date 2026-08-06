import java.util.ArrayList;

public class MergeThreeSortedArray {

    static ArrayList<Integer> findCommonElements(int[] arr1, int[] arr2, int[] arr3) {

        /**
         * Approach:
         * 1. Use three pointers i, j, k for the three sorted arrays.
         * 2. If all three elements are equal, add the element to the answer
         *    and move all three pointers.
         * 3. Otherwise, move the pointer pointing to the smallest element.
         * 4. Repeat until one array is exhausted.
         *
         * Time Complexity: O(N + M + K)
         * Space Complexity: O(1) excluding the output list.
         */
        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr1[i] == arr3[k]) {
                ans.add(arr1[i]);
                i++;
                j++;
                k++;
            }else{
                if (arr1[i] <= arr2[j] && arr1[i] <= arr3[k]) {
                    i++;
                }else if (arr2[j] <= arr1[i] && arr2[j] <= arr3[k]) {
                    j++;
                }else{
                    k++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 5, 10, 20, 40, 80};
        int[] B = {6, 7, 20, 80, 100};
        int[] C = {3, 4, 15, 20, 30, 70, 80, 120};

        System.out.println(findCommonElements(A, B, C));
    }
}
