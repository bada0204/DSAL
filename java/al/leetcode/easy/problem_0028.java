/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * Example 1:
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * 
 * Example 2:
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 */

package al.leetcode.easy;

public class problem_0028 {

    public int solution(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = i;
            int k = i + needle.length() - 1;
            int left = 0;
            int right = needle.length() - 1;
            boolean find = true;
            while (j <= k) {
                if (haystack.charAt(j) != needle.charAt(left) || haystack.charAt(k) != needle.charAt(right)) {
                    find = false;
                    break;
                }
                j++;
                left++;
                k--;
                right--;
            }
            if (find) {
                return i;
            }
        }
        return -1;
    }
    
}
