/**
 * A valid IP address consists of exactly four integers separated by single dots. 
 * Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
 * 
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 * Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. 
 * You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.
 * 
 * Example 1:
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 * 
 * Example 2:
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 * 
 * Example 3:
 * Input: s = "101023"
 * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 */

package al.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class problem_0093 {

    public List<String> solution(String s) {
        List<String> ipAddresses = new ArrayList<>();
        solution(ipAddresses, new StringBuilder(), s, 0, 0);
        return ipAddresses;
    }

    public void solution(List<String> ipAddresses, StringBuilder ipAddress, String s, int start, int segments) {
        if (start == s.length() && segments == 4) {
            ipAddresses.add(ipAddress.substring(0, ipAddress.length() - 1));
            return;
        } else if (segments > 4) {
            return;
        } else {
            for (int i = start + 1; i <= s.length() && i <= start + 3; i++) {
                String currentBlock = s.substring(start, i);
                if (isValid(currentBlock)) {
                    ipAddress.append(currentBlock).append('.');
                    solution(ipAddresses, ipAddress, s, i, segments + 1);
                    ipAddress = ipAddress.deleteCharAt(ipAddress.length() - 1);
                    ipAddress = ipAddress.delete(ipAddress.length() - (i - start), ipAddress.length());
                }
            }
        }
    }

    public boolean isValid(String block) {
        if (block.length() > 1 && block.charAt(0) == '0') {
            return false;
        } else if (Integer.parseInt(block) > 255) {
            return false;
        } else {
            return true;
        }
    }
    
}
