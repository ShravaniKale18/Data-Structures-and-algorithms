package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class Union {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 5, 7};
        int[] b = {1, 6, 2, 2, 7, 4};

        Set <Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        for (int i = 0; i < b.length; i++) {
            set.add(b[i]);
        }

        System.out.println(set);

        // ArrayList<Integer> list = new ArrayList<>();
        // int j = 0;
        // for (int i = 1; i < arr.length; i++) {
        //     if (arr[i] != arr[j]) {
        //         j++;
        //         arr[j] = arr[i];
        //     }
        // }

        // for (int i = 0; i <= j; i++) {
        //     System.out.println(arr[i]);
        // }

        
    }
}
