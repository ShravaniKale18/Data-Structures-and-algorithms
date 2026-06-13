package Array;

import java.util.ArrayList;
import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        // ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 0, 0));
        // ArrayList<Integer> temp = new ArrayList<>();
        // int countZeros = 0;

        // for (int i = 0; i < list.size(); i++) {
        //     if (list.get(i) != 0) {
        //         temp.add(list.get(i));
        //     }
        //     else{
        //         countZeros++;
        //     }
        // }

        // for (int i = temp.size(); i < list.size(); i++) {
        //     temp.add(i, 0);
        // }

        // for (int i = 0; i < countZeros; i++) {
        //     temp.add(0);
        // }
        // System.out.println(temp);

        int[] arr = {0, 1, 2, 3, 0, 0, 5};
        int j = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }

        for (int i = j+1; i < arr.length; i++) {
            if (arr[i] != 0) {
                swap(arr, i, j);
                j++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int i, int j) {
        int temp =  arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
