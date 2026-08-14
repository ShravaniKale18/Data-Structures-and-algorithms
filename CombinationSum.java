import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> currentCombination = new ArrayList<>();

        solve(candidates, 0, target, currentCombination, result);

        return result;
    }

    static void solve(int[] candidates, int index, int remainingTarget, List<Integer> currentCombination, List<List<Integer>> result) {

        // Valid combination found
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        // Invalid condition
        if (remainingTarget < 0 || index == candidates.length) {
            return;
        }

        // TAKE the current candidate
        currentCombination.add(candidates[index]);

        // Same index because we can reuse the number
        solve(candidates, index, remainingTarget - candidates[index], currentCombination, result);

        // Backtrack: remove the number
        currentCombination.remove(currentCombination.size() - 1);

        // SKIP the current candidate
        solve(candidates, index + 1, remainingTarget, currentCombination, result);
    }

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        System.out.println(combinationSum(candidates, target));
    }
}