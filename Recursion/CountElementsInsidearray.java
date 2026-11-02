package Recursion;

public class CountElementsInsidearray {
    /** 
     * Recursive method to count the number of elements in an array.
     * 
     * Time Complexity: O(n) - In the worst case, we may have to traverse all elements of the array.
     * Space Complexity: O(n) - Due to the recursive call stack, the space complexity
     */
    
    public static int countElements(int[] arr, int index, int count) {
        if(index == arr.length) {
            return count;
        }

        return countElements(arr, index + 1, count + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        int count = countElements(arr, 0, 0);

        System.out.println("Number of elements in the array: " + count);
    }
}
