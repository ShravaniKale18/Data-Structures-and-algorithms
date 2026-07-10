public class ImplementLowerUpperBound {

    public static int lowerBound(int[] arr, int x, int n) {
        int low = 0;
        int high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int upperBound(int[] arr, int x, int n) {
        int low = 0;
        int high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 4, 4, 6, 8, 10};
        int x = 4;
        int n = arr.length;

        int lb = lowerBound(arr, x, n);
        int ub = upperBound(arr, x, n);

        System.out.println("Lower Bound Index: " + lb);
        System.out.println("Upper Bound Index: " + ub);
    }
}