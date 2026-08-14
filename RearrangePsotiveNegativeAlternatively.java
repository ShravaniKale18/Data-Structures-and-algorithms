import java.util.Arrays;

public class RearrangePsotiveNegativeAlternatively {

    static int[] reArrange(int[] nums) {

        int[] pos = new int[nums.length];
        int[] neg = new int[nums.length];

        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                neg[index++] = nums[i];
            }
        }

        index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                pos[index++] = nums[i];
            }
        }

        int posIndex = 0;
        int negIndex = 1;

        for (int i = 0; i < pos.length; i++) {
            if (pos[i] != 0) {
                nums[posIndex] = pos[i];
                posIndex += 2;
            }
        }

        for (int i = 0; i < neg.length; i++) {
            if (neg[i] != 0) {
                nums[negIndex] = neg[i];
                negIndex += 2;
            }
        }

        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};

        System.out.println(Arrays.toString(reArrange(nums)));
    }
}
