/**
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 * 
 * Example 1:
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 * 
 * Example 2:
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 */

package al.leetcode.medium;

import ds.TreeNode;

public class problem_0106 {

    private int postorderIndex = 0; 

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;
        return solution(inorder, 0, inorder.length - 1, postorder);
    }

    public TreeNode solution(int[] inorder, int min, int max, int[] postorder) {
        int inorderIndex = -1;
        for (int i = max; i >= min; i--) {
            if (postorder[postorderIndex] == inorder[i]) {
                inorderIndex = i;
                break;
            }
        }
        if (inorderIndex < 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorderIndex--]);
        if (inorderIndex <= max) {
            root.setRight(solution(inorder, inorderIndex + 1, max, postorder));
        }
        if (min <= inorderIndex) {
            root.setLeft(solution(inorder, min, inorderIndex - 1, postorder));
        }   
        return root;
    }
    
}
