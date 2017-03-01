package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination Sum
 * <p>
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [
 * [7],
 * [2, 2, 3]
 * ]
 * KeyWords: Array, BackTracking
 * Difficulty: Medium
 */
public class LeetCode039_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (candidates == null) {
            return result;
        }
        Arrays.sort(candidates);
        helper(candidates, target, 0, result, list);
        return result;
    }

    public void helper(int[] candidates, int target, int index,
                       List<List<Integer>> result, List<Integer> list) {

        if (target == 0) {
            result.add(new ArrayList<Integer>(list));//new ArrayList<Integer>(list)
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            helper(candidates, target - candidates[i], i, result, list);
            list.remove(list.size() - 1);
        }
    }
}
