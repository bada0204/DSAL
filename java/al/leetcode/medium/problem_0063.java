/**
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). 
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 */

package al.leetcode.medium;

public class problem_0063 {

    public int solution(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] grid = new int[m][n];
        grid[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        if (grid[0][0] == 0) {
            return 0;
        }
        for (int i = 1; i < m; i++) {
            grid[i][0] = obstacleGrid[i][0] == 1 ? 0 : grid[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            grid[0][i] = obstacleGrid[0][i] == 1 ? 0 : grid[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = obstacleGrid[i][j] == 1 ? 0 : grid[i - 1][j] + grid[i][j - 1];
            }
        }
        return grid[m - 1][n - 1];
    }
    
}
