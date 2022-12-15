/**
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n^2 in spiral order.
 * 
 * Example:
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 */

package al.leetcode.medium;

public class problem_0059 {

    public int[][] solution(int n) {
        int[][] result = new int[n][n];
        int[] ul = new int[] {0, 0};
        int[] ur = new int[] {0, n - 1};
        int[] dl = new int[] {n - 1, 0};
        int[] dr = new int[] {n - 1, n - 1};
        int y = ul[0];
        int x = ul[1];
        for (int i = 1; i <= n * n; i++) {
            result[y][x] = i;
            if (y == ur[0] && x < ur[1]) {
                x++;
            } else if (y < dr[0] && x == dr[1]) {
                y++;
            } else if (y == dl[0] && x > dl[1]) {
                x--;
            } else {
                y--;
            }
            if (y == ul[0] && x == ul[1]) {
                ul[0]++;
                ul[1]++;
                ur[0]++;
                ur[1]--;
                dl[0]--;
                dl[1]++;
                dr[0]--;
                dr[1]--;
                y = ul[0];
                x = ul[1];
            }
        }
        return result;
    }
    
}
