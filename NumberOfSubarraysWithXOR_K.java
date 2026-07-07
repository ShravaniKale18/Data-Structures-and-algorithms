import java.util.HashMap;

public class NumberOfSubarraysWithXOR_K {

    /*
    * Brute Force Approach
    *
    * 1. Consider every possible starting index.
    * 2. Initialize XOR as 0 for each starting index.
    * 3. Extend the subarray one element at a time by moving the ending index.
    * 4. Update the XOR of the current subarray.
    * 5. If the XOR becomes equal to k, increment the count.
    *
    * Time Complexity: O(N²)
    * - Two nested loops iterate over all possible subarrays.
    *
    * Space Complexity: O(1)
    * - Only a few extra variables are used.
    */

    public static int subarraysWithSumK1(int []arr, int k) {
        int count = 0;
        int xor = 0;

        for (int i = 0; i < arr.length; i++) {
            xor = 0;
            for (int j = i; j < arr.length; j++) {
                xor ^= arr[j];

                if (xor == k) {
                    count++;
                }
            }
        }
        return count;
    }


    /*
    * Optimal Approach (Prefix XOR + HashMap)
    *
    * 1. Maintain the prefix XOR while traversing the array.
    * 2. For every prefix XOR, compute the required XOR as:
    *        requiredXor = prefixXor ^ k
    * 3. If requiredXor exists in the HashMap, add its frequency to the answer.
    * 4. Store/update the frequency of the current prefix XOR in the HashMap.
    * 5. Initialize the map with (0 -> 1) to handle subarrays starting from index 0.
    *
    * Time Complexity: O(N)
    * - Each element is processed exactly once.
    * - HashMap insertion and lookup take O(1) on average.
    *
    * Space Complexity: O(N)
    * - In the worst case, the HashMap stores the frequency of every distinct prefix XOR.
    */
    public static int subarraysWithSumK(int []arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int xor = 0;
        int count = 0;

        map.put(0, 1);

        for (int i = 0; i < arr.length; i++) {

            xor ^= arr[i];
            int x = xor ^ k;

            if (map.containsKey(x)) {
                count += map.get(x);
            }
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return count;
    }


    public static void main(String[] args) {
        int[] arr = {4,2,2,6,4};
        int k = 6;

        int count = subarraysWithSumK(arr, k);
        System.out.println(count);
    }
}
