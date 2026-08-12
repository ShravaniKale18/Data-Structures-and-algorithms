import java.util.Arrays;

public class ChocolateDistribution{

    static int findMinDiff(int arr[], int m) {

        if (m > arr.length) {
            return -1;
        }
        
        Arrays.sort(arr);

        int mindiff = Integer.MAX_VALUE;

        for (int i = 0; i <= arr.length - m; i++) {

            int currentDiff = arr[i + m - 1] - arr[i];

            if (currentDiff < mindiff) {
                mindiff = currentDiff;
            }
        }
        return mindiff;
        
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 4, 9, 12, 56};
        int m = 3;

        System.out.println(findMinDiff(arr, m));
    }
}