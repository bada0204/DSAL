/**
 * There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
 * Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). 
 * For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
 * Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
 * You must decrease the overall operation steps as much as possible.
 * 
 * Example 1:
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * 
 * Example 2:
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 */

package al.leetcode.medium;

public class problem_0081 {

    public boolean solution(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return true;
            } else if (nums[end] < nums[mid]) {
                if (target > nums[mid] || target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (nums[mid] < nums[start]) {
                if (target < nums[mid] || target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                while (start < end && nums[start] == nums[start + 1]) {
                    start++;
                }
                while (start < end && nums[end - 1] == nums[end]) {
                    end--;
                }
                mid = start + (end - start) / 2;
                if (target == nums[mid]) {
                    return true;
                }
                else if (target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return start < nums.length && nums[start] == target;
    }
    
}
