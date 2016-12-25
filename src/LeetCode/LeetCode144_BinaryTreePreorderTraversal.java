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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while(node != null){
            res.add(node.val);
            if(node.right != null)
                stack.push(node.right);
            node = node.left;
            if(node == null && !stack.isEmpty())
                node = stack.pop();
        }
        return res;
    }

    List<Integer> result = new ArrayList<Integer>();

    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root != null) {
            result.add(root.val);
            preorderTraversal2(root.left);
            preorderTraversal2(root.right);
        }
        return result;
    }
}
