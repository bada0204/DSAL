/**
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters.
 * The words in s will be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space.
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 * Example 1:
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 *
 * Example 2:
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 *
 * Example 3:
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 * Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
 */

package al.leetcode.medium;

public class problem_0151 {

    public String solution(String s) {
        s = s.trim();
        StringBuilder result = new StringBuilder();
        String[] split = s.split(" ");
        for (int i = split.length - 1; i >= 0; i--) {
            String word = split[i];
            if (word.length() > 0) {
                result.append(word).append(" ");
            }
        }
        return result.substring(0, result.length() - 1);
    }

}
