package Array;

public class ReversePairs {
    static int count = 0;

    static int reversePairs(int[] nums) {
        count = 0;
        mergeSort(nums, 0, nums.length-1);
        return count;
    }

    static void mergeSort(int[] nums, int st, int end) {
        if(st >= end) {
            return;
        }
        int mid = st + (end - st) / 2;
        mergeSort(nums, st, mid);//left
        mergeSort(nums, mid+1, end); //right
        countPairs(nums, st, mid, end);
        merge(nums, st, mid, end);
    }

    static void merge(int[] nums, int st, int mid, int end) {
        int i = st;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[end - st + 1];

        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= end) {
            temp[k++] = nums[j++];
        }

        for (int l = 0; l < temp.length; l++) {
            nums[st + l] = temp[l];
        }
    }

    static void countPairs(int[] nums, int st, int mid, int end) {
        int right = mid + 1;
        for (int i = st; i <= mid; i++) {
            while (right <= end && nums[i] > 2L * nums[right]) {
                right++;
            }
            count += right - (mid + 1);
        }
    }
    public static void main(String[] args) {
        int[] nums = {2,4,3,5,1};
        int ans = reversePairs(nums);
        System.out.println(ans);
    }
}
