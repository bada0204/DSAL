/**
 * Given an array of points where points[i] = [x_i, y_i] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.
 * 
 * Example 1:
 * Input: points = [[1,1],[2,2],[3,3]]
 * Output: 3
 * 
 * Example 2:
 * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 */

package al.leetcode.hard;

public class problem_0149 {

    public int solution(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }

        int result = Integer.MIN_VALUE;
        
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                int count = 2;
                int[] p1 = points[i];
                int[] p2 = points[j];
                for (int k = j + 1; k < points.length; k++) {
                    int[] p3 = points[k];
                    if (((p2[1] - p1[1]) * (p3[0] - p2[0])) == ((p3[1] - p2[1]) * (p2[0] - p1[0]))) {
                        count++;
                    }
                }
                result = Math.max(count, result);
            }
        }

        return result;
    }
    
}
