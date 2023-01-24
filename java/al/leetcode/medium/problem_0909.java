/**
 * You are given an n x n integer matrix board where the cells are labeled from 1 to n^2 in a Boustrophedon style 
 * starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.
 * 
 * You start on square 1 of the board. In each move, starting from square curr, do the following:
 * 1. Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n^2)].
 * 2. This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations, regardless of the size of the board.
 * 3. If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
 * 4. The game ends when you reach the square n^2.
 * 
 * A board square on row r and column c has a snake or ladder if board[r][c] != -1. 
 * The destination of that snake or ladder is board[r][c]. 
 * Squares 1 and n^2 do not have a snake or ladder.
 * 
 * Note that you only take a snake or ladder at most once per move. 
 * If the destination to a snake or ladder is the start of another snake or ladder, you do not follow the subsequent snake or ladder.
 * 
 * For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2. 
 * You follow the ladder to square 3, but do not follow the subsequent ladder to 4.
 * Return the least number of moves required to reach the square n^2. If it is not possible to reach the square, return -1.
 * 
 * Example:
 * Input: board = 
 * [[-1,-1,-1,-1,-1,-1],
 *  [-1,-1,-1,-1,-1,-1],
 *  [-1,-1,-1,-1,-1,-1],
 *  [-1,35,-1,-1,13,-1],
 *  [-1,-1,-1,-1,-1,-1],
 *  [-1,15,-1,-1,-1,-1]]
 * Output: 4
 * Explanation: 
 * In the beginning, you start at square 1 (at row 5, column 0).
 * You decide to move to square 2 and must take the ladder to square 15.
 * You then decide to move to square 17 and must take the snake to square 13.
 * You then decide to move to square 14 and must take the ladder to square 35.
 * You then decide to move to square 36, ending the game.
 * This is the lowest possible number of moves to reach the last square, so return 4.
 */

package al.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class problem_0909 {

    public int solution(int[][] board) {
        int n = board.length;
        int[] move = new int[n * n + 1];
        Arrays.fill(move, -1);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        move[1] = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int curr = queue.poll();
                for (int i = 1; i <= 6 && curr + i <= n * n; i++) {
                    int next = curr + i;
                    int[] nextLoc = getLocation(next, n);
                    if (board[nextLoc[0]][nextLoc[1]] > 0) {
                        next = board[nextLoc[0]][nextLoc[1]];
                    }
                    if (move[next] < 0) {
                        queue.offer(next);
                        move[next] = move[curr] + 1;
                    }
                }
                size--;
            }
        }
        return move[n * n];
    }

    public int[] getLocation(int curr, int n) {
        int row = (curr - 1) / n;
        int col = (curr - 1) % n;
        int i = (n - 1) - row;
        int j = (row % 2 == 0) ? col : (n - 1) - col;
        return new int[] {i, j};
    }
    
}
