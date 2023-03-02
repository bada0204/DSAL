/**
 * Given the root of a binary tree, return all duplicate subtrees.
 * For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 * Two trees are duplicate if they have the same structure with the same node values.
 * 
 * Example 1:
 * Input: root = [1,2,3,4,null,2,4,null,null,4]
 * Output: [[2,4],[4]]
 * 
 * Example 2:
 * Input: root = [2,1,1]
 * Output: [[1]]
 * 
 * Example 3:
 * Input: root = [2,2,2,3,null,3,null]
 * Output: [[2,3],[3]]
 */

package al.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ds.TreeNode;

public class problem_0652 {

    public List<TreeNode> solution(TreeNode root) {
        List<TreeNode> duplicates = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Set<String> included = new HashSet<>();
        solution(root, duplicates, visited, included);
        return duplicates;
    }

    public String solution(TreeNode root, List<TreeNode> duplicates, Set<String> visited, Set<String> included) {
        if (root == null) {
            return "null";
        }
        String left = solution(root.getLeft(), duplicates, visited, included);
        String right = solution(root.getRight(), duplicates, visited, included);
        StringBuilder sb = new StringBuilder();
        sb.append(root.getVal()).append(",").append(left).append(",").append(right);
        String treeString = sb.toString();
        if (!visited.contains(treeString)) {
            visited.add(treeString);
        } else if (visited.contains(treeString) && !included.contains(treeString)) {
            duplicates.add(root);
            included.add(treeString);
        }
        return treeString;
    }
    
}
