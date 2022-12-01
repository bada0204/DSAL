/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * 
 * Example 1:
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * 
 * Example 2:
 * Input: rowIndex = 0
 * Output: [1]
 * 
 * Example 3:
 * Input: rowIndex = 1
 * Output: [1,1]
 */

package al.leetcode.easy;

import java.util.Arrays;
import java.util.List;

public class problem_0119 {

	public List<Integer> solution(int rowIndex) {
        Integer[] result = new Integer[rowIndex + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = 1;
        }
        int before = 1;
        int n = 2;
        for (int i = 1; i < rowIndex; i++) {
            for (int j = 1; j < n; j++) {
                int temp = result[j];
                result[j] = before + result[j];
                before = temp;
            }
            n++;
        }
        return Arrays.asList(result);
    }

}