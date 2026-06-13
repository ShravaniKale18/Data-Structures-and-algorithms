package Array;

public class PrintSubArray {

    static void printSubArray(int[] nums) {

        int maxsum = nums[0];
        int currentSum = nums[0];

        int start = 0, ansStart = 0, ansEnd = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[i] + currentSum) {
                currentSum = nums[i];
                start = i;
            }else{
                currentSum += nums[i];
            }

            if(currentSum > maxsum) {
                maxsum = currentSum;
                ansStart = start;
                ansEnd = i;
            }
        }

        System.out.println("Max Sum = "+maxsum);
        System.out.println("Sub-Array : ");
        System.out.print    ("[");
        for (int i = ansStart; i < ansEnd; i++) {
            System.out.print(+nums[i]+",");
        }
        System.out.print("]");
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 7, -4, 3, 2, -10, 9, 1};
        printSubArray(arr);
    }
}
