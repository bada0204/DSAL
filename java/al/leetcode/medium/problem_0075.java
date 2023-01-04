/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * You must solve this problem without using the library's sort function.
 * 
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * 
 * Example 2:
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 */

package al.leetcode.medium;

public class problem_0075 {
    
    public void solution(int[] nums) {
        int zero = 0;
        int two = nums.length - 1;
        int i = 0;
        while (i <= two) {
            int num = nums[i];
            if (num == 0) {
                if (i != zero) {
                    nums[i] = nums[zero];
                    nums[zero] = 0;
                }
                zero++;
                i++;
            } else if (num == 2) {
                nums[i] = nums[two];
                nums[two] = 2;
                two--;
            } else { 
                i++;
            }
        }
    }

}
