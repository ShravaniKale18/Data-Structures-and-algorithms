import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {

    static int maxDistance(int[] position, int m) {

        Arrays.sort(position);
        int low = 1;
        int high = position[position.length - 1] - position[0];
        int ans = -1;
    
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canWePlace(position, mid, m) == true) {
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return ans;
    }


    static boolean canWePlace(int[] position, int distance, int m) {

        int ballsPlaced = 1, lastPosition = position[0];

        for (int i = 1; i < position.length; i++) {

            int currentPosition = position[i];
            int dist =  currentPosition - lastPosition;

            if (dist >= distance) {
                ballsPlaced++;
                lastPosition = position[i];
            }
        }

        return ballsPlaced >= m;
    }
    public static void main(String[] args) {
        int[] position = {1,2,3,4,7};
        int m = 3;

        System.out.println(maxDistance(position, m));
    }
}
