/**
 * Suppose LeetCode will start its IPO soon. 
 * In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. 
 * Since it has limited resources, it can only finish at most k distinct projects before the IPO. 
 * Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.
 * 
 * You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.
 * Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.
 * Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final maximized capital.
 * The answer is guaranteed to fit in a 32-bit signed integer.
 * 
 * Example 1:
 * Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
 * Output: 4
 * Explanation: Since your initial capital is 0, you can only start the project indexed 0.
 * After finishing it you will obtain profit 1 and your capital becomes 1.
 * With capital 1, you can either start the project indexed 1 or the project indexed 2.
 * Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
 * Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
 */

package al.leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;
import java.util.PriorityQueue;

public class problem_0502 {

    public int solution(int k, int w, int[] profits, int[] capital) {
        int[][] cp = new int[capital.length][2];
        for (int i = 0; i < capital.length; i++) {
            cp[i] = new int[] {capital[i], profits[i]};
        }
        Arrays.sort(cp, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                int c = Integer.compare(a[0], b[0]);
                if (c == 0) {
                    return Integer.compare(b[0], a[0]);
                }
                return c;
            }
        });
        PriorityQueue<Integer> currMaxProfits = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        while (k > 0) {
            while (i < cp.length && cp[i][0] <= w) {
                currMaxProfits.offer(cp[i][1]);
                i++;
            }
            if (!currMaxProfits.isEmpty()) {
                w += currMaxProfits.poll();
            }
            k--;
        }
        return w;
    }
    
}
