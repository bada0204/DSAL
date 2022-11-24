/**
 * Given a binary tree, determine if it is height-balanced.
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 *
 * Example 2:
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 *
 * Example 3:
 * Input: root = []
 * Output: true
 */

package al.leetcode.easy;

import ds.TreeNode;

public class problem_0110 {

    public boolean solution(TreeNode root) {
        return depthBetweenLeftAndRight(root) >= 0;
    }

    public int depthBetweenLeftAndRight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depthBetweenLeftAndRight(root.getLeft());
        int right = depthBetweenLeftAndRight(root.getRight());
        if (left < 0 || right < 0) {
            return -1;
        }
        left += 1;
        right += 1;
        if (-1 <= left - right && left - right <= 1) {
            return Math.max(left, right);
        } else {
            return -1;
        }
    }

}
