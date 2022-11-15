/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

package al.leetcode.medium;

public class problem_0003 {

    public int solution(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] LS = new int[s.length()];
        LS[0] = 0;
        for (int i = 1; i < LS.length; i++) {
            LS[i] = LS[i - 1];
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    LS[i] = Math.max(LS[i], j + 1);
                    break;
                }
            }
        }
        int max = -1;
        for (int i = 0; i < LS.length; i++) {
            max = Math.max(max, i - LS[i] + 1);
        }
        return max;
    }

}
