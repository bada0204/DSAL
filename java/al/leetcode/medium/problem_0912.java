/**
 * Given an array of integers nums, sort the array in ascending order and return it.
 * You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.
 */

package al.leetcode.medium;

import al.sort.MergeSort;

public class problem_0912 {

    public int[] solution(int[] nums) {
        return MergeSort.sort(nums);
    }
    
}
