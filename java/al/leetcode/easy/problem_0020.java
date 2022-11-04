/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "(]"
 * Output: false
 *
 * Constraints:
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */

package al.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class problem_0020 {

    public boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            char open;
            try {
                switch(c) {
                    case '(':
                    case '{':
                    case '[':
                        stack.push(c);
                        break;
                    case ')':
                        open = stack.pop();
                        if (open != '(')
                            return false;
                        break;
                    case '}':
                        open = stack.pop();
                        if (open != '{')
                            return false;
                        break;
                    case ']':
                        open = stack.pop();
                        if (open != '[')
                            return false;
                        break;
                    default:
                        return false;
                }
            } catch (Exception ex) {
                return false;
            }
        }
        return stack.isEmpty();

}
