package LeetCode;

/**
 * Balanced Binary Tree
 * <p>
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * KeyWords: Tree, DFS
 * Difficulty: Easy
 */
public class LeetCode110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int l, r;
        l = getHeight(root.left);
        r = getHeight(root.right);
        if ((l > r + 1) || (r > l + 1))
            return false;
        else
            return isBalanced(root.left) && isBalanced(root.right);

    }

    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
