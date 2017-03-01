package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Binary Tree Preorder Traversal
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 *  1
 *  \
 *  2
 *  /
 * 3
 * return [1,2,3].
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * KeyWords: Tree, Stack
 * Difficulty: Medium
 */
public class LeetCode144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> pre = new LinkedList<Integer>();
        if (root == null) return pre;
        Stack<TreeNode> tovisit = new Stack<TreeNode>();
        tovisit.push(root);
        while (!tovisit.empty()) {
            TreeNode visiting = tovisit.pop();
            pre.add(visiting.val);
            if (visiting.right != null) tovisit.push(visiting.right);
            if (visiting.left != null) tovisit.push(visiting.left);
        }
        return pre;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> pre = new LinkedList<Integer>();
        preHelper(root, pre);
        return pre;
    }

    public void preHelper(TreeNode root, List<Integer> pre) {
        if (root == null) return;
        pre.add(root.val);
        preHelper(root.left, pre);
        preHelper(root.right, pre);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new LinkedList<Integer>();
        if (root == null) return pre;
        pre.add(root.val);
        pre.addAll(preorderTraversal(root.left));
        pre.addAll(preorderTraversal(root.right));
        return pre;
    }
}
