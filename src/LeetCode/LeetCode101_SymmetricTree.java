package LeetCode;

import java.util.Stack;

/**
 * Symmetric Tree
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *   1
 *  / \
 * 2   2
 * / \ / \
 * 3 4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *  1
 * / \
 * 2  2
 * \  \
 * 3   3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 *
 * KeyWords: Tree, DFS, BFS
 * Difficulty: Easy
 */
public class LeetCode101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        else
            return testSymmeric(root.left,root.right);
    }

    public boolean testSymmeric(TreeNode left_Node,TreeNode right_Node){
        if(left_Node==null&&right_Node==null)
            return true;
        if(left_Node==null||right_Node==null||left_Node.val!=right_Node.val)
            return false;
        else
            return testSymmeric(left_Node.left,right_Node.right)&&testSymmeric(left_Node.right,right_Node.left);
    }


    //non-recursive Solution
    public boolean isSymmetric2(TreeNode root) {
        if(root==null)  return true;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode left, right;
        if(root.left!=null){
            if(root.right==null) return false;
            stack.push(root.left);
            stack.push(root.right);
        }
        else if(root.right!=null){
            return false;
        }

        while(!stack.empty()){
            if(stack.size()%2!=0)   return false;
            right = stack.pop();
            left = stack.pop();
            if(right.val!=left.val) return false;

            if(left.left!=null){
                if(right.right==null)   return false;
                stack.push(left.left);
                stack.push(right.right);
            }
            else if(right.right!=null){
                return false;
            }

            if(left.right!=null){
                if(right.left==null)   return false;
                stack.push(left.right);
                stack.push(right.left);
            }
            else if(right.left!=null){
                return false;
            }
        }

        return true;
    }
}
