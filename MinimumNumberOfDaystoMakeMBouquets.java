
/*
Approach:
1. First, check if it is possible to make m bouquets.
   - Each bouquet requires k adjacent flowers.
   - If (m * k) > total number of flowers, return -1.

2. Find the minimum and maximum bloom day in the array.
   - These represent the search space for the answer.

3. Apply Binary Search on the answer:
   - mid represents a candidate day.
   - Check if it is possible to make at least m bouquets by day = mid.
   - If possible:
       -> Store mid as the current answer.
       -> Search for a smaller valid day (high = mid - 1).
   - Otherwise:
       -> Search on larger days (low = mid + 1).

4. To check if a day is possible:
   - Traverse the bloomDay array.
   - Count consecutive flowers that have bloomed (bloomDay[i] <= day).
   - Whenever the count reaches k:
       -> One bouquet is formed.
       -> Reset the consecutive flower count.
   - If an unbloomed flower is encountered:
       -> Reset the consecutive flower count since bouquets require adjacent flowers.
   - If the number of bouquets formed is at least m, return true.

Time Complexity:
- Finding min and max bloom day: O(n)
- Binary Search: O(log(MaxBloomDay - MinBloomDay))
- Each feasibility check: O(n)

Overall Time Complexity:
O(n * log(MaxBloomDay - MinBloomDay))

Space Complexity:
O(1)
*/

public class MinimumNumberOfDaystoMakeMBouquets{
    static int minDays(int[] bloomDay, int m, int k) {

        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int ans = -1;

        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (possible(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    static boolean possible(int[] bloomDay, int day, int m, int k) {
        int bouquets = 0;
        int flowers = 0;

        for(int bloom : bloomDay) {
            if (bloom <= day) {
                flowers++;

                if (flowers == k) {
                    bouquets++;
                    flowers = 0;

                    if (bouquets >= m) {
                        return true;
                    }
                }
            }else {
                flowers = 0; 
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] bloomDays = {1,10,3,10,2};
        int m = 3, k = 1;

        System.out.println(minDays(bloomDays, m, k));;
    }
}
