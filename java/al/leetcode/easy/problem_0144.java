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