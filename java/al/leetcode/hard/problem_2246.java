/**
 * You are given a tree (i.e. a connected, undirected graph that has no cycles) rooted at node 0 consisting of n nodes numbered from 0 to n - 1. 
 * The tree is represented by a 0-indexed array parent of size n, where parent[i] is the parent of node i. Since node 0 is the root, parent[0] == -1.
 * You are also given a string s of length n, where s[i] is the character assigned to node i.
 * Return the length of the longest path in the tree such that no pair of adjacent nodes on the path have the same character assigned to them.
 * 
 * Example 1:
 * Input: parent = [-1,0,0,1,1,2], s = "abacbe"
 * Output: 3
 * Explanation: The longest path where each two adjacent nodes have different characters in the tree is the path: 0 -> 1 -> 3.
 * The length of this path is 3, so 3 is returned.
 * It can be proven that there is no longer path that satisfies the conditions. 
 * 
 * Example 2:
 * Input: parent = [-1,0,0,0], s = "aabc"
 * Output: 3
 * Explanation: The longest path where each two adjacent nodes have different characters is the path: 2 -> 0 -> 3. The length of this path is 3, so 3 is returned.
 */

package al.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class problem_2246 {

    private int longestChain = 1;

    public int longestPath(int[] parent, String s) {
        if (s.length() == 1) {
            return longestChain;
        }
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        boolean[] visited = new boolean[s.length()];
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] >= 0) {
                edgeMap.putIfAbsent(i, new ArrayList<>());
                edgeMap.putIfAbsent(parent[i], new ArrayList<>());
                edgeMap.get(i).add(parent[i]);
                edgeMap.get(parent[i]).add(i);
            }
        }
        solution(edgeMap, 0, s, visited);
        return longestChain;
    }

    public int solution(Map<Integer, List<Integer>> edgeMap, int start, String s, boolean[] visited) {
        visited[start] = true;
        List<Integer> connectedNodes = edgeMap.get(start);
        int longest = 0;
        int secondLongest = 0;
        for (int i = 0; i < connectedNodes.size(); i++) {
            int node = connectedNodes.get(i);
            if (!visited[node]) {
                int fromChild = solution(edgeMap, node, s, visited);
                if (s.charAt(start) != s.charAt(node)) {
                    if (fromChild > longest) {
                        secondLongest = longest;
                        longest = fromChild;
                    } else if (fromChild > secondLongest) {
                        secondLongest = fromChild;
                    }
                }
            }
        }
        longestChain = Math.max(longestChain, longest + secondLongest + 1);
        return longest + 1;
    }
    
}
