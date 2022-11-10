/**
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
 * The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 * Increment the large integer by one and return the resulting array of digits.
 *
 * Example:
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 */

package al.leetcode.easy;

public class problem_0066 {

    public int[] solution(int[] digits) {
        int add = 1;
        for (int i = digits.length - 1; i >= 0 && add > 0; i--) {
            digits[i] += add;
            add = digits[i] / 10;
            digits[i] %= 10;
        }
        if (digits[0] == 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }

}
