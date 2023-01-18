/**
 * Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
 * A circular array means the end of the array connects to the beginning of the array. 
 * Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].
 * A subarray may only include each element of the fixed buffer nums at most once. 
 * Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.
 * 
 * Example 1:
 * Input: nums = [1,-2,3,-2]
 * Output: 3
 * Explanation: Subarray [3] has maximum sum 3.
 * 
 * Example 2:
 * Input: nums = [5,-3,5]
 * Output: 10
 * Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
 * 
 * Example 3:
 * Input: nums = [-3,-2,-3]
 * Output: -2
 * Explanation: Subarray [-2] has maximum sum -2.
 */

package al.leetcode.medium;

public class problem_0918 {
    
    public int solution(int[] nums) {
        int[] maxReverse = new int[nums.length];
        int max = nums[nums.length - 1];
        maxReverse[nums.length - 1] = max;
        int sum = max;
        for (int i = nums.length - 2; i >= 0; i--) {
            sum += nums[i];
            maxReverse[i] = Math.max(sum, maxReverse[i + 1]);
        }
        int currentMax = nums[0];
        int prefixSum = 0;
        int circularMax = nums[0];
        max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(currentMax, 0) + nums[i];
            max = Math.max(max, currentMax);
            prefixSum += nums[i - 1];
            circularMax = Math.max(circularMax, prefixSum + maxReverse[i]);
        }
        return Math.max(max, circularMax);
    }

}
