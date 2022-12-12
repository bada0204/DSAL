/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * 
 * Example:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */

package al.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class problem_0049 {

    public List<List<String>> solution(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] count = new char[26];
            for (char c : strs[i].toCharArray()) {
                count[c - 'a']++;
            }
            String key = String.valueOf(count);
            strMap.putIfAbsent(key, new ArrayList<>());
            strMap.get(key).add(strs[i]);
        }
        return new ArrayList<>(strMap.values());
    }
    
}
