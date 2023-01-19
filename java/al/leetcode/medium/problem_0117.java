/**
 * Given a binary tree:
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
 * Input: root = [1,2,3,4,5,null,7]
 * Output: [1,#,2,3,#,4,5,7,#]
 */

package al.leetcode.medium;

import ds.ExtendedTreeNode;

public class problem_0117 {
    
    public ExtendedTreeNode solution(ExtendedTreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.getLeft() != null) {
            if (root.getRight() != null) {
                root.getLeft().setNext(root.getRight());
            } else {
                root.getLeft().setNext(findNext(root.getNext()));
            }
        }
        if (root.getRight() != null) {
            root.getRight().setNext(findNext(root.getNext()));
        }
        solution(root.getRight());
        solution(root.getLeft());
        return root;
    }

    public ExtendedTreeNode findNext(ExtendedTreeNode root) {
        ExtendedTreeNode next = null;
        while (root != null) {
            if (root.getLeft() != null) {
                next = root.getLeft();
                break;
            } else if (root.getRight() != null) {
                next = root.getRight();
                break;
            }
            root = root.getNext();
        }
        return next;
    }

}
