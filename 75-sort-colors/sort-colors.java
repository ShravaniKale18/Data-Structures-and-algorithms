class Solution {
    public void sortColors(int[] arr) {
        //Dutch National Flag Algorithm
        //T.C -> O(n^2)
        int start = 0;
        int mid = 0;
        int end = arr.length - 1;

        while(mid <= end) {
            if(arr[mid] == 0) {
                swap(arr, mid, start);
                mid++;
                start++;
            }else if(arr[mid] == 1) {
                mid++;
            }else{
                swap(arr, mid, end);
                end--;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}