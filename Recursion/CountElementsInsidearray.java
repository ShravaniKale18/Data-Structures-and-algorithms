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

    public static int countTargetElement(int[] arr, int index, int target, int count) {
        if(index >= arr.length) {
            return count;
        }

        if(arr[index] == target) {
            count++;
        }

        return countTargetElement(arr, index + 1, target, count);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        int count = countElements(arr, 0, 0);
        System.out.println("Number of elements in the array: " + count);

        int target = 3;
        int targetCount = countTargetElement(arr, 0, target, 0);
        System.out.println("Number of occurrences of " + target + " in the array: " + targetCount);
    }
}
