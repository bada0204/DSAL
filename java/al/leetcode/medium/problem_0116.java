/**
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. 
 * 
 * The binary tree has the following definition:
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * 
 * Example 1:
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 */

package al.leetcode.medium;

import ds.ExtendedTreeNode;

public class problem_0116 {

    public ExtendedTreeNode solution(ExtendedTreeNode root) {
        if (root == null || root.getLeft() == null || root.getRight() == null) {
            return root;
        }
        root.getLeft().setNext(root.getRight());
        if (root.getNext() != null) {
            root.getRight().setNext(root.getNext().getLeft());
        }
        solution(root.getLeft());
        solution(root.getRight());
        return root;
    }
    
}
