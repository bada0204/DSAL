/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 * Design an algorithm that has less than O(n^2) time complexity
 *
 * Example:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

package al.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class problem_0001 {

    public int[] solution(int[] nums, int target) {
        // create map to keep (value, index) pair
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // if we find the value in the map, return the index of the value and current index
            if (valueIndexMap.containsKey(nums[i])) {
                return new int[] {valueIndexMap.get(nums[i]), i};
            }
            // else we will put candidate value we want to find and index into map
            else {
                valueIndexMap.put(target - nums[i], i);
            }
        }
        return new int[] {-1, -1};
    }

}