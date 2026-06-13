// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         Set<List<Integer>> ans = new HashSet<>();

//         for(int i = 0; i < nums.length; i++) {
//             HashSet<Integer> set = new HashSet<>();

//             for(int j = i + 1; j < nums.length; j++) {
//                 int required = 0 - nums[i] - nums[j];

//                 if(set.contains(required)) {
//                     List<Integer> temp = new ArrayList<>();
//                     temp.add(nums[i]);
//                     temp.add(nums[j]);
//                     temp.add(required);
//                     Collections.sort(temp);
//                     ans.add(temp);
//                 }
//                 set.add(nums[j]);
//             }
//         }
//         return new ArrayList<>(ans);
//     }
// }

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int sum = 0;
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < n - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;

            sum = -1 * nums[i];

            while(left < right) {
                int s = nums[left] + nums[right];

                if(s == sum) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while(left < n && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while(right >= 0 && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }else if(s < sum) {
                    left++;
                }else{
                    right--;
                }
            }
        }
        return result;
    }
}