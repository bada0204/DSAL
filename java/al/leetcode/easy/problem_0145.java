package al.leetcode.easy;

import java.util.List;
import java.util.ArrayList;

import ds.TreeNode;

public class problem_0145 {

    public List<Integer> solution(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        solution(root, result);
        return result;
    }

    public void solution(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        solution(root.getLeft(), result);
        solution(root.getRight(), result);
        result.add(root.getVal());
    }

}
