public class SearchInSortedArrayOfUnknownSize {

    public static int search(int[] arr, int target) {
        int low = 0;
        int high = 1;

        while (high < arr.length && target > arr[high]) {
            low = high;
            high *= 2;
        }

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] == target) {
                return mid;
            }else if(arr[mid] > target) {
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 1;

        int index = search(arr, target);

        System.out.println(index);
    }
}
