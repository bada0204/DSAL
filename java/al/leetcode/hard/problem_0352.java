/**
 * Given a data stream input of non-negative integers a1, a2, ..., an, summarize the numbers seen so far as a list of disjoint intervals.
 * 
 * Implement the SummaryRanges class:
 * 1. SummaryRanges() Initializes the object with an empty stream.
 * 2. void addNum(int value) Adds the integer value to the stream.
 * 3. int[][] getIntervals() Returns a summary of the integers in the stream currently as a list of disjoint intervals [starti, endi]. 
 * The answer should be sorted by starti.
 */

package al.leetcode.hard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class problem_0352 {

    private TreeSet<Integer> stream;

    public problem_0352() {
        this.stream = new TreeSet<>();
    }
    
    public void addNum(int value) {
        if (!this.stream.contains(value)) {
            this.stream.add(value);
        }
    }
    
    public int[][] getIntervals() {
        int start = -1;
        int end = -1;
        List<int[]> intervals = new ArrayList<>();
        Iterator<Integer> iter = stream.iterator();
        while (iter.hasNext()) {
            int num = iter.next();
            if (start < 0) {
                start = num;
            }
            if (end < 0) {
                end = num;
            } else if (end + 1 == num) {
                end = num;
            } else {
                intervals.add(new int[] {start, end});
                start = num;
                end = num;
            }
        }
        if (start >= 0 && end >= 0) {
            intervals.add(new int[] {start, end});
        }
        return intervals.toArray(new int[0][]);
    }
    
}
