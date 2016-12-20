package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * Binary Inorder Traversal
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree [1,null,2,3],
 * 1
 *  \
 *   2
 *  /
 * 3
 * return [1,3,2].
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * KeyWords: Tree, Hash Table, Stack
 * Difficulty: Medium
 */
public class LeetCode094 {
    //Recursive Version
     public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> ls = new ArrayList<Integer>();
         if(root==null)
             return ls;
         if(root.left!=null)
             ls.addAll(inorderTraversal(root.left));
         ls.add(root.val);
         if(root.right!=null)
             ls.addAll(inorderTraversal(root.right));
         return ls;
     }

     //Iteratively Solution
     public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode curNode = root;

        while( !stack.isEmpty() || curNode!=null){
            while(curNode != null){
                stack.push(curNode);
                curNode = curNode.left;
            }

            if( !stack.isEmpty()){
                curNode = stack.pop();
                list.add(curNode.val);
                curNode = curNode.right;
            }
        }

        return list;
    }
}
