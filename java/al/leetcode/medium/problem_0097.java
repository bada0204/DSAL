/**
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 * An interleaving of two strings s and t is a configuration where s and t are divided into n and m substrings respectively, such that:
 * 1. s = s1 + s2 + ... + sn
 * 2. t = t1 + t2 + ... + tm
 * 3. |n - m| <= 1
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * Note: a + b is the concatenation of strings a and b.
 * 
 * Example 1:
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Explanation: One way to obtain s3 is:
 * Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
 * Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
 * Since s3 can be obtained by interleaving s1 and s2, we return true.
 * 
 * Example 2:
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 * Explanation: Notice how it is impossible to interleave s2 with any other string to obtain s3.
 * 
 * Example 3:
 * Input: s1 = "", s2 = "", s3 = ""
 * Output: true
 */

package al.leetcode.medium;

public class problem_0097 {

    public boolean solution(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        } else if (s1.length() == 0 || s2.length() == 0) {
            return s1.equals(s3) || s2.equals(s3);
        } else {
            boolean[][] matrix = new boolean[s1.length() + 1][s2.length() + 1];
            matrix[0][0] = true;
            for (int i = 1; i < matrix.length; i++) {
                matrix[i][0] = matrix[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
            }
            for (int i = 1; i < matrix[0].length; i++) {
                matrix[0][i] = matrix[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
            }
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[i].length; j++) {
                    char expected = s3.charAt(i + j - 1);
                    matrix[i][j] = (matrix[i - 1][j] && expected == s1.charAt(i - 1)) || (matrix[i][j - 1] && expected == s2.charAt(j - 1));
                }
            }
            return matrix[s1.length()][s2.length()];
        }
    }
    
}
