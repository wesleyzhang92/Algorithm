package LeetCode;

import java.util.HashMap;

/**
 * Path Sum III
 * <p>
 * You are given a binary tree in which each node contains an integer value.
 * <p>
 * Find the number of paths that sum to a given value.
 * <p>
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * <p>
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * <p>
 * Example:
 * <p>
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * <p>
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * <p>
 * Return 3. The paths that sum to 8 are:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 * <p>
 * KeyWords: Tree
 * Difficulty: Easy
 */
public class LeetCode437_PathSumIII {

    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int findPath(TreeNode root, int sum) {
        int res = 0;
        if (root == null)
            return res;
        if (sum == root.val)
            res++;
        res += findPath(root.left, sum - root.val);
        res += findPath(root.right, sum - root.val);
        return res;
    }

    public int pathSum2(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0, 1);
        return helper(root, 0, sum, preSum);
    }

    public int helper(TreeNode root, int sum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }

        sum += root.val;
        int res = preSum.getOrDefault(sum - target, 0);
        preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);

        res += helper(root.left, sum, target, preSum) + helper(root.right, sum, target, preSum);
        preSum.put(sum, preSum.get(sum) - 1);
        return res;
    }
}
