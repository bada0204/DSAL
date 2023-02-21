/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
 * 
 * Return the single element that appears only once.
 * 
 * Your solution must run in O(log n) time and O(1) space.
 * 
 * Example 1:
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * 
 * Example 2:
 * Input: nums = [3,3,7,7,10,11,11]
 * Output: 10
 */

package al.leetcode.medium;

public class problem_0540 {

    public int solution(int[] nums) {
        return solution(nums, 0, nums.length - 1);
    }

    public int solution(int[] nums, int start, int end) {
        if (start > end) {
            return start;
        }
        int mid = start + (end - start) / 2;
        if (mid - 1 >= start && nums[mid] == nums[mid - 1]) {
            if ((end - mid) % 2 == 0) {
                return solution(nums, start, mid - 2);
            } else {
                return solution(nums, mid + 1, end);
            }
        } else if (mid + 1 <= end && nums[mid] == nums[mid + 1]) {
            if ((end - (mid + 1)) % 2 == 0) {
                 return solution(nums, start, mid - 1);
            } else {
                 return solution(nums, mid + 2, end);
            }
        } else {
            return nums[mid];
        }
    }
    
}
