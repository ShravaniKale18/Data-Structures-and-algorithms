import java.util.HashMap;

public class SubArraySumDivisibleByK {

    /** 
     * TC => O(N^2)
     * SC => O(1)
     */
    static int subarraysDivByK1(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if ((sum % k) == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    /** 
     * TC => O(N)
     * SC => O(N)
     */
    static int subarraysDivByK(int[] nums, int k) {

        int[] prefixSum = new int[nums.length];
        int count = 0;

        prefixSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < prefixSum.length; i++) {

            int remainder = (prefixSum[i] % k + k) % k;

            if (map.containsKey(remainder)) {

                int oldeFreq = map.get(remainder);
                map.put(remainder, map.getOrDefault(remainder, 0) + 1);
                count += oldeFreq;

            }else{
                map.put(remainder, map.getOrDefault(remainder, 0) + 1);
            }
        }

        return count;
    }
    public static void main(String[] args) {

        int[] arr = {4,5,0,-2,-3,1};
        int k = 5;

        System.out.println(subarraysDivByK(arr, k));
    }
}
