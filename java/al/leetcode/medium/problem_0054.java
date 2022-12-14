/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * 
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * Example 2:
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

package al.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class problem_0054 {

    public List<Integer> solution(int[][] matrix) {
        int[] ul = new int[] {0, 0};
        int[] ur = new int[] {0, matrix[0].length - 1};
        int[] dl = new int[] {matrix.length - 1, 0};
        int[] dr = new int[] {matrix.length - 1, matrix[matrix.length - 1].length - 1};
        List<Integer> result = new ArrayList<>();
        while (ul[1] < ur[1] && ul[0] < dl[0] && ur[0] < dr[0] && dl[1] < dr[1]) {
            int[] pointer = new int[] {ul[0], ul[1]};
            while (pointer[1] < ur[1]) {
                result.add(matrix[pointer[0]][pointer[1]]);
                pointer[1]++;
            }
            while (pointer[0] < dr[0]) {
                result.add(matrix[pointer[0]][pointer[1]]);
                pointer[0]++;
            }
            while (pointer[1] > dl[1]) {
                result.add(matrix[pointer[0]][pointer[1]]);
                pointer[1]--;
            }
            while (pointer[0] > ul[0]) {
                result.add(matrix[pointer[0]][pointer[1]]);
                pointer[0]--;
            }
            ul[0]++;
            ul[1]++;
            ur[0]++;
            ur[1]--;
            dl[0]--;
            dl[1]++;
            dr[0]--;
            dr[1]--;
        }

        if (ul[0] == dl[0] && ur[1] == dr[1]) {
            int[] pointer = new int[] {ul[0], ul[1]};
            while (pointer[1] <= ur[1]) {
                result.add(matrix[pointer[0]][pointer[1]]);
                pointer[1]++;
            }
        } else if (ul[1] == ur[1] && dl[0] == dr[0]) {
            int[] pointer = new int[] {ul[0], ul[1]};
            while (pointer[0] <= dr[0]) {
                result.add(matrix[pointer[0]][pointer[1]]);
                pointer[0]++;
            }
        }
        return result;
    }
    
}
