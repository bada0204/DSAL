/**
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 * 
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 * 
 * Example 2:
 * Input: root = []
 * Output: []
 * 
 * Example 3:
 * Input: root = [1]
 * Output: [1]
 */

package al.leetcode.easy;

import java.util.List;
import java.util.ArrayList;

import ds.TreeNode;

public class problem_0144 {

    public List<Integer> solution(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        solution(root, result);
        return result;
    }

    public void solution(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.getVal());
        solution(root.getLeft(), result);
        solution(root.getRight(), result);
    }

}