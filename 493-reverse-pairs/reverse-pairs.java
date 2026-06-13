class Solution {

    int count = 0;

    public int reversePairs(int[] nums) {
        count = 0;
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    void mergeSort(int[] nums, int st, int end) {
        if (st >= end) {
            return;
        }

        int mid = st + (end - st) / 2;

        mergeSort(nums, st, mid);
        mergeSort(nums, mid + 1, end);

        countPairs(nums, st, mid, end);
        merge(nums, st, mid, end);
    }

    void countPairs(int[] nums, int st, int mid, int end) {
        int right = mid + 1;

        for (int i = st; i <= mid; i++) {
            while (right <= end && nums[i] > 2L * nums[right]) {
                right++;
            }

            count += right - (mid + 1);
        }
    }

    void merge(int[] nums, int st, int mid, int end) {
        int[] temp = new int[end - st + 1];

        int i = st;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= end) {
            temp[k++] = nums[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            nums[st + p] = temp[p];
        }
    }
}