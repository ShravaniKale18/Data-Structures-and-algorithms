class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int element1 = 0, element2 = 0;
        int count1 = 0, count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i] == element1) {
                count1++;
            } else if (nums[i] == element2) {
                count2++;
            } else if (count1 == 0) {
                element1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                element2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (element1 == nums[i]) {
                cnt1++;
            }else if(element2 == nums[i]){
                cnt2++;
            }
        }
        if (cnt1 > (nums.length / 3)) {
                ans.add(element1);
        }
        if(cnt2 > (nums.length / 3)){
            ans.add(element2);
        }
        return ans;
    }
}