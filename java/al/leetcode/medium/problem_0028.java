package al.leetcode.medium;

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
