public class MajorityElements {

    static int majorityElement1(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int count  = 0;

            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count > nums.length / 2) {
                return nums[i];
            }
        }

        return -1;
    }

    static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            }else if (candidate == nums[i]) {
                count++;
            }else{
                count--;
            }
        }

        int count1 = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == candidate) {
                count1++;

                if (count1 > nums.length / 2) {
                    return nums[i];
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 1, 3, 5, 1};

        System.out.println(majorityElement(arr));
    }
}
