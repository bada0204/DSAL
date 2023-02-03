/**
 * There is a tree (i.e. a connected, undirected graph with no cycles) consisting of n nodes numbered from 0 to n - 1 and exactly n - 1 edges.
 * You are given a 0-indexed integer array vals of length n where vals[i] denotes the value of the ith node. 
 * You are also given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting nodes ai and bi.
 * 
 * A good path is a simple path that satisfies the following conditions:
 * 1. The starting node and the ending node have the same value.
 * 2. All nodes between the starting node and the ending node have values less than or equal to the starting node 
 * (i.e. the starting node's value should be the maximum value along the path).
 * 
 * Return the number of distinct good paths.
 * 
 * Note that a path and its reverse are counted as the same path. 
 * For example, 0 -> 1 is considered to be the same as 1 -> 0. A single node is also considered as a valid path.
 * 
 * Example 1:
 * Input: vals = [1,3,2,1,3], edges = [[0,1],[0,2],[2,3],[2,4]]
 * Output: 6
 * Explanation: There are 5 good paths consisting of a single node.
 * There is 1 additional good path: 1 -> 0 -> 2 -> 4.
 * (The reverse path 4 -> 2 -> 0 -> 1 is treated as the same as 1 -> 0 -> 2 -> 4.)
 * Note that 0 -> 2 -> 3 is not a good path because vals[2] > vals[0].
 * 
 * Example 2:
 * Input: vals = [1,1,2,2,3], edges = [[0,1],[1,2],[2,3],[2,4]]
 * Output: 7
 * Explanation: There are 5 good paths consisting of a single node.
 * There are 2 additional good paths: 0 -> 1 and 2 -> 3.
 */

package al.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ds.UnionFind;

public class problem_2421 {

    public int solution(int[] vals, int[][] edges) {
        int goodPaths = 0;
        int n = vals.length;
        UnionFind uf = new UnionFind(n);

        Map<Integer, List<Integer>> adjacentList = constructAdjacentList(vals, edges);
        TreeMap<Integer, List<Integer>> valNodeMap = constructValNodeMap(vals);

        for (Integer val : valNodeMap.keySet()) {
            List<Integer> currentNodes = valNodeMap.get(val);
            for (Integer currentNode : currentNodes) {
                List<Integer> currentAdjacentList = adjacentList.getOrDefault(currentNode, new ArrayList<>());
                for (Integer currentAdjacentNode : currentAdjacentList) {
                    uf.union(currentNode, currentAdjacentNode);
                }
            }

            Map<Integer, Integer> group = new HashMap<>();
            for (Integer currentNode : currentNodes) {
                int root = uf.find(currentNode);
                group.put(root, group.getOrDefault(root, 0) + 1);
            }
            goodPaths += currentNodes.size();

            for (Integer root : group.keySet()) {
                int newConnectedNodes = group.get(root);
                goodPaths += (newConnectedNodes * (newConnectedNodes - 1)) / 2;
            }
        }

        return goodPaths;
    }

    public Map<Integer, List<Integer>> constructAdjacentList(int[] vals, int[][] edges) {
        Map<Integer, List<Integer>> adjacentList = new HashMap<>();
        for (int[] edge : edges) {
            int in = edge[0];
            int out = edge[1];
            adjacentList.putIfAbsent(in, new ArrayList<>());
            adjacentList.putIfAbsent(out, new ArrayList<>());
            if (vals[in] >= vals[out]) {
                adjacentList.get(in).add(out);
            }
            if (vals[in] <= vals[out]) {
                adjacentList.get(out).add(in);
            }
        }
        return adjacentList;
    }

    public TreeMap<Integer, List<Integer>> constructValNodeMap(int[] vals) {
        TreeMap<Integer, List<Integer>> valNodeMap = new TreeMap<>();
        for (int i = 0; i < vals.length; i++) {
            valNodeMap.putIfAbsent(vals[i], new ArrayList<>());
            valNodeMap.get(vals[i]).add(i);
        }
        return valNodeMap;
    }
    
}
