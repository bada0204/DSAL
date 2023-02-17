/**
 * Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.
 * 
 * Example 1:
 * Input: root = [4,2,6,1,3]
 * Output: 1
 * 
 * Example 2:
 * Input: root = [1,0,48,null,null,12,49]
 * ddOutput: 1
 */

package al.leetcode.easy;

import ds.TreeNode;

public class problem_0783 {

    private TreeNode prev;
    private int minDiff = Integer.MAX_VALUE;

    public int solution(TreeNode root) {
        traverse(root);
        return minDiff;
    }

    public void traverse(TreeNode root) {
        if (root != null) {
            traverse(root.getLeft());
            if (prev != null) {
                minDiff = Math.min(minDiff, root.getVal() - prev.getVal());
            }
            prev = root;
            traverse(root.getRight());
        }
    }
    
}
