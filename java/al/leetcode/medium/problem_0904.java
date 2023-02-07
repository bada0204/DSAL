/**
 * You are visiting a farm that has a single row of fruit trees arranged from left to right. 
 * The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
 * 
 * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
 * 1. You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
 * 2. Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. 
 * The picked fruits must fit in one of your baskets.
 * 3. Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 * 
 * Given the integer array fruits, return the maximum number of fruits you can pick.
 * 
 * Example 1:
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 * 
 * Example 2:
 * Input: fruits = [0,1,2,2]
 * Output: 3
 * Explanation: We can pick from trees [1,2,2].
 * If we had started at the first tree, we would only pick from trees [0,1].
 * 
 * Example 3:
 * Input: fruits = [1,2,3,2,2]
 * Output: 4
 * Explanation: We can pick from trees [2,3,2,2].
 * If we had started at the first tree, we would only pick from trees [1,2].
 */

package al.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class problem_0904 {

    public int solution(int[] fruits) {
        int max = 0;
        int curr = 0;
        int start = 0;
        int end = 1;
        Map<Integer, Integer> baskets = new HashMap<>();
        if (fruits.length < 2) {
            return 1;
        }
        baskets.put(fruits[start], baskets.getOrDefault(fruits[start], 0) + 1);
        while (end < fruits.length) { 
            baskets.put(fruits[end], baskets.getOrDefault(fruits[end], 0) + 1);
            while (start < end && baskets.size() > 2) {
                if (baskets.getOrDefault(fruits[start], 0) > 0) {
                    baskets.put(fruits[start], baskets.getOrDefault(fruits[start], 0) - 1);
                    if (baskets.get(fruits[start]) == 0) {
                        baskets.remove(fruits[start]);
                    }
                }
                start++;
            }
            curr = end - start + 1;
            if (max < curr) {
                max = curr;
            }
            end++;
        }
        return max;
    }
    
}
