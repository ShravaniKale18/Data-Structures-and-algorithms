public class RangeSumQuery {

    int[] nums;

    public RangeSumQuery(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {

        int sum = 0;

        while (left <= right) {
            sum += nums[left];
            left++;
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] nums = {-2, 0, 3, -5, 2, -1};

        RangeSumQuery obj = new RangeSumQuery(nums);

        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
    }
}