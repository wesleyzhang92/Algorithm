package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Maximum Depth of Binary Tree
 *
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * KeyWords: Tree, DFS
 * Difficulty: Easy
 */
public class LeetCode104_MaximumDepthofBinaryTree {
    //Divide and Conquer
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return max;
    }

    //Traverse
    private int depth;

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        depth = 0;
        helper(root, 1);
        return depth;
    }

    private void helper(TreeNode root, int curdepth) {
        if (root == null) {
            return;
        }
        if (curdepth > depth) {
            depth = curdepth;
        }
        helper(root.left, curdepth + 1);
        helper(root.right, curdepth + 1);
    }

    //Non Recursive
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int height = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
            height++;
        }
        return height;
    }
}
