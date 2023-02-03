/**
 * The Tribonacci sequence Tn is defined as follows: 
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 * 
 * Given n, return the value of Tn.
 * 
 * Example 1:
 * Input: n = 4
 * Output: 4
 * Explanation:
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 
 * Example 2:
 * Input: n = 25
 * Output: 1389537
 */

package al.leetcode.easy;

public class problem_1137 {

    public int solution(int n) {
        int[] tribonacci = new int[n + 1];
        if (n >= 1) {
            tribonacci[1] = 1;
        }
        if (n >= 2) {
            tribonacci[2] = 1;
        }
        for (int i = 3; i < tribonacci.length; i++) {
            tribonacci[i] = tribonacci[i - 1] + tribonacci[i - 2] + tribonacci[i - 3];
        }
        return tribonacci[n];
    }
    
}
