/**
 * Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. 
 * Return the answer in any order.
 * 
 * Example 1:
 * Input: n = 3
 * Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * 
 * Example 2:
 * Input: n = 1
 * Output: [[1]]
 */

package al.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import ds.TreeNode;

public class problem_0095 {

    public List<TreeNode> solution(int n) {
        return solution(1, n);
    }

    public List<TreeNode> solution(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if (start > end) {
            trees.add(null);
        } else {
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftTrees = solution(start, i - 1);
                List<TreeNode> rightTrees = solution(i + 1, end);
                
                for (int j = 0; j < leftTrees.size(); j++) {
                    for (int k = 0; k < rightTrees.size(); k++) {
                        TreeNode root = new TreeNode(i);
                        root.setLeft(leftTrees.get(j));
                        root.setRight(rightTrees.get(k));
                        trees.add(root);
                    }
                }
            }
        }
        return trees;
    }
    
}
