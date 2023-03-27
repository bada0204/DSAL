/**
 * You are given a positive integer n representing n cities numbered from 1 to n. 
 * You are also given a 2D array roads where roads[i] = [ai, bi, distancei] indicates that there is a bidirectional road between cities ai and bi with a distance equal to distancei. 
 * The cities graph is not necessarily connected.
 * The score of a path between two cities is defined as the minimum distance of a road in this path.
 * 
 * Return the minimum possible score of a path between cities 1 and n.
 * 
 * Note:
 * A path is a sequence of roads between two cities.
 * It is allowed for a path to contain the same road multiple times, and you can visit cities 1 and n multiple times along the path.
 * The test cases are generated such that there is at least one path between 1 and n.
 * 
 * Example 1:
 * Input: n = 4, roads = [[1,2,9],[2,3,6],[2,4,5],[1,4,7]]
 * Output: 5
 * Explanation: The path from city 1 to 4 with the minimum score is: 1 -> 2 -> 4. The score of this path is min(9,5) = 5.
 * It can be shown that no other path has less score.
 * 
 * Example 2:
 * Input: n = 4, roads = [[1,2,2],[1,3,4],[3,4,7]]
 * Output: 2
 * Explanation: The path from city 1 to 4 with the minimum score is: 1 -> 2 -> 1 -> 3 -> 4. The score of this path is min(2,2,4,7) = 2.
 */

package al.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class problem_2492 {

    public int solution(int n, int[][] roads) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> scores = new HashMap<>();
        for (int[] road : roads) {
            int start = road[0];
            int end = road[1];
            int score = road[2];
            graph.putIfAbsent(start, new ArrayList<>());
            graph.putIfAbsent(end, new ArrayList<>());
            graph.get(start).add(end);
            graph.get(end).add(start);
            scores.putIfAbsent(start, new HashMap<>());
            scores.putIfAbsent(end, new HashMap<>());
            scores.get(start).put(end, score);
            scores.get(end).put(start, score);
        }
        int minScore = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int currentCity = queue.poll();
                if (!visited[currentCity - 1]) {
                    visited[currentCity - 1] = true;
                    List<Integer> paths = graph.get(currentCity);
                    for (Integer path : paths) {
                        minScore = Math.min(minScore, scores.get(currentCity).get(path));
                        queue.offer(path);
                    }
                }
                size--;
            }
        }
        return minScore;
    }
    
}
