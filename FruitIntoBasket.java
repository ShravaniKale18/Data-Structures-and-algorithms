//https://leetcode.com/problems/fruit-into-baskets/description/
// You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
//TC: O(n) where n is the length of the fruits array
//SC: O(1) since the maximum number of fruit types we can have in our baskets is 2, the space used by the HashMap is constant.

import java.util.HashMap;

public class FruitIntoBasket {
    static int totalFruit(int[] fruits) {
        int maxFruits = 0;
        int low = 0;
        HashMap<Integer, Integer> fruitCount = new HashMap<>();

        for(int high = 0; high < fruits.length; high++) {
            fruitCount.put(fruits[high], fruitCount.getOrDefault(fruits[high], 0) + 1);

            while(fruitCount.size() > 2) {
                int leftFruit = fruits[low];
                fruitCount.put(fruits[low], fruitCount.get(leftFruit) - 1);

                if(fruitCount.get(leftFruit) == 0) {
                    fruitCount.remove(leftFruit);
                }
                low++;
            }
            maxFruits = Math.max(maxFruits, high - low + 1);
        }
        return maxFruits;
    }
    public static void main(String[] args) {
        int[] fruits = {1,2,3,2,2};
        System.out.println(totalFruit(fruits));
    }
}
