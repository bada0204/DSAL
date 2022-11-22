/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 * Example 1:
 * Input: x = 123
 * Output: 321
 *
 * Example 2:
 * Input: x = -123
 * Output: -321
 *
 * Example 3:
 * Input: x = 120
 * Output: 21
 */

package al.leetcode.medium;

public class problem_0007 {

    public int solution(int x) {
        int result = 0;
        int temp = x;
        while (temp != 0) {
            result *= 10;
            result += temp % 10;
            if (temp % 10 != result % 10)
                return 0;
            temp /= 10;
        }
        return result;
    }

}
