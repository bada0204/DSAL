/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. 
 * No two characters may map to the same character, but a character may map to itself.
 * 
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 * 
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 * 
 * Example 3: 
 * Input: s = "paper", t = "title"
 * Output: true
 */

package al.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class problem_0205 {

    public boolean solution(String s, String t) {
        Map<Character, Character> charTable = new HashMap<>();
        Set<Character> uniqueCharSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (!charTable.containsKey(sc) && uniqueCharSet.contains(tc)) {
                return false;
            }
            charTable.putIfAbsent(sc, tc);
            if (!uniqueCharSet.contains(tc)) {
                uniqueCharSet.add(tc);
            }
        }
        StringBuilder u = new StringBuilder();
        for (char c : s.toCharArray()) {
            u.append(charTable.get(c));
        }
        return u.toString().equals(t);
    }
    
}
