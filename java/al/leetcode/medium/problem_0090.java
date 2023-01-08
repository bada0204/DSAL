/**
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * 
 * Example 1:
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 */

package al.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class problem_0090 {
   
    public List<List<Integer>> solution(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        solution(subsets, new ArrayList<>(), nums, 0);
        return subsets;
    }

    public void solution(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int start) {
        subsets.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            solution(subsets, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

}
