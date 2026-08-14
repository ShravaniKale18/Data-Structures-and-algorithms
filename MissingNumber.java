import java.util.HashMap;
import java.util.HashSet;

public class MissingNumber {
    public static int missingNumber1(int []a, int n) {
    
        for (int i = 1; i < n; i++) {
            if (a[i - 1] != i) {
                return i;
            }
        }
        return n;
    }

    public static int missingNumber(int []a, int n) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            map.put(a[i], i);
        }

        for (int i = 1; i < n; i++) {
            if (!map.containsKey(i)) {
                return i;
            }
        }
        return n;

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5};
        int n = nums.length;

        System.out.println(missingNumber(nums, n));
    }
}
