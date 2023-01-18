/**
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 * 
 * Example 1:
 * Input: root = [1,2,5,3,4,null,6]
 * Output: [1,null,2,null,3,null,4,null,5,null,6]
 * 
 * Example 2:
 * Input: root = []
 * Output: []
 * 
 * Example 3:
 * Input: root = [0]
 * Output: [0]
 */

package al.leetcode.medium;

import ds.TreeNode;

public class problem_0114 {

    public void solution(TreeNode root) {  
        if (root != null) {      
            solution(root);
        }
    }

    public TreeNode flatten(TreeNode node) {
        if (node.getLeft() == null && node.getRight() == null) {
            return node;
        }
        TreeNode left = null;
        TreeNode right = null;
        if (node.getLeft() != null) {
            left = flatten(node.getLeft());
        }
        if (node.getRight() != null) {
            right = flatten(node.getRight());
        }
        if (left != null) {
            node.setLeft(null);
            node.setRight(left);
            TreeNode next = left;
            while (next.getRight() != null) {
                next = next.getRight();
            }
            next.setRight(right);
        }
        return node;
    }
    
}
