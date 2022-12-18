/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * 
 * Example 1:
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * 
 * Example 2:
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 */

package al.leetcode.medium;

public class problem_0064 {

    public int solution(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] sumGrid = new int[m][n];
        sumGrid[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            sumGrid[i][0] = sumGrid[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            sumGrid[0][i] = sumGrid[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sumGrid[i][j] = Math.min(grid[i][j] + sumGrid[i - 1][j], grid[i][j] + sumGrid[i][j - 1]);
            }
        }
        return sumGrid[m - 1][n - 1];
    }
    
}
