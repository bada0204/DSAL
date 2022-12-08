/**
 * Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.
 * 
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28 
 * ...
 * 
 * Example 1:
 * Input: columnTitle = "A"
 * Output: 1
 * 
 * Example 2:
 * Input: columnTitle = "AB"
 * Output: 28
 * 
 * Example 3:
 * Input: columnTitle = "ZY"
 * Output: 701
 */

package al.leetcode.easy;

public class problem_0171 {

    public int solution(String columnTitle) {
        int number = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            char curr = columnTitle.charAt(i);
            int n = (curr - 'A') + 1;
            int m = columnTitle.length() - 1 - i;
            number += (Math.pow(26, m) * n);
        }
        return number;
    }
    
}
