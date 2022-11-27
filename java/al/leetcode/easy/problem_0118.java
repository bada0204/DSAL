/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * 
 * Example 1:
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 */

package al.leetcode.easy;

public class problem_0118 {

	public List<List<Integer>> solution(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        if (numRows >= 1) {
            results.add(Arrays.asList(1));
            numRows--;
        }
        if (numRows >= 1) {
            results.add(Arrays.asList(1, 1));
            numRows--;
        }
        for (int i = 2; i < numRows + 2; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    List<Integer> before = results.get(i - 1);
                    row.add(before.get(j - 1) + before.get(j));
                }
            }
            results.add(row);
        }
        return results;
    }

}