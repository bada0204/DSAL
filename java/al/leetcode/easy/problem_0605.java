/**
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 * 
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, 
 * return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.
 * 
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * 
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 */

package al.leetcode.easy;

public class problem_0605 {

    public boolean solution(int[] flowerbed, int n) {
        int num = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            int before = i - 1;
            int after = i + 1;
            boolean isBeforeEmpty = before < 0 || (before >= 0 && flowerbed[before] == 0);
            boolean isAfterEmpty = after >= flowerbed.length || (after < flowerbed.length && flowerbed[after] == 0);
            if (isBeforeEmpty && isAfterEmpty && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                num++;
            }
        }
        return n <= num;
    }
    
}
