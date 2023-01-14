/**
 * You are given two strings of the same length s1 and s2 and a string baseStr.
 * We say s1[i] and s2[i] are equivalent characters.
 * For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' == 'd', and 'c' == 'e'.
 * Equivalent characters follow the usual rules of any equivalence relation:
 * 1. Reflexivity: 'a' == 'a'.
 * 2. Symmetry: 'a' == 'b' implies 'b' == 'a'.
 * 3. Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.
 * For example, given the equivalency information from s1 = "abc" and s2 = "cde", "acd" and "aab" are equivalent strings of baseStr = "eed", and "aab" is the lexicographically smallest equivalent string of baseStr.
 * Return the lexicographically smallest equivalent string of baseStr by using the equivalency information from s1 and s2.
 * 
 * Example 1:
 * Input: s1 = "parker", s2 = "morris", baseStr = "parser"
 * Output: "makkek"
 * Explanation: Based on the equivalency information in s1 and s2, we can group their characters as [m,p], [a,o], [k,r,s], [e,i].
 * The characters in each group are equivalent and sorted in lexicographical order.
 * So the answer is "makkek".
 * 
 * Example 2:
 * Input: s1 = "hello", s2 = "world", baseStr = "hold"
 * Output: "hdld"
 * Explanation: Based on the equivalency information in s1 and s2, we can group their characters as [h,w], [d,e,o], [l,r].
 * So only the second letter 'o' in baseStr is changed to 'd', the answer is "hdld".
 * 
 * Example 3:
 * Input: s1 = "leetcode", s2 = "programs", baseStr = "sourcecode"
 * Output: "aauaaaaada"
 * Explanation: We group the equivalent characters in s1 and s2 as [a,o,e,r,s,c], [l,p], [g,t] and [d,m], thus all letters in baseStr except 'u' and 'd' are transformed to 'a', the answer is "aauaaaaada".
 */

package al.leetcode.medium;

public class problem_1061 {

    public String solution(String s1, String s2, String baseStr) {
        int[] charGraph = new int[26];

        for (int i = 0; i < charGraph.length; i++) {
            charGraph[i] = i;
        }

        for (int i = 0; i < s1.length(); i++) {
            saveToCharGraph(charGraph, s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            char c = (char) ('a' + find(charGraph, baseStr.charAt(i) - 'a'));
            result.append(c);
        }
        return result.toString();
    }

    public int find(int[] charGraph, int c) {
        if (charGraph[c] == c) {
            return c;
        }
        charGraph[c] = find(charGraph, charGraph[c]);
        return charGraph[c];
    }

    public void saveToCharGraph(int[] charGraph, int c1, int c2) {
        c1 = find(charGraph, c1);
        c2 = find(charGraph, c2);

        if (c1 == c2) {
            return;
        }

        if (c1 < c2) {
            charGraph[c2] = c1;
        } else {
            charGraph[c1] = c2;
        }
    }
    
}
