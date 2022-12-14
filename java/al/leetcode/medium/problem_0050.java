/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 * 
 * Example 1:
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * 
 * Example 2:
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * 
 * Example 3:
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */

 package al.leetcode.medium;

 public class problem_0050 {

    public double solution(double x, int n) {
        if (x == 1 || n == 0) {
            return 1;
        } else if(n < 0){
           return 1/x * solution(1/x, -(n + 1));
        } else if (n % 2 == 0) {
            return solution(x * x, n / 2);
        } else {
            return solution(x * x, n / 2) * x;
        }
    }

 }