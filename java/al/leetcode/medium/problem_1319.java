/**
 * There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network 
 * where connections[i] = [ai, bi] represents a connection between computers ai and bi. 
 * Any computer can reach any other computer directly or indirectly through the network.
 * You are given an initial computer network connections. 
 * You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.
 * 
 * Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.
 * 
 * Example 1:
 * Input: n = 4, connections = [[0,1],[0,2],[1,2]]
 * Output: 1
 * Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
 * 
 * Example 2:
 * Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
 * Output: 2
 * 
 * Example 3:
 * Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
 * Output: -1
 * Explanation: There are not enough cables.
 */

package al.leetcode.medium;

public class problem_1319 {

    public int solution(int n, int[][] connections) {
        int extras = 0;
        int[] nodes = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = i;
        }
        for (int[] connection : connections) {
            int p = find(nodes, connection[0]);
            int q = find(nodes, connection[1]);
            if (p == q) {
                extras++;
            } else if (p < q) {
                nodes[q] = p;
            } else {
                nodes[p] = q;
            }
        }
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (nodes[i] == i) {
                components++;
            }
        }
        return extras >= components - 1 ? components - 1 : -1;
    }

    public int find(int[] nodes, int x) {
        if (nodes[x] == x) {
            return nodes[x];
        }
        return nodes[x] = find(nodes, nodes[x]);
    }

}
