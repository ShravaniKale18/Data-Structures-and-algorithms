/**
 * Approach
 * - Initialize low with the maximum weight because the ship capacity
 *   cannot be less than the heaviest package.
 * - Initialize high with the sum of all weights because the ship can
 *   carry all packages in one day in the worst case.
 * - Apply binary search on the capacity range [low, high].
 * - For each mid capacity, calculate the number of days required to ship
 *   all packages while maintaining the given order.
 * - If the required days are less than or equal to the given days,
 *   store mid as a possible answer and search for a smaller capacity.
 * - Otherwise, increase the capacity and search in the right half.
 *
 * Time Complexity:
 * O(n * log(sum(weights)))
 * - Binary search takes O(log(sum(weights))) iterations.
 * - For each iteration, calculateDays() takes O(n).
 *
 * Space Complexity:
 * O(1)
 */
public class CapacityToShipPackagesWithinDDays {

    static int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        int ans = 0;

        for(int weigth : weights) {
            low = Math.max(low, weigth);
            high += weigth;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int daysUsed = calculateDays(weights, mid);

            if (daysUsed <= days) {
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    static int calculateDays(int[] weights, int capacity) {
        int currentLoad  = 0, daysUsed = 1;
        for(int weight : weights) {

            if (currentLoad + weight > capacity) {
                daysUsed++;
                currentLoad = 0;
            }

            currentLoad += weight;
        }
        return daysUsed;
    }
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days  = 5;
        System.out.println(shipWithinDays(weights, days));
    }
}
