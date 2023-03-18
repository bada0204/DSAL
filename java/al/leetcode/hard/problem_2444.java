/**
 * You are given an integer array nums and two integers minK and maxK.
 * 
 * A fixed-bound subarray of nums is a subarray that satisfies the following conditions:
 * 1. The minimum value in the subarray is equal to minK.
 * 2. The maximum value in the subarray is equal to maxK.
 * 
 * Return the number of fixed-bound subarrays.
 * 
 * A subarray is a contiguous part of an array.
 * 
 * Example 1:
 * Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
 * Output: 2
 * Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].
 * 
 * Example 2:
 * Input: nums = [1,1,1,1], minK = 1, maxK = 1
 * Output: 10
 * Explanation: Every subarray of nums is a fixed-bound subarray. There are 10 possible subarrays.
 */

package al.leetcode.hard;

public class problem_2444 {

    public long solution(int[] nums, int minK, int maxK) {
        int start = -1;
        int min = -1;
        int max = -1;
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < minK || num > maxK) {
                start = i;
            }
            if (num == minK) {
                min = i;
            }
            if (num == maxK) {
                max = i;
            }
            count += Math.max(0L, Math.min(min, max) - start);
        }
        return count;
    }
    
}
