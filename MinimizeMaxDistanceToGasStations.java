public class MinimizeMaxDistanceToGasStations {
      /*
     * Approach:
     * - Use Binary Search on the answer (maximum allowed distance).
     * - Initialize low = 0 and high = maximum gap between consecutive gas stations.
     * - Find mid as the possible maximum distance.
     * - For every gap, calculate how many new gas stations are required
     *   to make the gap <= mid.
     * - If required gas stations <= K, mid is possible,
     *   so try a smaller distance by moving high = mid.
     * - Otherwise, mid is not possible,
     *   so increase the distance by moving low = mid.
     * - Continue until the difference between high and low is very small.
     *
     * TC -> O(N * log(maxGap / 1e-6))
     * SC -> O(1)
     */

    public static double minimiseMaxDistance(int[] arr, int K) {

        double low = 0;
        double high = 0;

        // Find maximum gap
        for (int i = 1; i < arr.length; i++) {
            high = Math.max(high, arr[i] - arr[i - 1]);
        }

        while (high - low > 1e-6) {

            double mid = low + (high - low) / 2.0;

            if (canWePlace(arr, mid, K)) {
                // mid is possible, so try smaller distance
                high = mid;
            } else {
                // mid is not possible, so increase distance
                low = mid;
            }
        }

        return high;
    }

    public static boolean canWePlace(int[] arr, double distance, int K) {

        int gasStations = 0;

        for (int i = 1; i < arr.length; i++) {

            double gap = arr[i] - arr[i - 1];

            gasStations += (int) Math.ceil(gap / distance) - 1;

            if (gasStations > K) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int k = 6;

        System.out.println(minimiseMaxDistance(arr, k));
    }
}
