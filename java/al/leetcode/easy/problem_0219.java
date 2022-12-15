/**
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 * 
 * Example 1:
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * 
 * Example 2:
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */

package al.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class problem_0219 {

    public boolean solution(int[] nums, int k) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!numIndexMap.containsKey(nums[i])) {
                numIndexMap.put(nums[i], i);
            } else {
                int diff = i - numIndexMap.get(nums[i]);
                if (diff <= k) {
                    return true;
                } else {
                    numIndexMap.put(nums[i], i);
                }
            }
        }
        return false;
    }
    
}
