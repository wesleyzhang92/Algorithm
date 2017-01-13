package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * House Robber III
 * <p>
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * Example 1:
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 * 3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * Maximum amount of money the thief can rob = 4 + 5 = 9.
 * <p>
 * KeyWords: Tree, DFS
 * Difficulty: Medium
 */
public class LeetCode337_HouseRobberIII {
    public int rob(TreeNode root) {
        return dfs(root)[0];
    }

    private int[] dfs(TreeNode root) {
        int dp[] = {0, 0};
        if (root != null) {
            int[] dp_L = dfs(root.left);
            int[] dp_R = dfs(root.right);
            dp[1] = dp_L[0] + dp_R[0];
            dp[0] = Math.max(dp[1], dp_L[1] + dp_R[1] + root.val);
        }
        return dp;
    }


    //First Step
    public int rob1(TreeNode root) {
        if (root == null) return 0;

        int val = 0;

        if (root.left != null) {
            val += rob1(root.left.left) + rob1(root.left.right);
        }

        if (root.right != null) {
            val += rob1(root.right.left) + rob1(root.right.right);
        }

        return Math.max(val + root.val, rob1(root.left) + rob1(root.right));
    }

    // Second Step DP, Use HashMap to record the results for visited subtrees
    public int rob2(TreeNode root) {
        return robSub(root, new HashMap<>());
    }

    private int robSub(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);

        int val = 0;

        if (root.left != null) {
            val += robSub(root.left.left, map) + robSub(root.left.right, map);
        }

        if (root.right != null) {
            val += robSub(root.right.left, map) + robSub(root.right.right, map);
        }

        val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
        map.put(root, val);

        return val;
    }


    //Third Step
    public int rob3(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode root) {
        if (root == null) return new int[2];

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] res = new int[2];

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }
}
