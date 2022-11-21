/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 *
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 *
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */

package al.leetcode.medium;

public class problem_0006 {

    public String solution(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int currentRow = 0;
        int endProcessSpace = (numRows - 1) * 2;
        int processSpace = endProcessSpace;
        StringBuilder result = new StringBuilder();
        while (processSpace > 0) {
            int currentIndex = currentRow;
            int middleProcessSpace = endProcessSpace - processSpace;
            int counter = 0;
            while (currentIndex < s.length()) {
                result.append(s.charAt(currentIndex));
                if (middleProcessSpace > 0 && processSpace != middleProcessSpace) {
                    if (counter % 2 == 0) {
                        currentIndex += processSpace;
                    } else {
                        currentIndex += middleProcessSpace;
                    }
                } else {
                    currentIndex += processSpace;
                }
                counter++;
            }
            processSpace -= 2;
            currentRow++;
        }
        int currentIndex = currentRow;
        while (currentIndex < s.length()) {
            result.append(s.charAt(currentIndex));
            currentIndex += endProcessSpace;
        }
        return result.toString();
    }

}
