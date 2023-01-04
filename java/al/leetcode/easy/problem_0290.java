/**
 * Given a pattern and a string s, find if s follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 * 
 * Example 1:
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 * 
 * Example 2:
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 * 
 * Example 3:
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 * Output: false
 */

package al.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class problem_0290 {

    public boolean solution(String pattern, String s) {
        String[] split = s.split(" ");
        Map<Character, String> patternMap = new HashMap<>();
        Set<String> wordSet = new HashSet<>();
        if (pattern.length() != split.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = split[i];
            if (!patternMap.containsKey(c)) {
                if (!wordSet.contains(word)) {
                    patternMap.put(c, word);
                    wordSet.add(word);
                } else {
                    return false;
                }
            } else if (!word.equals(patternMap.get(c))) {
                return false;
            }
        }
        return true;
    }
    
}
