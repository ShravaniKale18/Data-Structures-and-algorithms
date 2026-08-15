import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/** 
 * Approach
* Use a Min Heap to always get the pair with the smallest sum.
* Initially add the first pair from each row: (i, 0).
* When (i, j) is removed, add the next pair from the same row: (i, j + 1).
* Repeat until k pairs are collected.

* Time Complexity
* O(k log(min(k, m)))
* Space Complexity
* O(min(k, m)) excluding the output list.
*/
class Pair {
    int i;
    int j;
    int sum;

    Pair(int i, int j, int sum) {
        this.i = i;
        this.j = j;
        this.sum = sum;
    }
}
public class KPairsWithSmallestSum {
    static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.sum, b.sum));

        List<List<Integer>> list = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return list;
        }


        //Generate and Add the pairs into the queue

        for (int i = 0; i < Math.min(k, nums1.length); i++) {

            Pair pair = new Pair(i, 0, nums1[i] + nums2[0]);
            queue.add(pair);

        }

        // Get k Elements from the queue and add into list

        for (int i = 0; i < k && !queue.isEmpty(); i++) {

            Pair current = queue.poll();

            List<Integer> temp = new ArrayList<>();

            temp.add(nums1[current.i]);
            temp.add(nums2[current.j]);

            list.add(temp);

            if (current.j + 1 < nums2.length) {
                queue.add(new Pair(current.i, current.j + 1, nums1[current.i] + nums2[current.j + 1]));
            }
        }
        return list;
    }


    public static void main(String[] args) {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 3;

        System.out.println(kSmallestPairs(nums1, nums2, k));
    }
}
