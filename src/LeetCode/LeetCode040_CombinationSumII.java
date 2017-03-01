package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination Sum II
 * <p>
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * Each number in C may only be used once in the combination.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * <p>
 * Difficulty: Medium
 * KeyWords: Array, BackTracking
 */
public class LeetCode040_CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (candidates == null) {
            return result;
        }
        //Sort Necessary
        Arrays.sort(candidates);
        helper(candidates, target, 0, result, list);
        return result;
    }

    public void helper(int[] candidates, int target, int index,
                       List<List<Integer>> result, List<Integer> list) {

        if (target == 0) {
            //如果不实例化，所有的项都指向同一个list引用，最后这个list为空，导致所有的结果都是空
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
            helper(candidates, target - candidates[i], i + 1, result, list);
            list.remove(list.size() - 1);
        }
    }
}
