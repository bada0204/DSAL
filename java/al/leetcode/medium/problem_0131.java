/**
 * Given a string s, partition s such that every substring of the partition is a palindrome. 
 * Return all possible palindrome partitioning of s.
 * 
 * Example 1:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * 
 * Example 2:
 * Input: s = "a"
 * Output: [["a"]]
 */

package al.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import utils.StringUtils;

public class problem_0131 {

    public List<List<String>> solution(String s) {
        List<List<String>> results = new ArrayList<>();
        solution(results, new ArrayList<>(), s, 0);
        return results;
    }

    public void solution(List<List<String>> results, List<String> partition, String s, int start) {
        if (start == s.length()) {
            results.add(new ArrayList<>(partition));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String substring = s.substring(start, i + 1);
            if (StringUtils.isParlindrome(substring)) {
                partition.add(substring);
                solution(results, partition, s, i + 1);
                partition.remove(partition.size() - 1);
            }
        }
    }
    
}
