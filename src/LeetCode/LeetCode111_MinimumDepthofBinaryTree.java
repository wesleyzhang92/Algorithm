package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Minimum Depth of Binary Tree
 * <p>
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * KeyWords: Tree, DFS, BFS
 * Difficulty: Easy
 */
public class LeetCode111_MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;

    }

    public int minDepth2(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode temp, magic = new TreeNode(0);
        queue.add(root);
        queue.add(magic);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (temp.equals(magic)) {
                if (!queue.isEmpty()) {
                    depth++;
                    queue.add(magic);
                }
                continue;
            }
            if (temp.left == null && temp.right == null)
                return depth;
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
        return depth;
    }


    private int min = Integer.MAX_VALUE; // 记录树的最小深度
    private int cur = 0; // i当前处理的树的尝试

    public int minDepth3(TreeNode root) {

        depth(root);
        return min;
    }

    private void depth(TreeNode node) {

        if (node == null) {
            min = cur;
            return;
        }

        cur++; // 当前处理的层次加1
        // 如果是叶节点，并且路径比记录的最小还小
        if (node.left == null && node.right == null && cur < min) {
            min = cur; // 更新最小值
        }
        // 处理左子树
        if (node.left != null) {
            depth(node.left);
        }

        // 处理右子树
        if (node.right != null) {
            depth(node.right);
        }

        cur--; // 还原

    }
}
