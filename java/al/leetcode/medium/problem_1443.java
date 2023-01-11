/**
 * Given an undirected tree consisting of n vertices numbered from 0 to n-1, which has some apples in their vertices. 
 * You spend 1 second to walk over one edge of the tree. 
 * Return the minimum time in seconds you have to spend to collect all apples in the tree, starting at vertex 0 and coming back to this vertex.
 * The edges of the undirected tree are given in the array edges, where edges[i] = [a_i, b_i] means that exists an edge connecting the vertices ai and bi. 
 * Additionally, there is a boolean array hasApple, where hasApple[i] = true means that vertex i has an apple; otherwise, it does not have any apple.
 * 
 * Example 1:
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
 * Output: 8 
 * Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect all apples is shown by the green arrows.  
 * 
 * Example 2:
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,false,true,false]
 * Output: 6
 * Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect all apples is shown by the green arrows.  
 * 
 * Example 3:
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,false,false,false,false,false]
 * Output: 0
 */

package al.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class problem_1443 {

    public int solution(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        boolean[] visited = new boolean[n];
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            edgeMap.putIfAbsent(start, new ArrayList<>());
            edgeMap.putIfAbsent(end, new ArrayList<>());
            edgeMap.get(start).add(end);
            edgeMap.get(end).add(start);
        }
        return solution(n, 0, edgeMap, hasApple, visited);
    }
    

    public int solution(int n, int s, Map<Integer, List<Integer>> edgeMap, List<Boolean> hasApple, boolean[] visited) {
        if (!visited[s]) {
            visited[s] = true;
            int totalTime = 0;
            List<Integer> edges = edgeMap.getOrDefault(s, new ArrayList<>());
            for (int i = 0; i < edges.size(); i++) {
                totalTime += solution(n, edges.get(i), edgeMap, hasApple, visited);
            }
            if (s != 0 && (hasApple.get(s) || totalTime > 0)) {
                return totalTime + 2;
            } else {
                return totalTime;
            }
        } else {
            return 0;
        }
    }
    
}
