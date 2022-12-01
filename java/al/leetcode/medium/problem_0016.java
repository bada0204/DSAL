/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * 
 * Example 1:
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * Example 2:
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 */

package al.leetcode.medium;

import java.util.Arrays;

public class problem_0016 {

	public int solution(int[] nums, int target) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            if (i == 0) {
                result = nums[i] + nums[start] + nums[end];
            }
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (target == sum) {
                    return sum;
                } else if (target > sum) {
                    start++;
                } else {
                    end--;
                }
                result = (Math.abs(target - result) > Math.abs(target - sum)) ? sum : result;
            }
        }
        return result;
    }

}