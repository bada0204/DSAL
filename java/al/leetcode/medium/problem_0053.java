/**
 * Given an integer array nums, find the subarray which has the largest sum and return its sum.
 * 
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 * 
 * Example 3:
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 */

package al.leetcode.medium;

public class problem_0053 {
    
    public int solution(int[] nums) {
        int[] C = new int[nums.length];
        C[0] = nums[0];
        for (int i = 1; i < C.length; i++) {
            C[i] = Math.max(C[i - 1] + nums[i], nums[i]);
        }
        int max = 0;
        for (int i = 0; i < C.length; i++) {
            if (C[i] > C[max]) {
                max = i;
            }
        }
        return C[max];
    }

}
