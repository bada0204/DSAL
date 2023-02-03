/**
 * There are n cities connected by some number of flights. 
 * You are given an array flights where flights[i] = [from_i, to_i, price_i] indicates that there is a flight from city from_i to city to_i with cost price_i.
 * You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. 
 * If there is no such route, return -1.
 * 
 * Example 1:
 * Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
 * Output: 700
 * Explanation:
 * The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
 * Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
 * 
 * Example 2:
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation:
 * The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
 * 
 * Example 3:
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation:
 * The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
 */

package al.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class problem_0787 {

    public int solution(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> flightGraph = buildGraph(flights);
        Queue<int[]> itinerary = new ArrayDeque<>();
        int[] minCostsToDst = new int[n];
        Arrays.fill(minCostsToDst, -1);
        int stops = 0;
        itinerary.offer(new int[] {src, 0});
        while (!itinerary.isEmpty() && stops <= k) {
            int size = itinerary.size();
            while (size > 0) {
                int[] curr = itinerary.poll();
                int currentSrc = curr[0];
                int currentCost = curr[1];
                List<int[]> possibleDests = flightGraph.getOrDefault(currentSrc, new ArrayList<>());
                for (int[] possibleDest : possibleDests) {
                    int dest = possibleDest[0];
                    int cost = possibleDest[1];
                    if (minCostsToDst[dest] < 0) {
                        minCostsToDst[dest] = currentCost + cost;
                    } else if (minCostsToDst[dest] <= currentCost + cost) {
                        continue;
                    } else {
                        minCostsToDst[dest] = currentCost + cost;
                    }
                    itinerary.offer(new int[] {dest, currentCost + cost});
                }
                size--;
            }
            stops++;
        }
        return minCostsToDst[dst];
    }

    public Map<Integer, List<int[]>> buildGraph(int[][] flights) {
        Map<Integer, List<int[]>> flightGraph = new HashMap<>();
        for (int[] flight : flights) {
            int src = flight[0];
            int dest = flight[1];
            int cost = flight[2];
            flightGraph.putIfAbsent(src, new ArrayList<>());
            flightGraph.get(src).add(new int[] {dest, cost});
        }
        return flightGraph;
    }
    
}
