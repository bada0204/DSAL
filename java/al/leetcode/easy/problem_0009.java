/**
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 *
 * Example:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */

package al.leetcode.easy;

public class problem_0009 {

    public boolean solution(int x) {
        if (x < 0) {
            return false;
        }
        int temp = x;
        int reverse = 0;
        while (temp > 0) {
            reverse *= 10;
            reverse += temp % 10;
            temp /= 10;
        }
        return reverse == x;
    }
}
