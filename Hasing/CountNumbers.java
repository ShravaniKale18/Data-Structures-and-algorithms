package Hasing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountNumbers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // int[] arr = new int[5];

        // for (int i = 0; i < arr.length; i++) {
        //     arr[i] = sc.nextInt();
        // }

        // int[] hash = new int[13];

        // for (int i = 0; i < arr.length; i++) {
        //     hash[arr[i]] += 1;
        // }

        // int q;
        // q = sc.nextInt();
        // while (q-- >= 0) {
        //     int number;
        //     number = sc.nextInt();
        //     System.out.print(hash[number]+" ");
        // }
        int n;
        n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }
        System.out.println(map);

        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;

        int maxElement = -1;
        int minElement = -1;

        //Traversing the map
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if(entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                maxElement = entry.getKey();
            }

            if(entry.getValue() < minFreq) {
                minFreq = entry.getValue();
                minElement = entry.getKey();
            }
        }

        System.out.println(maxElement);
        System.out.println(minElement);
        sc.close();
    }
}
