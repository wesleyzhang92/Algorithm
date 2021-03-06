package LeetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Sum of Left Leaves
 * <p>
 * Find the sum of all left leaves in a given binary tree.
 * Example:
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * here are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 * <p>
 * KeyWords: Tree
 * Difficulty: Easy
 */
public class LeetCode404_SumofLeftLeaves {
    // 求的是叶子结点值之和
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) ans += root.left.val;
            else ans += sumOfLeftLeaves(root.left);
        }
        ans += sumOfLeftLeaves(root.right);

        return ans;
    }

    // Iterative Solution Using Stack
    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null)
                    ans += node.left.val;
                else
                    stack.push(node.left);
            }
            if (node.right != null) {
                if (node.right.left != null || node.right.right != null)
                    stack.push(node.right);
            }
        }
        return ans;
    }

    //BFS Solution Using Queue
    public int sumOfLeftLeaves3(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return 0;

        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr.left != null && curr.left.left == null && curr.left.right == null) res += curr.left.val;
            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);
        }
        return res;
    }
}
