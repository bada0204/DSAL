/**
 * You are the manager of a basketball team. 
 * For the upcoming tournament, you want to choose the team with the highest overall score. 
 * The score of the team is the sum of scores of all the players in the team.
 * However, the basketball team is not allowed to have conflicts. 
 * A conflict exists if a younger player has a strictly higher score than an older player. 
 * A conflict does not occur between players of the same age.
 * 
 * Given two lists, scores and ages, where each scores[i] and ages[i] represents the score and age of the ith player, respectively, 
 * return the highest overall score of all possible basketball teams.
 * 
 * Example 1:
 * Input: scores = [1,3,5,10,15], ages = [1,2,3,4,5]
 * Output: 34
 * Explanation: You can choose all the players.
 * 
 * Example 2:
 * Input: scores = [4,5,6,5], ages = [2,1,2,1]
 * Output: 16
 * Explanation: It is best to choose the last 3 players. Notice that you are allowed to choose multiple people of the same age.
 * 
 * Example 3:
 * Input: scores = [1,2,3,5], ages = [8,9,10,1]
 * Output: 6
 * Explanation: It is best to choose the first 3 players. 
 */

package al.leetcode.medium;

import java.util.Arrays;

public class problem_1626 {

    public int solution(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] agesAndScores = new int[n][2];
        for (int i = 0; i < n; i++) {
            agesAndScores[i][0] = ages[i];
            agesAndScores[i][1] = scores[i];
        }
        Arrays.sort(agesAndScores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] bestScores = new int[n];
        bestScores[0] = agesAndScores[0][1];
        int bestScore = bestScores[0];
        for (int i = 1; i < n; i++) {
            bestScores[i] = agesAndScores[i][1];
            for (int j = i - 1; j >= 0; j--) {
                if (agesAndScores[i][1] >= agesAndScores[j][1]) {
                    bestScores[i] = Math.max(bestScores[i], bestScores[j] + agesAndScores[i][1]);
                }
            }
            bestScore = Math.max(bestScore, bestScores[i]);
        }
        return bestScore;
    }
    
}
