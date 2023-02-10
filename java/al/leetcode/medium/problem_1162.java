/**
 * Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, 
 * find a water cell such that its distance to the nearest land cell is maximized, and return the distance. 
 * If no land or water exists in the grid, return -1.
 * 
 * The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 * 
 * Example 1:
 * Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
 * Output: 2
 * Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.
 * 
 * Example 2:
 * Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
 * Output: 4
 * Explanation: The cell (2, 2) is as far as possible from all the land with distance 4.
 */

package al.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Queue;

import utils.ArrayUtils;

public class problem_1162 {

    public int solution(int[][] grid) {
        int n = grid.length;
        int distance = -1;
        int[][] visited = new int[n][n];
        int[][] moves = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> lands = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = 1;
                    lands.offer(new int[] {i, j});
                }
            }
        }
        while (!lands.isEmpty()) {
            int size = lands.size();
            while (size > 0) {
                int[] land = lands.poll();
                for (int[] move : moves) {
                    int[] next = new int[] {land[0] + move[0], land[1] + move[1]};
                    if (ArrayUtils.inRange(next, 0, n) && !alreadyVisited(visited, next)) {
                        visited[next[0]][next[1]] = 1;
                        lands.offer(next);
                    }
                }
                size--;
            }
            distance++;
        }
        return distance == 0 ? -1 : distance;
    }

    public boolean alreadyVisited(int[][] visited, int[] move) {
        return visited[move[0]][move[1]] == 1;
    }
    
}
