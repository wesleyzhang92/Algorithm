package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * For example,
 * [1,1,2] have the following unique permutations:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * Difficulty: Medium
 * KeyWords: BackTracking
 */
public class LeetCode047_PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        permuteHelper(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void permuteHelper(List<List<Integer>> result, List<Integer> tmp, int[] nums, boolean[] used) {
        if (tmp.size() == nums.length) {
            result.add(new ArrayList(tmp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                tmp.add(nums[i]);
                permuteHelper(result, tmp, nums, used);
                tmp.remove(tmp.size() - 1);
                used[i] = false;
            }
        }
    }
}
