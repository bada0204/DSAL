/**
 * Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).
 * 
 * Example 1:
 * Input: low = 3, high = 7
 * Output: 3
 * Explanation: The odd numbers between 3 and 7 are [3,5,7].
 * 
 * Example 2:
 * Input: low = 8, high = 10
 * Output: 1
 * Explanation: The odd numbers between 8 and 10 are [9].
 */

package al.leetcode.easy;

public class problem_1523 {

    public int solution(int low, int high) {
        int count = (high - low) / 2;
        if (low % 2 == 1 || high % 2 == 1) {
            count++;
        }
        return count;
    }
    
}