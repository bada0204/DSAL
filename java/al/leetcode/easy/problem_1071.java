/**
 * For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 * 
 * Example 1:
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * 
 * Example 2:
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * 
 * Example 3:
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 */

package al.leetcode.easy;

public class problem_1071 {

    public String solution(String str1, String str2) {
        String L = "";
        String S = "";
        if (str1.length() > str2.length()) {
            L = str1;
            S = str2;
        } else {
            L = str2;
            S = str1;
        }
        int end = S.length();
        while (end > 0) {
            int l = L.length();
            int s = S.length();
            String divisor = S.substring(0, end);
            // it is divisible by number
            if (l % end == 0 && s % end == 0 && isDivisible(L, divisor) && isDivisible(S, divisor)) {
                return divisor;
            }
            end--;
        }
        return "";
    }

    public boolean isDivisible(String s, String t) {
        int d = t.length();
        if (d == s.length()) {
            return s.equals(t);
        }
        for (int i = 0; i <= s.length() - d; i += d) {
            if (!s.substring(i, i + d).equals(t)) {
                return false;
            }
        }
        return true;
    }
    
}
