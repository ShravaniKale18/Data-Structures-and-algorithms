public class SqrtOfNumber {

    static int mySqrt(int x) {
        int low = 0;
        int high = x;

        while (low <= high) {
            
            int mid = low + (high - low) / 2;

            if(mid * mid > x) {
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return high;
    }

    public static void main(String[] args) {
        int x = 8;

        System.out.println(mySqrt(x));
    }
}
