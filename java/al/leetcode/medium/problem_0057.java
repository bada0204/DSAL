/**
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [start_i, end_i] represent the start and the end of the ith interval and intervals is sorted in ascending order by start_i. 
 * You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by start_i and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * Return intervals after the insertion.
 * 
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * 
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */

package al.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class problem_0057 {

    public int[][] solution(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            if (newInterval == null || currentInterval[1] < newInterval[0]) {
                result.add(currentInterval);
            } else if (newInterval != null && newInterval[1] < currentInterval[0]) {
                result.add(newInterval);
                newInterval = null;
                result.add(currentInterval);
            } else {
                newInterval[0] = Math.min(newInterval[0], currentInterval[0]);
                newInterval[1] = Math.max(newInterval[1], currentInterval[1]);
            }
        }
        if (newInterval != null) {
            result.add(newInterval);
        }
        return result.toArray(new int[result.size()][]);
    }

}