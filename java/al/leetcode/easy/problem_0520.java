/**
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * 1. All letters in this word are capitals, like "USA".
 * 2. All letters in this word are not capitals, like "leetcode".
 * 3. Only the first letter in this word is capital, like "Google".
 * 
 * Given a string word, return true if the usage of capitals in it is right.
 * 
 * Example 1:
 * Input: word = "USA"
 * Output: true
 * 
 * Example 2:
 * Input: word = "FlaG"
 * Output: false
 */

package al.leetcode.easy;

public class problem_0520 {

    public boolean solution(String word) {
        if (word.length() == 1) {
            return true;
        }
        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            if (0 <= c - 'A' && c - 'A' < 26) {
                char b = word.charAt(i - 1);
                if (0 > b - 'A' || b - 'A' >= 26) {
                    return false;
                }
            } else if (i != 1) {
                char b = word.charAt(i - 1);
                if (0 <= b - 'A' && b - 'A' < 26) {
                    return false;
                } 
            }
        }
        return true;
    }

}
