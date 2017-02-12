package LeetCode;

/**
 * Find Largest Element in Each Row
 * <p>
 * You need to find the largest value in each row of a binary tree.
 * <p>
 * Example:
 * Input:
 * <p>
 * 1
 * / \
 * 3   2
 * / \   \
 * 5   3   9
 * <p>
 * Output: [1, 3, 9]
 * <p>
 * Difficulty: Medium
 */
public class LeetCode515_FindLargestElementinEachRow {
    public int[] findValueMostElement(TreeNode root) {
        int height = getTreeHeight(root);
        int[] result = new int[height];
        if (root == null) {
            return result;
        }
        for (int i = 0; i < height; i++) {
            int tmp = getMax(root, i);
            result[i] = tmp;
        }
        return result;
    }

    private int getMax(TreeNode root, int i) {
        if (root == null || i < 0) {
            return Integer.MIN_VALUE;
        }
        if (i == 0) {
            return root.val;
        }
        return Math.max(getMax(root.left, i - 1), getMax(root.right, i - 1));

    }

    private int getTreeHeight(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = getTreeHeight(root.left);
        int rightHeight = getTreeHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
