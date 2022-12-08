/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 */

package al.leetcode.medium;

public class problem_0034 {

    public int[] solution(int[] nums, int target) {
        int[] range = new int[] {-1, -1};
        int start = 0;
        int end = nums.length - 1;
        solution(nums, range, start, end, target);
        return range;
    }

    public void solution(int[] nums, int[] range, int start, int end, int target) {
        int mid = start + (end - start) / 2;
        if (start <= end) {
            if (nums[mid] == target) {
                if (range[0] < 0) {
                    range[0] = mid;
                }
                if (range[1] < 0) {
                    range[1] = mid;
                }
                if (range[0] > mid) {
                    range[0] = mid;
                } else if (range[1] < mid) {
                    range[1] = mid;
                }
                solution(nums, range, start, mid - 1, target);
                solution(nums, range, mid + 1, end, target);
            } else if (nums[mid] < target) {
                solution(nums, range, mid + 1, end, target);
            } else {
                solution(nums, range, start, mid - 1, target);
            }
        }
    }
    
}
