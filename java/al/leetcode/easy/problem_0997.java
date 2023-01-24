/**
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
 * 
 * If the town judge exists, then:
 * 1. The town judge trusts nobody.
 * 2. Everybody (except for the town judge) trusts the town judge.
 * 3. There is exactly one person that satisfies properties 1 and 2.
 * 
 * You are given an array trust where trust[i] = [a_i, b_i] representing that the person labeled a_i trusts the person labeled b_i.
 * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 * 
 * Example 1:
 * Input: n = 2, trust = [[1,2]]
 * Output: 2
 * 
 * Example 2:
 * Input: n = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * 
 * Example 3:
 * Input: n = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 */

package al.leetcode.easy;

public class problem_0997 {

    public int solution(int n, int[][] trust) {
        int[] count = new int[n];
        int[] trustMap = new int[n];
        for (int[] t : trust) {
            count[t[0] - 1]++;
            trustMap[t[1] - 1]++;
        }
        for (int i = 0; i < n; i++) {
            if (trustMap[i] == n - 1 && count[i] == 0) {
                return i + 1;
            }
        }
        return -1;
    }
    
}
