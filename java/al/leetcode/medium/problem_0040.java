/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 * Each number in candidates may only be used once in the combination.
 * Note: The solution set must not contain duplicate combinations.
 *
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output: [ [1,1,6], [1,2,5], [1,7], [2,6] ]
 *
 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output: [ [1,2,2], [5] ]
 */

package al.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class problem_0040 {

    public List<List<Integer>> solution(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        solution(results, new ArrayList<>(), candidates, target, 0, 0);
        return results;
    }

    public void solution(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int sum, int index) {
        if (target == sum) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] <= target) {
                current.add(candidates[i]);
                solution(result, current, candidates, target, sum + candidates[i], i + 1);
                current.remove(current.size() - 1);
            }
            while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                i++;
            }
        }
    }

}
