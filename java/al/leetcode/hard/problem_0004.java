/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * 
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * 
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */

package al.leetcode.hard;

import java.util.PriorityQueue;

public class problem_0004 {

    // 1. using 2 heaps
    public double solution1(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1.compareTo(n2));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> -1 * n1.compareTo(n2));
        int length = Math.max(nums1.length, nums2.length);
        for (int i = 0; i < length; i++) {
            if (i < nums1.length) {
                minHeap.add(nums1[i]);
            }
            if (i < nums2.length) {
                minHeap.add(nums2[i]);
            }
        }
        int n = minHeap.size() / 2;
        for (int i = 0; i < n; i++) {
            maxHeap.add(minHeap.poll());
        }
        double min = minHeap.poll();
        if (maxHeap.isEmpty()) {
            return min;
        }
        double max = maxHeap.poll();
        if (minHeap.size() > maxHeap.size()) {
            return min;
        } else if (minHeap.size() < maxHeap.size()) {
            return max;
        } else {
            return (min + max) / 2;
        }
    }

    // 2. using recursion
    public double solution2(int[] nums1, int[] nums2) {
        return 0.0;
    }

}