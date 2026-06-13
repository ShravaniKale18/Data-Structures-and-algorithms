package Array;

import java.util.Arrays;

public class MergeIntervals {
    static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        return intervals;
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] ans = merge(intervals);
        for (int[] in : ans) {
            System.out.println(in[0]+" "+in[1]);
        }
    }
}
