/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * 
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 */

package al.leetcode.medium;

import java.util.List;
import java.util.ArrayList;

public class problem_0022 {

    public List<String> solution(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        solution(result, current, 0, 0, n);
        return result;
    }

    public void solution(List<String> result, StringBuilder current, int open, int close, int n) {
        if (open + close == n * 2) {
            result.add(current.toString());
        }
        if (open < n) {
            current.append('(');
            solution(result, current, open + 1, close, n);
            current.deleteCharAt(current.length() - 1);
        } 
        if (close < open) {
            current.append(')');
            solution(result, current, open, close + 1, n);
            current.deleteCharAt(current.length() - 1);
        }
    }
    
}
