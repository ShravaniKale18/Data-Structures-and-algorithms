import java.util.Arrays;

public class MoveAllZerosElementsToEnd{

    static void moveZeros(int[] nums) {

        int index = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            } 
        }

        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};

        moveZeros(nums);

        System.out.println(Arrays.toString(nums));
    }
}