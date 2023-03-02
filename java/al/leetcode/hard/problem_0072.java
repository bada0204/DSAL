/**
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 * 
 * You have the following three operations permitted on a word:
 * 1. Insert a character
 * 2. Delete a character
 * 3. Replace a character
 * 
 * Example 1:
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation: 
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * 
 * Example 2:
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation: 
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 */

package al.leetcode.hard;

public class problem_0072 {

    public int solution(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] distance = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            distance[i][0] = distance[i - 1][0] + 1;
        }
        for (int i = 1; i <= n; i++) {
            distance[0][i] = distance[0][i - 1] + 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c1 = word1.charAt(i - 1);
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    distance[i][j] = Math.min(Math.min(distance[i - 1][j], distance[i][j - 1]), distance[i - 1][j - 1]) + 1;
                }
            }
        }
        return distance[m][n];
    }
    
}
