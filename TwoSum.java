import java.util.Arrays;

public class TwoSum {

    static int[] twoSum(int[] arr, int target){

        int i = 0;
        int j = arr.length - 1;

        while (i <= j) {

            int sum = arr[i] + arr[j];

            if (sum == target) {
                return new int[]{i, j};
            }else if (sum < target) {
                i++;
            }else{
                j--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {-3, -1, 0, 1, 2};

        System.out.println(Arrays.toString(twoSum(arr, -2)));
    }
}
