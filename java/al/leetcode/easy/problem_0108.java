package al.leetcode.easy;

import ds.TreeNode;

public class problem_0108 {

    public TreeNode solution(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.setLeft(solution(nums, start, mid - 1));
        root.setRight(solution(nums, mid + 1, end));
        return root;
    }

    public TreeNode solution(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        int val = nums[mid];
        TreeNode root = new TreeNode(val);
        root.setLeft(solution(nums, start, mid - 1));
        root.setRight(solution(nums, mid + 1, end));
        return root;
    }

}
