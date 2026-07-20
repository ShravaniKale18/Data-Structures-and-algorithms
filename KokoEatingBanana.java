public class KokoEatingBanana {
    static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        int ans = 0;

        if (piles.length == 0) {
            return -1;
        }

        for(int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;
            int requiredTime = calculateTime(piles, mid);

            if (requiredTime <= h) {
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    static int calculateTime(int[] piles, int mid) {
        int totalHours = 0;
        for (int i = 0; i < piles.length; i++) {
            totalHours += (int)Math.ceil((double)piles[i] / mid);
        }
        return totalHours;
    }


    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;

        System.out.println(minEatingSpeed(piles, h));
    }
}
