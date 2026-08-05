import java.util.Arrays;

public class SeparateNegativeAndPositive {
    public static int[] separateNegativeAndPositive(int nums[]) {

        int[] newArr = new int[nums.length];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                newArr[index] = nums[i];
                index++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                newArr[index] = nums[i];
                index++;
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, -3, 2, -6, 9};

        System.out.println(Arrays.toString(separateNegativeAndPositive(nums)));
    }
}

