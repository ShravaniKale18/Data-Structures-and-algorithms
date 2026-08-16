public class RemoveDuplicatesFromSortedArray_II {

    static int removeDuplicates(int[] nums) {
        
        int k = 0;

        for(int num : nums) {
            if (k < 2 || num != nums[k - 2]) {
                nums[k] = num;
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};

        System.out.println(removeDuplicates(nums));
    }
}
