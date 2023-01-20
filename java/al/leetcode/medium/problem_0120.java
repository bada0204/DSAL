/**
 * Given a triangle array, return the minimum path sum from top to bottom.
 * For each step, you may move to an adjacent number of the row below.
 * More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 * 
 * Example 1:
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 * 
 * Example 2:
 * Input: triangle = [[-10]]
 * Output: -10
 */

package al.leetcode.medium;

import java.util.List;

public class problem_0120 {
    
    public int solution(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int min;
                if (j == 0) {
                    min = triangle.get(i - 1).get(j);
                } else if (0 < j && j < triangle.get(i).size() - 1) {
                    min = Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1));
                } else {
                    min = triangle.get(i - 1).get(j - 1);
                }
                triangle.get(i).set(j, triangle.get(i).get(j) + min);
            }
        }
        int sum = triangle.get(triangle.size() - 1).get(0);
        for (int i = 1; i < triangle.get(triangle.size() - 1).size(); i++) {
            sum = Math.min(sum, triangle.get(triangle.size() - 1).get(i));
        }
        return sum;
    }

}
