/**
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). 
 * Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
 * Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
 * This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
 * Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
 * It's guaranteed that each city can reach city 0 after reorder.
 * 
 * Example 1:
 * Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * Output: 3
 * Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
 * 
 * Example 2:
 * Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
 * Output: 2
 * Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
 * 
 * Example 3:
 * Input: n = 3, connections = [[1,0],[2,0]]
 * Output: 0
 */

package al.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class problem_1466 {

    public int solution(int n, int[][] connections) {
        ArrayList<int[]>[] map = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            map[from].add(new int[] {to, 1});
            map[to].add(new int[] {from, 0});
        }
        int num = 0;
        boolean[] visited = new boolean[n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] node = queue.poll();
                if (!visited[node[0]]) {
                    visited[node[0]] = true;
                    num += node[1];
                    ArrayList<int[]> edges = map[node[0]];
                    for (int[] edge : edges) {
                        queue.offer(edge);
                    }
                }
                size--;
            }
        }
        return num;
    }
    
}
