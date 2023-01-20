/**
 * Given an integer array nums, return all the different possible non-decreasing subsequences of the given array with at least two elements. 
 * You may return the answer in any order.
 * 
 * Example 1:
 * Input: nums = [4,6,7,7]
 * Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * 
 * Example 2:
 * Input: nums = [4,4,3,2,1]
 * Output: [[4,4]]
 */

package al.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class problem_0491 {

    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        solution(results, new ArrayList<>(), nums, 0, Integer.MIN_VALUE);
        return results;
    }

    public void solution(List<List<Integer>> results, List<Integer> subsequence, int[] nums, int start, int prev) {
        if (start == nums.length) {
            if (subsequence.size() > 1) {
                results.add(new ArrayList<>(subsequence));
            }
            return;
        }
        int curr = nums[start];
        if (prev <= curr) {
            subsequence.add(curr);
            solution(results, subsequence, nums, start + 1, curr);
            subsequence.remove(subsequence.size() - 1);
        }
        if (prev != curr) {
            solution(results, subsequence, nums, start + 1, prev);
        }
    }
    
}
