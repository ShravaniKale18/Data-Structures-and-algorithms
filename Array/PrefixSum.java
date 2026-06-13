package Array;

import java.util.HashMap;

public class PrefixSum {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 11};
        // int[] arr = {1, 1, 1, 2};
        int k = 6;
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i : arr) {
            sum += i;
            if (map.containsKey(sum - k)) {
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println(count);
    }
}
