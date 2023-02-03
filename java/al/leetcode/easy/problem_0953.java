/**
 * In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. 
 * The order of the alphabet is some permutation of lowercase letters.
 * Given a sequence of words written in the alien language, and the order of the alphabet, 
 * return true if and only if the given words are sorted lexicographically in this alien language.
 * 
 * Example 1:
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * 
 * Example 2:
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * 
 * Example 3:
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) 
 * According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character 
 * which is less than any other character (More info).
 */

package al.leetcode.easy;

public class problem_0953 {

    public boolean solution(String[] words, String order) {
        int[] orders = new int[26];
        int current = 0;
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            orders[c - 'a'] = current++;
        }
        for (int i = 1; i < words.length; i++) {
            String first = words[i - 1];
            String second = words[i];
            if (!isSorted(first, second, orders)) {
                return false;
            }
        }
        return true;
    }

    public boolean isSorted(String first, String second, int[] orders) {
        int a = 0;
        int b = 0;
        while (a < first.length() && b < second.length()) {
            int o1 = orders[first.charAt(a) - 'a'];
            int o2 = orders[second.charAt(b) - 'a'];
            if (o2 < o1) {
                return false;
            } else if (o1 < o2) {
                return true;
            } else {
                a++;
                b++;
            }
        }
        if (a < first.length()) {
            return false;
        }
        return true;
    }
    
}
