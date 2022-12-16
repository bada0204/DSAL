/**
 * Given the root of a binary tree, invert the tree, and return its root.
 * 
 * Example:
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 */

package al.leetcode.easy;

import ds.TreeNode;

public class problem_0226 {
    
    public TreeNode solution(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);
        solution(root.getLeft());
        solution(root.getRight());
        return root;
    }

}
