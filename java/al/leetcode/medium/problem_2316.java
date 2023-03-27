/**
 * You are given an integer n. There is an undirected graph with n nodes, numbered from 0 to n - 1. 
 * You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting nodes ai and bi.
 * 
 * Return the number of pairs of different nodes that are unreachable from each other.
 * 
 * Example 1:
 * Input: n = 3, edges = [[0,1],[0,2],[1,2]]
 * Output: 0
 * Explanation: There are no pairs of nodes that are unreachable from each other. Therefore, we return 0.
 * 
 * Example 2:
 * Input: n = 7, edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]
 * Output: 14
 * Explanation: There are 14 pairs of nodes that are unreachable from each other:
 * [[0,1],[0,3],[0,6],[1,2],[1,3],[1,4],[1,5],[2,3],[2,6],[3,4],[3,5],[3,6],[4,6],[5,6]].
 * Therefore, we return 14.
 */

package al.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class problem_2316 {

    public long solution(int n, int[][] edges) {
        long compare = -1;
        long count = 0;
        boolean[] visited = new boolean[n];
        ArrayList<Integer>[] edgeMap = constructEdgeMap(n, edges);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                long clusters = traverse(i, edgeMap, visited);
                if (compare < 0) {
                    compare = clusters;
                } else {
                    count += (compare * clusters);
                    compare += clusters;
                }
            }
        }
        return count;
    }

    public long traverse(int from, List<Integer>[] edgeMap, boolean[] visited) {
        long count = 1;
        visited[from] = true;
        List<Integer> connectedEdges = edgeMap[from];
        for (int to : connectedEdges) {
            if (!visited[to]) {
                count += traverse(to, edgeMap, visited);
            }
        }
        return count;
    }

    public ArrayList<Integer>[] constructEdgeMap(int n, int[][] edges) {
        ArrayList<Integer>[] edgeMap = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edgeMap[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            edgeMap[from].add(to);
            edgeMap[to].add(from);
        }
        return edgeMap;
    }
    
}
