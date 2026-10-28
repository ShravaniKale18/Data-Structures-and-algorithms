public class SingleNonDuplicateElement {

    /**
     * Approach: Binary Search
     * 
     * check for boundary conditions, if the first or last element is the single element, return it.
     * initialize low and high pointers, and perform binary search.
     * if the mid element is not equal to its neighbors, return it as the single element
     * if the mid element is equal to its next neighbor and mid is even, search in the right half, else search in the left half.
     * if the mid element is equal to its previous neighbor and mid is odd, search in the right half, else search in the left half
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int getSingleElement(int []arr){

        int n = arr.length;

        if(n == 1) {
            return arr[0];
        }

        if(arr[0] != arr[1]) {
            return arr[0];
        }

        if(arr[n - 1] != arr[n - 2]) {
            return arr[n - 1];
        }

        int low = 1;
        int high = arr.length - 2;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            }else{
                if ((mid % 2 == 0 && arr[mid] == arr[mid + 1]) ||
                    (mid % 2 == 1 && arr[mid] == arr[mid - 1])) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 4, 5, 5};
        System.out.println(getSingleElement(arr));
    }
}
