class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int el = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(count == 0) {
                count = 1;
                el = nums[i];
            }else if(el == nums[i]) {
                count++;
            }else{
                count--;
            }
        }

        int count2 = 1;
        for(int i = 0; i < nums.length; i++) {
            if(el == nums[i]) {
                count2++;
            }
        }

        if(count2 > nums.length/2) {
            return el;
        }
        return -1;
    }
}