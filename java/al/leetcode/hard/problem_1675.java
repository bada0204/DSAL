/**
 * You are given an array nums of n positive integers.
 * 
 * You can perform two types of operations on any element of the array any number of times:
 * 1. If the element is even, divide it by 2.
 * For example, if the array is [1,2,3,4], then you can do this operation on the last element, and the array will be [1,2,3,2].
 * 2. If the element is odd, multiply it by 2.
 * For example, if the array is [1,2,3,4], then you can do this operation on the first element, and the array will be [2,2,3,4].
 * 
 * The deviation of the array is the maximum difference between any two elements in the array.
 * Return the minimum deviation the array can have after performing some number of operations.
 * 
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: 1
 * Explanation: You can transform the array to [1,2,3,2], then to [2,2,3,2], then the deviation will be 3 - 2 = 1.
 * 
 * Example 2:
 * Input: nums = [4,1,5,20,3]
 * Output: 3
 * Explanation: You can transform the array after two operations to [4,2,5,5,3], then the deviation will be 5 - 2 = 3.
 * 
 * Example 3:
 * Input: nums = [2,10,8]
 * Output: 3
 */

package al.leetcode.hard;

import java.util.SortedSet;
import java.util.TreeSet;

public class problem_1675 {

    public int solution(int[] nums) {
        SortedSet<Integer> sortedList = new TreeSet<>();
        for (int n : nums) {
            if (n % 2 != 0) {
                n *= 2;
            }
            sortedList.add(n);
        }
        int deviation = Integer.MAX_VALUE;
        while (sortedList.last() % 2 == 0) {
            int last = sortedList.last();
            sortedList.remove(last);
            sortedList.add(last / 2);
            deviation = Math.min(deviation, Math.abs(sortedList.first() - sortedList.last()));
        }
        deviation = Math.min(deviation, Math.abs(sortedList.first() - sortedList.last()));
        return deviation;
    }
    
}
