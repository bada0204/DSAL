/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * 
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 */

package al.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class problem_0078 {

    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        solution(new ArrayList<>(), subsets, nums, 0);
        return subsets;
    }

    public void solution(List<Integer> subset, List<List<Integer>> subsets, int[] nums, int start) {
        subsets.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            solution(subset, subsets, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
    
}
