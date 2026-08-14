import java.util.Arrays;
import java.util.HashMap;

/**
 * Approach:
 * 1. Use HashMap to store the frequency of each element.
 * 2. Find the element with maximum frequency.
 * 3. Add it to the result and remove it from the map.
 * 4. Repeat until k elements are selected.
 *
 * TC => O(N + K * U)
 * SC => O(U)
 *
 * Where:
 * N = number of elements
 * U = number of unique elements
 * K = number of elements to return
 *
 * Worst Case:
 * TC => O(N²)
 * SC => O(N)
 */

public class TopKFrequentElements {

    static int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }


        int[] result = new int[k];

        for (int i = 0; i < k; i++) {

            int maxFreq = 0;
            int maxEle = 0;

            for(int num : map.keySet()) {

                int currentFreq = map.get(num);

                if (currentFreq > maxFreq) {

                    maxEle = num;
                    maxFreq = currentFreq;
                }
            }

            result[i] = maxEle;
            map.remove(maxEle);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}
