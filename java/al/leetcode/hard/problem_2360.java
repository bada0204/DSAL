/**
 * You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one outgoing edge.
 * The graph is represented with a given 0-indexed array edges of size n, indicating that there is a directed edge from node i to node edges[i]. 
 * If there is no outgoing edge from node i, then edges[i] == -1.
 * Return the length of the longest cycle in the graph. If no cycle exists, return -1.
 * 
 * A cycle is a path that starts and ends at the same node.
 * 
 * Example 1:
 * Input: edges = [3,3,4,2,3]
 * Output: 3
 * Explanation: The longest cycle in the graph is the cycle: 2 -> 4 -> 3 -> 2.
 * The length of this cycle is 3, so 3 is returned.
 * 
 * Example 2:
 * Input: edges = [2,-1,3,1]
 * Output: -1
 * Explanation: There are no cycles in this graph.
 */

package al.leetcode.hard;

public class problem_2360 {

    public int solution(int[] edges) {
        int longest = -1;
        boolean[] visited = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                longest = Math.max(longest, detectCycle(i, edges[i], edges, visited));
            }
        }
        return longest;
    }

    public int detectCycle(int slow, int fast, int[] edges, boolean[] visited) {
        if (visited[slow]) {
            return -1;
        } else if (fast < 0) {
            while (slow != fast) {
                visited[slow] = true;
                slow = edges[slow];
            }
            return -1;
        } else if (slow == fast) {
            int numNodes = 1;
            visited[slow] = true;
            slow = edges[slow];
            while (slow != fast) {
                slow = edges[slow];
                numNodes++;
            }
            return numNodes;
        } else {
            int cycle = -1;
            visited[slow] = true;
            slow = edges[slow];
            fast = edges[fast];
            if (fast >= 0) {
                cycle = detectCycle(slow, edges[fast], edges, visited);
            }
            return cycle;
        }
    }
    
}
