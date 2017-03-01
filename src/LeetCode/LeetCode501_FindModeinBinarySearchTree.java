package LeetCode;

import java.util.*;

/**
 * Find Mode in Binary Search Tree
 * <p>
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * For example:
 * Given BST [1,null,2,2],
 * 1
 * \
 * 2
 * /
 * 2
 * return [2].
 * <p>
 * Note: If a tree has more than one mode, you can return them in any order.
 * <p>
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 * <p>
 * KeyWords: Tree
 * Difficulty: Easy
 */
public class LeetCode501_FindModeinBinarySearchTree {
    Map<Integer, Integer> map;
    int max = 0;

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        this.map = new HashMap<>();
        inorder(root);

        List<Integer> list = new LinkedList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max) list.add(key);
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) res[i] = list.get(i);
        return res;
    }

    private void inorder(TreeNode node) {
        if (node.left != null) inorder(node.left);
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        max = Math.max(max, map.get(node.val));
        if (node.right != null) inorder(node.right);
    }


    //O(1) Space
    List<Integer> ans = new ArrayList<>();
    Integer pre;
    int maxFreq = 0, curFreq = 0;

    public int[] findMode2(TreeNode root) {
        traverse(root);
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) res[i] = ans.get(i);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        //inorder traversal
        traverse(root.left);
        if (pre != null && root.val == pre) {
            curFreq++;
        } else {
            curFreq = 1;
        }
        if (curFreq == maxFreq) {
            ans.add(root.val);
        } else if (curFreq > maxFreq) {
            maxFreq = curFreq;
            ans = new ArrayList<>();
            ans.add(root.val);
        }

        pre = root.val;
        traverse(root.right);
    }
}
