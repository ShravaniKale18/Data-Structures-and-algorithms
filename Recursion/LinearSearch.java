package Recursion;

public class LinearSearch {

    /** 
     * A recursive method to perform linear search on an array.
     * 
     * Time Complexity: O(n) - In the worst case, we may have to check all elements of the array.
     * Space Complexity: O(n) - Due to the recursive call stack, the space complexity is O(n) in the worst case.
     */
    
    public static int search(int[] arr, int target, int index) {
        if (index >= arr.length) {
            return -1; 
        }

        if(arr[index] == target) {
            return index;
        }else{
            return search(arr, target, index + 1);
        }
        
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 30;

        int index = search(arr, target, 0);

        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
