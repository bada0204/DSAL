/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * 
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * 
 * Note: A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */

package al.leetcode.medium;

public class problem_0036 {

    public boolean solution(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int[] hCheck = new int[9];
            int[] vCheck = new int[9];
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    int hNum = board[i][j] - '1';
                    if (hCheck[hNum] > 0) {
                        return false;
                    } else {
                        hCheck[hNum]++;
                    }
                }
                if (board[j][i] != '.') {
                    int vNum = board[j][i] - '1';
                    if (vCheck[vNum] > 0) {
                        return false;
                    } else {
                        vCheck[vNum]++;
                    }
                }
            }
        }
        for (int n = 0; n < 3; n++) {
           for (int m = 0; m < 3; m++) {
               int[] check = new int[9];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[n * 3 + i][m * 3 + j] == '.') {
                            continue;
                        }
                        int num = board[n * 3 + i][m * 3 + j] - '1';
                        if (check[num] > 0) {
                            return false;
                        } else {
                            check[num]++;
                        }
                    }
                }
            }
        }
        return true;
    }

}