/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 * 
 * Example 1:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * 
 * Example 2:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * 
 * Example 3:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 */

package al.leetcode.medium;

public class problem_0079 {

    public boolean solution(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                char w = word.charAt(0);
                if (c == w) {
                    int[][] visited = new int[board.length][board[i].length];
                    if (solution(board, visited, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean solution(char[][] board, int[][] visited, int i, int j, String word, int index) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] == 1 || board[i][j] != word.charAt(index)) {
            return false;
        }
        if (visited[i][j] != 1 && board[i][j] == word.charAt(index) && index == word.length() - 1) {
            return true;
        }
        visited[i][j] = 1;
        if (solution(board, visited, i + 1, j, word, index + 1)) return true;
        if (solution(board, visited, i - 1, j, word, index + 1)) return true;
        if (solution(board, visited, i, j + 1, word, index + 1)) return true;
        if (solution(board, visited, i, j - 1, word, index + 1)) return true;
        visited[i][j] = 0;
        return false;
    }
    
}
