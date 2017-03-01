package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * <p>
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * return [3,2,1].
 * <p>
 * Note: Recursive solution is trivial, could you do it iteratively?
 * <p>
 * Difficulty: Hard
 * KeyWords: Tree, Stack
 */
public class LeetCode145_BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return ans;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return ans;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode node = s1.pop();
            s2.push(node);
            if (node.left != null)
                s1.push(node.left);

            if (node.right != null)
                s1.push(node.right);
        }

        while (!s2.isEmpty())
            res.add(s2.pop().val);

        return res;
    }
}
