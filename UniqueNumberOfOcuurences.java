import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberOfOcuurences {

    static boolean uniqueOccurrences(int[] arr) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>();

        for (int freq : map.values()) {
            if (!set.add(freq)) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1, 1};

        System.out.println(uniqueOccurrences(arr));
    }
}
