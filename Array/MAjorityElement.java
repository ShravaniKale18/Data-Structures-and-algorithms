package Array;

import java.util.Arrays;
import java.util.HashMap;

public class MAjorityElement {

    static int findMajorityElement(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            map.put(current, map.getOrDefault(current, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) >=  n / 2) {
                return key;
            }
        }

        return -1;
    }

    static int findMajorityElement2(int[] arr) {
        int count = 0;
        int element = 0;

        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                count = 1;
                element = arr[i];
            }else if(element == arr[i]) {
                count++;
            }else{
                count--;
            }
        }
        int count2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (element == arr[i]) {
                count2++;
            }
            if (count2 > (arr.length/2)) {
                return arr[i];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr  = {2, 2, 2, 1, 3 , 1, 1, 1, 1};
        int ans = findMajorityElement2(arr);
        System.out.println(ans);
    }
}
