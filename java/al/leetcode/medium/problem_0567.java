/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 * 
 * Example 1:
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * 
 * Example 2:
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 */

package al.leetcode.medium;

public class problem_0567 {

    public boolean solution(String s1, String s2) {
        int n = s1.length() - 1;
        int[] occurrences = new int[26];
        for (char c : s1.toCharArray()) {
            occurrences[c - 'a']++;
        }
        for (int i = n; i < s2.length(); i++) {
            boolean found = true;
            int[] currentOccurrences = new int[26];
            for (int j = i - n; j <= i; j++) {
                char c = s2.charAt(j);
                currentOccurrences[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (occurrences[j] != currentOccurrences[j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return true;
            }
        }
        return false;
    }
    
}
