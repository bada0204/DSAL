/**
 * You are given a sorted unique integer array nums.
 * A range [a,b] is the set of all integers from a to b (inclusive).
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 * Each range [a,b] in the list should be output as:
 * 1. "a->b" if a != b
 * 2. "a" if a == b
 * 
 * Example 1:
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 
 * Example 2:
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 */

package al.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class problem_0228 {

    public List<String> solution(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums.length == 0){
            return ranges;
        }
        int left = nums[0];
        int right = left;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == right + 1) {
                right = nums[i];
            } else {
                StringBuilder strRange = new StringBuilder();
                if (left == right) {
                    strRange.append(left);
                } else {
                    strRange.append(left).append("->").append(right);
                }
                ranges.add(strRange.toString());
                left = nums[i];
                right = left;
            }
        }
        StringBuilder strRange = new StringBuilder();
        if (left == right) {
            strRange.append(left);
        } else {
            strRange.append(left).append("->").append(right);
        }
        ranges.add(strRange.toString());
        return ranges;
    }
    
}
