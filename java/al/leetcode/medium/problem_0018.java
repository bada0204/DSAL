/**
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * 1. 0 <= a, b, c, d < n
 * 2. a, b, c, and d are distinct.
 * 3. nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 * 
 * Example 1:
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 
 * Example 2:
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 */

package al.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class problem_0018 {

	public List<List<Integer>> solution(int[] nums, int target) {
		List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                long newTarget = (long) target - nums[i] - nums[j];
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    long sum = (long) nums[start] + nums[end];
                    if (newTarget == sum) {
                        results.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        start++;
                        while (start < end && nums[start - 1] == nums[start]) {
                            start++;
                        }
                        end--;
                    } else if (newTarget < sum) {
                        end--;
                    } else {
                        start++;
                    }
                }
                while (j < nums.length - 2 && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            while (i < nums.length - 3 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return results;
	}

}