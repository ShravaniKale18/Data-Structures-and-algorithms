import java.util.ArrayList;

/** 
 * Approach:
 * Iterate through each element of the array.
 * For each element, check if the value of the element is equal to its position (1-based index).
 * If it is, add the element to the result list.
 * 
 * Time Complexity: O(n) where n is the number of elements in the array.
 * Space Complexity: O(n) for storing the result list.
 */
public class ValueEqualsPosition {
    public static ArrayList<Integer> valEqualToPos(int[] arr) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == i + 1) {
                ans.add(arr[i]);
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {15, 2, 3, 4, 6};
        ArrayList<Integer> result = valEqualToPos(arr);
        
        if(result.isEmpty()) {
            System.out.println("No elements found where value equals position.");
        } else {
            System.out.println("Elements where value equals position: " + result);
        }
    }
}
