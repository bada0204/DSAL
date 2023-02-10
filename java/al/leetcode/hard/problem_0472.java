/**
 * Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.
 * 
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter words (not necesssarily distinct) in the given array.
 * 
 * Example 1:
 * Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
 * "dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
 * "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 * 
 * Example 2:
 * Input: words = ["cat","dog","catdog"]
 * Output: ["catdog"]
 */

package al.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class problem_0472 {

    public List<String> solution(String[] words) {
        Set<String> dictionary = new HashSet<>(Arrays.asList(words));
        List<String> concatenatedWords = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int n = word.length();
            boolean[] check = new boolean[n + 1];
            check[0] = true;
            for (int j = 1; j <= n; j++) {
                for (int k = (j == n) ? 1 : 0; k < j && !check[j]; k++) {
                    check[j] = check[k] && dictionary.contains(word.substring(k, j));
                }
            }
            if (check[n]) {
                concatenatedWords.add(word);
            }
        }
        return concatenatedWords;
    }
    
}
