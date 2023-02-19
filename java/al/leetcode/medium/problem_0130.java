/**
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * 
 * Example 1:
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * Explanation: Notice that an 'O' should not be flipped if:
 * - It is on the border, or
 * - It is adjacent to an 'O' that should not be flipped.
 * The bottom 'O' is on the border, so it is not flipped.
 * The other three 'O' form a surrounded region, so they are flipped.
 * 
 * Example 2:
 * Input: board = [["X"]]
 * Output: [["X"]]
 */

package al.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class problem_0130 {

    public void solution(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] surrounded = new boolean[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                surrounded[i][j] = true;
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[] {i, 0});
            }
            if (board[i][n - 1] == 'O') {
                queue.offer(new int[] {i, n - 1});
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new int[] {0, i});
            }
            if (board[m - 1][i] == 'O') {
                queue.offer(new int[] {m - 1, i});
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] curr = queue.poll();
                if (!visited[curr[0]][curr[1]]) {
                    visited[curr[0]][curr[1]] = true;
                    surrounded[curr[0]][curr[1]] = false;
                    for (int[] dir : dirs) {
                        int[] next = new int[] {curr[0] + dir[0], curr[1] + dir[1]};
                        if (0 <= next[0] && next[0] < m && 0 <= next[1] && next[1] < n && board[next[0]][next[1]] == 'O') {
                            queue.offer(new int[] {next[0], next[1]});
                        }
                    }
                }
                size--;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (surrounded[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
}
