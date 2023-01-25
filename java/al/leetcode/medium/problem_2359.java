/**
 * You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one outgoing edge.
 * The graph is represented with a given 0-indexed array edges of size n, indicating that there is a directed edge from node i to node edges[i]. 
 * If there is no outgoing edge from i, then edges[i] == -1.
 * You are also given two integers node1 and node2.
 * Return the index of the node that can be reached from both node1 and node2,
 * such that the maximum between the distance from node1 to that node, and from node2 to that node is minimized. 
 * If there are multiple answers, return the node with the smallest index, and if no possible answer exists, return -1.
 * Note that edges may contain cycles.
 * 
 * Example 1:
 * Input: edges = [2,2,3,-1], node1 = 0, node2 = 1
 * Output: 2
 * Explanation: The distance from node 0 to node 2 is 1, and the distance from node 1 to node 2 is 1.
 * The maximum of those two distances is 1. 
 * It can be proven that we cannot get a node with a smaller maximum distance than 1, so we return node 2.
 */

package al.leetcode.medium;

import java.util.Arrays;

public class problem_2359 {

    public int solution(int[] edges, int node1, int node2) {
        int[] distFromNode1 = new int[edges.length];
        Arrays.fill(distFromNode1, -1);
        int[] distFromNode2 = new int[edges.length];
        Arrays.fill(distFromNode2, -1);
        boolean[] visited = new boolean[edges.length];
        explore(edges, node1, 0, distFromNode1, visited);
        Arrays.fill(visited, false);
        explore(edges, node2, 0, distFromNode2, visited);
        int minDist = Integer.MAX_VALUE;
        int closestNode = -1;
        for (int i = 0; i < edges.length; i++) {
            int dist1 = distFromNode1[i];
            int dist2 = distFromNode2[i];
            if (dist1 >= 0 && dist2 >= 0) {
                int currMax = Math.max(dist1, dist2);
                if (currMax == minDist && closestNode > i) {
                    closestNode = i;
                } else if (currMax < minDist) {
                    minDist = currMax;
                    closestNode = i;
                }
            }
        }
        return closestNode;
    }

    public void explore(int[] edges, int node, int currDist, int[] dist, boolean[] visited) {
        if (!visited[node]) {
            visited[node] = true;
            dist[node] = currDist;
            if (edges[node] < 0) {
                return;
            }
            explore(edges, edges[node], currDist + 1, dist, visited);
        }
    }
    
}
