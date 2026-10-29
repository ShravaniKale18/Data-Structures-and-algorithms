public class PushZerosAtEnd {

    /** 
     * Approach:
     * 1. Initialize an index variable to keep track of the position to place non-zero elements
     * 2. Iterate through the array and for each non-zero element, place it at the index position and increment the index
     * 3. After processing all elements, fill the remaining positions in the array with zeros
     * 
     * Time Complexity: O(n) where n is the length of the array
     * Space Complexity: O(1) since we are modifying the array in place
     */
    public static void pushZerosAtEnd(int[] arr) {

        int idx = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                arr[idx++] = arr[i];
            }
        }

        for(int i = idx; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    /** 
     * Approach:
     * 1. Create a new array to store the non-zero elements
     * 2. Iterate through the original array and copy non-zero elements to the new array
     * 3. Fill the remaining positions in the new array with zeros
     * 4. Copy the new array back to the original array
     * 
     * Time Complexity: O(n) where n is the length of the array
     * Space Complexity: O(n) since we are using an additional array to store the non-zero elements
     */

    public static void pushZerosAtEnd1(int[] arr, int n) {

        int[] newArr = new int[arr.length];
        int idx = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                newArr[idx++] = arr[i];
            }
        }

        for(int i = idx; i < newArr.length; i++) {
            newArr[idx] = 0;
        }

        for(int i = 0; i < arr.length; i++) {
            arr[i] = newArr[i];
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 0, 2, 0, 3, 0, 4, 5};
        pushZerosAtEnd(arr);

        System.out.print("Array after pushing zeros to the end: ");
        for(int num : arr) {
            System.out.print(num + " ");
        }
    }
    
}
