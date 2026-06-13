class Solution {
    public int longestConsecutive(int[] nums) {
        int lastSmaller = Integer.MIN_VALUE;
        int maxLength = 1, count = 1;
        if(nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if((nums[i] - 1) == lastSmaller) {
                count++;
                lastSmaller = nums[i];
            }else if(nums[i] != lastSmaller) {
                count = 1;
                lastSmaller = nums[i];
            }
            maxLength  = Math.max(maxLength, count);
        }
        return maxLength;
    }
}