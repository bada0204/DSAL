package al.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Queue;

import ds.TreeNode;

public class problem_0958 {

    public boolean solution(TreeNode root) {
        boolean end = false;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode curr = queue.poll();
                if (end && (curr.getLeft() != null || curr.getRight() != null)) {
                    return false;
                }
                if (curr.getLeft() == null && curr.getRight() != null) {
                    return false;
                }
                if (curr.getLeft() != null) {
                    queue.offer(curr.getLeft());
                }
                if (curr.getRight() != null) {
                    queue.offer(curr.getRight());
                }
                if (curr.getLeft() == null || curr.getRight() == null) {
                    end = true;
                }
                size--;
            }
        }
        return true;
    }
    
}
