/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 * 
 * Example 1:
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 
 * Example 2:
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 */

package al.leetcode.medium;

import ds.TreeNode;

public class problem_0105 {

    private int preorderIndex = 0;

    public TreeNode solution(int[] preorder, int[] inorder) {
        return solution(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode solution(int[] preorder, int[] inorder, int min, int max) {
        if (preorderIndex >= preorder.length) {
            return null;
        }
        int inorderIndex = -1;
        for (int i = min; i <= max; i++) {
            if (preorder[preorderIndex] == inorder[i]) {
                inorderIndex = i;
                break;
            }
        }
        if (inorderIndex < 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderIndex++]);
        if (min <= inorderIndex) {
            root.setLeft(solution(preorder, inorder, min, inorderIndex - 1));
        }
        if (inorderIndex <= max) {
            root.setRight(solution(preorder, inorder, inorderIndex + 1, max));
        }   
        return root;
    }
    
}
