/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * 
 * Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * Example 2:
 * Input: digits = ""
 * Output: []
 * 
 * Example 3:
 * Input: digits = "2"
 * Output: ["a","b","c"]
 */

package al.leetcode.medium;

public class problem_0017 {

	String[] digitAndLetter = new String[] {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> solution(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() > 0) {
            solution(result, digits, new StringBuilder(), 0);
        }    
        return result;
    }

    public void solution(List<String> result, String digits, StringBuilder current, int index) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        int currentDigit = digits.charAt(index) - '1';
        for (int i = 0; i < digitAndLetter[currentDigit].length(); i++) {
            char currentLetter = digitAndLetter[currentDigit].charAt(i);
            current.append(currentLetter);
            solution(result, digits, current, index + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }

}