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
 * Input: columnNumber = 1
 * Output: "A"
 * 
 * Example 2:
 * Input: columnNumber = 28
 * Output: "AB"
 *
 * Example 3:
 * Input: columnNumber = 701
 * Output: "ZY"
 */

package al.leetcode.easy;

public class problem_0168 {

    public String solution(int columnNumber) {
        StringBuilder column = new StringBuilder();
        solution(column, columnNumber - 1);
        return column.toString();
    }

    public void solution(StringBuilder column, int columnNumber) {
        if (columnNumber < 26) {
            char currentCol = (char) ('A' + columnNumber);
            column.insert(0, currentCol);
            return;
        }
        solution(column, columnNumber % 26);
        solution(column, (columnNumber / 26) - 1);
    }
    
}
