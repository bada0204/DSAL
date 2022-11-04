/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */

package al.leetcode.easy;

public class problem_0014 {

    public String solution(String[] strs) {
        StringBuilder result = new StringBuilder();
        int i = 1;
        int prefixIndex = 0;
        if (strs[0].length() <= 0) {
            return result.toString();
        }
        if (strs.length <= 1) {
            return strs[0];
        }
        char prefix = strs[0].charAt(0);
        while (true) {
            String currentString = strs[i];
            try {
                if (i == 0) {
                    prefixIndex++;
                    result.append(prefix);
                    prefix = currentString.charAt(prefixIndex);
                } else {
                    char currentPrefix = currentString.charAt(prefixIndex);
                    if (prefix != currentPrefix) {
                        break;
                    }
                }
            } catch (Exception ex) {
                return result.toString();
            }
            i = (i + 1) % strs.length;
        }
        return result.toString();
    }

}
