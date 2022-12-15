/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 * 
 * Example:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */

package al.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class problem_0217 {

    public boolean solution(int[] nums) {
        Set<Integer> dup = new HashSet<>();
        for (int n : nums) {
            if (dup.contains(n)) {
                return true;
            }
            dup.add(n);
        }
        return false;
    }
    
}
