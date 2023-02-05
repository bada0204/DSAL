/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. 
 * You may return the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * 
 * Example 1
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * 
 * Example 2:
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

package al.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class problem_0438 {

    public List<Integer> solution(String s, String p) {
        int n = p.length() - 1;
        int[] occurrences = new int[26];
        for (char c : p.toCharArray()) {
            occurrences[c - 'a']++;
        }
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            occurrences[c - 'a']--;
            if (i >= n) {
                boolean found = true;
                for (int k = 0; k < 26; k++) {
                    if (occurrences[k] != 0) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    positions.add(i - n);
                }
                char first = s.charAt(i - n);
                occurrences[first - 'a']++;
            }
        }
        return positions;
    }
    
}
