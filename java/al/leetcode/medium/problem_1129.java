/**
 * You are given an integer n, the number of nodes in a directed graph where the nodes are labeled from 0 to n - 1. 
 * Each edge is red or blue in this graph, and there could be self-edges and parallel edges.
 * 
 * You are given two arrays redEdges and blueEdges where:
 * 1. redEdges[i] = [ai, bi] indicates that there is a directed red edge from node ai to node bi in the graph, and
 * 2. blueEdges[j] = [uj, vj] indicates that there is a directed blue edge from node uj to node vj in the graph.
 * 
 * Return an array answer of length n, where each answer[x] is the length of the shortest path from node 0 to node x 
 * such that the edge colors alternate along the path, or -1 if such a path does not exist.
 * 
 * Example 1:
 * Input: n = 3, redEdges = [[0,1],[1,2]], blueEdges = []
 * Output: [0,1,-1]
 * 
 * Example 2:
 * Input: n = 3, redEdges = [[0,1]], blueEdges = [[2,1]]
 * Output: [0,1,-1]
 */

package al.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class problem_1129 {

    public int[] solution(int n, int[][] redEdges, int[][] blueEdges) {
        int[] paths = new int[n];
        boolean[][] visited = new boolean[n][2];
        Arrays.fill(paths, -1);
        paths[0] = 0;
        List<int[]> starts = new ArrayList<>();
        Map<Integer, List<int[]>> coloredEdges = new HashMap<>();
        for (int[] edge : redEdges) {
            int from = edge[0];
            int to = edge[1];
            if (from == 0) {
                starts.add(new int[] {0, 2});
            }
            int[] coloredEdgeDest = new int[] {to, 0};
            coloredEdges.putIfAbsent(from, new ArrayList<>());
            coloredEdges.get(from).add(coloredEdgeDest);
        }
        for (int[] edge : blueEdges) {
            int from = edge[0];
            int to = edge[1];
            if (from == 0) {
                starts.add(new int[] {0, 2});
            }
            int[] coloredEdgeDest = new int[] {to, 1};
            coloredEdges.putIfAbsent(from, new ArrayList<>());
            coloredEdges.get(from).add(coloredEdgeDest);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        for (int[] start : starts) {
            queue.offer(start);
        }
        visited[0][0] = true;
        visited[0][1] = true;
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] curr = queue.poll();
                int node = curr[0];
                if (paths[node] < 0) {
                    paths[node] = distance;
                } else {
                    paths[node] = Math.min(paths[node], distance);
                }
                int currColor = curr[1];
                List<int[]> possibleDests = coloredEdges.getOrDefault(node, new ArrayList<>());
                for (int[] possibleDest : possibleDests) {
                    int dest = possibleDest[0];
                    int destColor = possibleDest[1];
                    if (currColor != destColor && !visited[dest][destColor]) {
                        queue.offer(possibleDest);
                        visited[dest][destColor] = true;
                    }
                }
                size--;
            }
            distance++;
        }
        return paths;
    }
    
}
