/**
 * Given two binary strings a and b, return their sum as a binary string.
 *
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */

package al.leetcode.easy;

public class problem_0067 {

    public String solution(String a, String b) {
        int ai = a.length() - 1;
        int bi = b.length() - 1;
        int add = 0;
        StringBuilder result = new StringBuilder();
        while (ai >= 0 || bi >= 0) {
            int aint = 0;
            int bint = 0;
            if (ai >= 0) {
                aint = a.charAt(ai--) - '0';
            }
            if (bi >= 0) {
                bint = b.charAt(bi--) - '0';
            }
            int curr = aint + bint + add;
            result.insert(0, curr % 2);
            add = curr / 2;
        }
        if (add > 0) {
            result.insert(0, add);
        }
        return result.toString();
    }

}
