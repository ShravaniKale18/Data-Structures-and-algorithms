package Array;

import java.util.Arrays;
import java.util.HashMap;

public class CountSubArrays {
 //O(n^2)   
    // static int findAllSubarraysWithGivenSum(int arr[], int s) {
    //     int count = 0;
    //     for (int i = 0; i < arr.length; i++) {
    //         int sum = 0;
    //         for (int j = i; j < arr.length; j++) {
    //             sum += arr[j];
    //             if (sum == s) {
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }

//O(n^2)
    static void findAllSubarraysWithGivenSum1(int[] arr, int s) {   
        int count = 0;
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        

        for (int i = 0; i < prefixSum.length; i++) {
            if (prefixSum[i] == s) {
                count++;
            }

            for (int j = 0; j < prefixSum.length; j++) {
                if (prefixSum[i] - prefixSum[j] == s) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static int findAllSubarraysWithGivenSum2(int[] arr, int s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int currentSum = 0;
        int count = 0;
        map.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            count += map.getOrDefault(currentSum - s, 0);
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        System.out.println(map);

        return count;
    }
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int s = 6;
        int ans = findAllSubarraysWithGivenSum2(arr, s);
        System.out.println("Number of Subarrays = "+ans);


        // findAllSubarraysWithGivenSum2(arr, s);
    }
}
