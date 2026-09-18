import java.util.HashMap;


/** 
 *feat: solve kth unique string problem

- Count string frequencies using HashMap
- Find the kth unique string while preserving input order
- Return -1 when fewer than k unique strings exist
- Time complexity: O(N) average
- Space complexity: O(N)
 */

public class KthUniqueString {

    static String uniqueStrings(String[] arr, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }


        int count  = 0;

        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == 1) {
                count++;

                if(count == k) {
                    return arr[i];
                }
            }
        }

        return "-1";
    }
    public static void main(String[] args) {
        
        // String[] arr = {
        //     "d",
        //     "b",
        //     "c",
        //     "b",
        //     "c",
        //     "a"
        // };

        String[] arr = {
            "dac",
            "ba",
            "a"
        };

        int k = 1;


        System.out.println(uniqueStrings(arr, k));
    }
}
