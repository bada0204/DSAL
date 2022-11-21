/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 */

package al.leetcode.easy;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class problem_0094 {

    public List<Integer> solution(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(result, root);
        return result;
    }

    public void inorderTraversal(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(result, root.getLeft());
        result.add(root.getVal());
        inorderTraversal(result, root.getRight());
    }

}
