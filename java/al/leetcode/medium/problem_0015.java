/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation: 
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 */

package al.leetcode.medium;

import ds.TreeNode;

import java.util.*;

public class problem_0015 {
    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        Set<Integer> firstInteger = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (!firstInteger.contains(nums[i])) {
                firstInteger.add(nums[i]);
                int target = 0 - nums[i];
                int start = i + 1;
                int end = nums.length - 1;
                while (start < end) {
                    int sum = nums[start] + nums[end];
                    if (target == sum) {
                        results.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        int currStart = nums[start];
                        while (start < end && currStart == nums[start]) {
                            start++;
                        }
                    } else if (target > sum) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return results;
    }

}