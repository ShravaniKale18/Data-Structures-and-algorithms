
public class RotiParathaProblem {

    static int calculate(int[] arr, int p) {
        // arr contains cook ranks, p is the number of parathas
        if (p == 0) {
            return 0;
        }

        int low = 0;
        int n = arr.length;
        int minRank = Integer.MAX_VALUE;

        for (int rank : arr) {
            minRank = Math.min(minRank, rank);
        }

        // Upper bound: fastest cook makes all parathas
        int high = minRank * (p * (p + 1) / 2);
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(arr, mid, p)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    static boolean isPossible(int[] arr, int minTime, int p) {
        int parathaCount = 0;

        for (int rank : arr) {
            int currentTime = 0;
            int nextParathaTime = rank;

            while (currentTime + nextParathaTime <= minTime) {
                currentTime += nextParathaTime;
                parathaCount++;

                if (parathaCount >= p) {
                    return true;
                }

                nextParathaTime += rank;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] ranks = {1, 2, 3, 4};
        int p = 10;

        System.out.println("Minimum time: " + calculate(ranks, p));
    }
}
