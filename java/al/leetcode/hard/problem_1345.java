/**
 * Given an array of integers arr, you are initially positioned at the first index of the array.
 * 
 * In one step you can jump from index i to index:
 * 1. i + 1 where: i + 1 < arr.length.
 * 2. i - 1 where: i - 1 >= 0.
 * 3. j where: arr[i] == arr[j] and i != j.
 * 
 * Return the minimum number of steps to reach the last index of the array.
 * 
 * Notice that you can not jump outside of the array at any time.
 * 
 * Example 1:
 * Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
 * Output: 3
 * Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
 * 
 * Example 2:
 * Input: arr = [7]
 * Output: 0
 * Explanation: Start index is the last index. You do not need to jump.
 * 
 * Example 3:
 * Input: arr = [7,6,9,6,9,6,9,7]
 * Output: 1
 * Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
 */

package al.leetcode.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class problem_1345 {

    public int solution(int[] arr) {
        int count = 0;
        boolean[] visited = new boolean[arr.length];
        Map<Integer, List<Integer>> dests = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            dests.putIfAbsent(num, new ArrayList<>());
            dests.get(num).add(i);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int dest = queue.poll();
                if (dest == arr.length - 1) {
                    return count;
                }
                int num = arr[dest];
                List<Integer> nexts = dests.getOrDefault(num, new ArrayList<>());
                nexts.add(dest + 1);
                nexts.add(dest - 1);
                for (int next : nexts) {
                    if (next >= 0 && next < arr.length && !visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
                nexts.clear();
                size--;
            }
            count++;
        }
        return count;
    }
    
}
