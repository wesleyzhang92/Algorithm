package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary Tree Level Order Traversal II
 * <p>
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * <p>
 * KeyWords: Tree, BFS
 * Difficulty: Easy
 */
public class LeetCode107_BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> list = new LinkedList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> cur = new LinkedList<>();


        TreeNode tmp;

        cur.add(root);
        while (!cur.isEmpty()) {
            List<Integer> layout = new ArrayList<>();
            Queue<TreeNode> nxt = new LinkedList<>();
            while (!cur.isEmpty()) {
                tmp = cur.remove();
                if (tmp.left != null) {
                    nxt.add(tmp.left);
                }
                if (tmp.right != null) {
                    nxt.add(tmp.right);
                }
                layout.add(tmp.val);
            }
            cur = nxt;

            list.add(0, layout);
        }

        return list;
    }

    //BFS Solution
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }

    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) return;
        if (level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        levelMaker(list, root.left, level + 1);
        levelMaker(list, root.right, level + 1);
        list.get(list.size() - level - 1).add(root.val);
    }
}
