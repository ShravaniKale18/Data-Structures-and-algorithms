public class SearchInAlmostSortedArray {
    
    /** 
     * Approach: Binary Search
     * 
     * check for boundary conditions, if the first or last element is the target, return its index.
     * initialize low and high pointers, and perform binary search.
     * if the mid element is equal to the target, return its index.
     * if the mid element's previous or next neighbor is equal to the target, return its index.
     * if the target is greater than the mid element, search in the right half, else search in the left half.   
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int findTarget(int arr[], int target) {
        
        int n = arr.length;
        
        if(arr[0] == target) {
            return 0;
        }
        
        if(arr[n - 1] == target) {
            return n - 1;
        }
        
        int low = 1;
        int high = n - 2;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(arr[mid] == target) {
                return mid;
            }
            
            if(arr[mid - 1] == target) {
                return mid - 1;
            }
            
            if(arr[mid + 1] == target) {
                return mid + 1;
            }
            
            if(target > arr[mid]) {
                low = mid + 2;
            }else{
                high = mid - 2;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 3, 40, 20, 50, 80, 70};
        int target = 80;
        int result = findTarget(arr, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");  
        }
    }
}
