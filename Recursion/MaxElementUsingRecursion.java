package Recursion;

public class MaxElementUsingRecursion {
    public static int findMaximum(int[] arr, int index, int maxi) {
        if(arr.length == 0) {
            return Integer.MIN_VALUE;
        }

        if(index == arr.length) {
            return maxi;
        }

        if(arr[index] > maxi) {
            maxi = arr[index];
        }

        return findMaximum(arr, index + 1, maxi);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int maxElement = findMaximum(arr, 0, Integer.MIN_VALUE);
        System.out.println("Maximum element in the array: " + maxElement);
    }
}
