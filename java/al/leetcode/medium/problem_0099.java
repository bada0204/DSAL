/**
 * You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake.
 * Recover the tree without changing its structure.
 * 
 * Example 1:
 * Input: root = [1,3,null,null,2]
 * Output: [3,1,null,null,2]
 * Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
 * 
 * Example 2:
 * Input: root = [3,1,4,null,null,2]
 * Output: [2,1,4,null,null,3]
 * Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 */

package al.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import ds.TreeNode;

public class problem_0099 {

    private TreeNode a = null;
    private TreeNode b = null;

    public void solution(TreeNode root) {
        List<TreeNode> inorderList = new ArrayList<>();
        solution(root, inorderList);
        int temp = a.getVal();
        a.setVal(b.getVal());
        b.setVal(temp);
    }

    public void solution(TreeNode root, List<TreeNode> inorderList) {
        if (root == null) {
            return;
        }
        solution(root.getLeft(), inorderList);
        inorderList.add(root);
        int n = inorderList.size();
        if (n > 1) {
            TreeNode first = inorderList.get(n - 2);
            TreeNode second = inorderList.get(n - 1);
            if (first.getVal() > second.getVal()) {
                if (a == null) {
                    a = first;
                }
                b = second;
            }
        }
        solution(root.getRight(), inorderList);
    }
    
}
