public class NumberOfOccurences {
    /** 
     * Approach:
     * Linear Search
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public static int count1(int arr[], int n, int x) {

        int count = 0;
        
        for(int i = 0; i < n; i++) {
            if(arr[i] == x) {
                count++;
            }
        }

        return count;
    }

    /** 
     * Approach:
     * Binary Search
     * 
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     */

    public static int count(int arr[], int n, int x) {

        int start = 0;
        int end = n - 1;
        int count = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == x) {
                count++;
                start = mid + 1;
            }else if (arr[mid] > x) {
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3, 3};

        System.out.println("Number of Occurences: "+count(arr, arr.length, 3));
    }
}
