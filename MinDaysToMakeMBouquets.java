public class MinDaysToMakeMBouquets{

    static int minDays(int[] bloomDay, int m, int k) {
        int low = Integer.MAX_VALUE;
        int high = 0, ans = -1;

        if ((long)m * k > bloomDay.length) {
            return -1;
        }

        for (int i = 0; i < bloomDay.length; i++) {
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMakeBouquets(bloomDay, mid, m, k) == true) {
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }


    static boolean canMakeBouquets(int[] bloomDay, int day, int m, int k) {
        int bouquets = 0, flowers = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                flowers++;

                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            }else{
                flowers = 0;
            }
        }

        return bouquets >= m;
    }

    public static void main(String[] args) {
        int[] bloomDay = {7,7,7,7,12,7,7};
        int m = 2;
        int k = 3;

        System.out.println(minDays(bloomDay, m, k));

    }
}