/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 * 
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * 
 * Example 1:
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * 
 * Example 2:
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 */

package al.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class problem_0043 {
    
    public String solution(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        List<String> s = new ArrayList<>();
        for (int i = num1.length() - 1; i >= 0; i--) {
            StringBuilder current = new StringBuilder();
            int a = num1.charAt(i) - '0';
            int b = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int c = num2.charAt(j) - '0';
                int d = (a * c) + b;
                current.insert(0, d % 10);
                b = d / 10;
            }
            if (b > 0) {
                current.insert(0, b);
            }
            s.add(current.toString());
        }
        
        StringBuilder result = new StringBuilder();
        String s1 = s.get(0);
        for (int i = 1; i < s.size(); i++) {
            String s2 = s.get(i);
            int i1 = s1.length() - 1;
            int n = 0;
            while (n < i) {
                result.insert(0, s1.charAt(i1--));
                n++;
            }
            int i2 = s2.length() - 1;
            int b = 0;
            while (i1 >= 0 || i2 >= 0) {
                int a = (i1 >= 0) ? s1.charAt(i1--) - '0' : 0;
                int c = (i2 >= 0) ? s2.charAt(i2--) - '0' : 0;
                int d = a + b + c;
                result.insert(0, d % 10);
                b = d / 10; 
            }
            if (b > 0) {
                result.insert(0, b);
            }
            s1 = result.toString();
            result = new StringBuilder();
        }
        return s1;
    }

}
