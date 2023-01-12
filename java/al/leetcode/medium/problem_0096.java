/**
 * Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
 * 
 * Example 1:
 * Input: n = 3
 * Output: 5
 * 
 * Example 2:
 * Input: n = 1
 * Output: 1
 */

package al.leetcode.medium;

public class problem_0096 {
    
    public int solution(int n) {
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                int left = nums[j];
                int right = nums[i - j - 1];
                if (left <= 1 || right <= 1) {
                    nums[i] += Math.max(left, right);
                } else {
                    nums[i] += (left * right);
                }
            }
        }
        return nums[n];
    }

}
