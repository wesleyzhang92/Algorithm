package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Binary Tree Paths
 *
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * All root-to-leaf paths are:
 *
 * ["1->2->5", "1->3"]
 *
 * KeyWords: Tree, DFS
 * Difficulty: Easy
 */
public class LeetCode257_BinaryTreePaths {

    List<String> result = new LinkedList<>();
    List<Integer> path = new LinkedList<>();

    public List<String> binaryTreePaths2(TreeNode root) {
        if (root == null) return result;
        getPaths(root);
        return result;
    }

    public void getPaths(TreeNode node) {
        if (node == null) return;
        path.add(node.val);
        if (node.left == null && node.right == null) {
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < path.size(); i++) {
                if (i != 0)
                    buffer.append("->");
                buffer.append(path.get(i));
            }
            result.add(buffer.toString());
        }
        getPaths(node.left);
        getPaths(node.right);
        path.remove(path.size() - 1);
    }

    //Solution Two
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if (root != null) searchBT(root, "", answer);
        return answer;
    }

    private void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.val);
        if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
        if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
    }

}
