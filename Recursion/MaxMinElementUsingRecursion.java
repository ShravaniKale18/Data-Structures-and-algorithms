package Recursion;

public class MaxMinElementUsingRecursion {
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

    public static int findMinimum(int[] arr, int index, int mini) {
        if(arr.length == index) {
            return mini;
        }

        if(arr.length == 0) {
            return Integer.MAX_VALUE;
        }

        if(arr[index] < mini) {
            mini = arr[index];
        }

        return findMinimum(arr, index + 1, mini);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int maxElement = findMaximum(arr, 0, Integer.MIN_VALUE);
        int minElement = findMinimum(arr, 0, Integer.MAX_VALUE);
        System.out.println("Maximum element in the array: " + maxElement);
        System.out.println("Minimum element in the array: " + minElement);
    }
}
