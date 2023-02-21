/**
 * Given a reference of a node in a connected undirected graph.
 * 
 * Return a deep copy (clone) of the graph.
 * 
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 * 
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 * 
 * Example 1:
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 * Explanation: There are 4 nodes in the graph.
 * 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * 
 * Example 2:
 * Input: adjList = [[]]
 * Output: [[]]
 * Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.
 */

package al.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class problem_0133 {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node solution(Node node) {
        if (node == null) {
            return node;
        }
        Node newNode = new Node();
        Map<Integer, Node> visited = new HashMap<>();
        solution(newNode, node, visited);
        return newNode;
    }

    public void solution(Node copy, Node original, Map<Integer, Node> visited) {
        copy.val = original.val;
        copy.neighbors = new ArrayList<>();
        visited.put(copy.val, copy);
        for (Node neighbor : original.neighbors) {
            if (visited.containsKey(neighbor.val)) {
                copy.neighbors.add(visited.get(neighbor.val));
            } else {
                Node copyNeighbor = new Node();
                copy.neighbors.add(copyNeighbor);
                solution(copyNeighbor, neighbor, visited);
            }
        }
    }
    
}
