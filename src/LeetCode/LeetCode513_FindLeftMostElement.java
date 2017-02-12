package LeetCode;

/**
 * Find Left Most Element
 * <p>
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * <p>
 * Example 1:
 * Input:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * Output:
 * 1
 * Example 2:
 * Input:
 * <p>
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   5   6
 * /
 * 7
 * <p>
 * Output:
 * 7
 * Difficulty: Medium
 */
public class LeetCode513_FindLeftMostElement {
    int ans = 0, h = 0;

    public int findLeftMostNode(TreeNode root) {
        findLeftMostNode(root, 1);
        return ans;
    }

    public void findLeftMostNode(TreeNode root, int depth) {
        if (root == null) return;
        if (h < depth) {
            ans = root.val;
            h = depth;
        }
        findLeftMostNode(root.left, depth + 1);
        findLeftMostNode(root.right, depth + 1);
    }
}
