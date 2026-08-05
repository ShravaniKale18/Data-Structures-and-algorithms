import java.util.Arrays;

public class RotateArrayByOne {
    public static void rotate(int[] arr) {
		
        int lastElement = arr[arr.length - 1];

        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        arr[0] = lastElement;

        System.out.println(Arrays.toString(arr));
	}

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        rotate(nums);;
    }
}
