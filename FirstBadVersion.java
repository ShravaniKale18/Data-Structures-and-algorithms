/*
 * LeetCode 278 - First Bad Version
 *
 * Approach:
 * Use Binary Search because all good versions come before
 * the first bad version, and all versions after it are bad.
 *
 * If mid is a bad version:
 * - Store mid as a possible answer.
 * - Search on the left side to find an earlier bad version.
 *
 * If mid is a good version:
 * - Search on the right side because the first bad version
 *   must be after mid.
 *
 * TC: O(log n)
 * SC: O(1)
 */

public class FirstBadVersion {

    // Used to simulate the isBadVersion API
    private static final int FIRST_BAD_VERSION = 4;

    /*
     * Simulates LeetCode's isBadVersion() API.
     * Returns true if the given version is bad.
     */
    private static boolean isBadVersion(int version) {
        return version >= FIRST_BAD_VERSION;
    }

    static int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int badVersion = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isBadVersion(mid)) {
                badVersion = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return badVersion;
    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println(
            "First bad version: " + firstBadVersion(n)
        );
    }
}