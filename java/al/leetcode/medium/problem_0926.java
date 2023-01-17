/**
 * A binary string is monotone increasing if it consists of some number of 0's (possibly none), followed by some number of 1's (also possibly none).
 * You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.
 * Return the minimum number of flips to make s monotone increasing.
 * 
 * Example 1:
 * Input: s = "00110"
 * Output: 1
 * Explanation: We flip the last digit to get 00111.
 * 
 * Example 2:
 * Input: s = "010110"
 * Output: 2
 * Explanation: We flip to get 011111, or alternatively 000111.
 * 
 * Example 3:
 * Input: s = "00011000"
 * Output: 2
 * Explanation: We flip to get 00000000.
 */

package al.leetcode.medium;

public class problem_0926 {

    public int solution(String s) {
        int[] flips = new int[s.length() + 1];
        int ones = 0;
        for (int i = 1; i <= s.length(); i++) {
            char c = s.charAt(i - 1);
            if (c == '1') {
                flips[i] = flips[i - 1];
                ones++;
            } else {
                flips[i] = Math.min(ones, flips[i - 1] + 1);
            }
        }
        return flips[s.length()];
    }
    
}
