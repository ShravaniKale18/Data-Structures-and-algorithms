package Array;

import java.util.ArrayList;
import java.util.Arrays;

public class rotateArray {

    static void rotateArrayEle(ArrayList<Integer> arr, int k) {
        ArrayList<Integer> temp = new ArrayList<>(k);
        
        for (int i = 0; i < k; i++) {
            temp.add(arr.get(i));
        }

        for(int i = k; i < arr.size(); i++) {
            arr.set(i-k, arr.get(i));
        }

        // arr[]
        for (int i = 0; i < temp.size(); i++) {
            arr.set(arr.size()-k+i, temp.get(i));
        }
        
        System.out.println(arr);
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 22, 31, 4, 5));
        rotateArrayEle(arr, 2);
        // int temp = arr[0];

        // for (int i = 1; i < arr.length; i++) {
        //     arr[i-1] = arr[i];
        // }

        // arr[arr.length - 1] = temp;
        // for (int i : arr) {
        //     System.out.print(i+" ");
        // }
    }
}
