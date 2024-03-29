/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * 
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * 
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * 
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 */

package al.leetcode.medium;

import java.util.List;

public class problem_0139 {

    public boolean solution(String s, List<String> wordDict) {
        boolean[] segmentation = new boolean[s.length() + 1];
        segmentation[0] = true;
        for (int i = 1; i < segmentation.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (!segmentation[i]) {
                    String word = s.substring(j, i);
                    segmentation[i] = wordDict.contains(word) && segmentation[j];
                }
            }
        }
        return segmentation[s.length()];
    }
    
}
