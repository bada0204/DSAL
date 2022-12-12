/**
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 * 
 * Example 1:
 * Input: nums = [1,1,2]
 * Output: [[1,1,2], [1,2,1], [2,1,1]]
 * 
 * Example 2:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */

package al.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class problem_0047 {

    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] check = new int[nums.length];
        Arrays.sort(nums);
        solution(result, new ArrayList<>(), nums, check, 0);
        return result;
    }

    public void solution(List<List<Integer>> result, List<Integer> current, int[] nums, int[] check, int index) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && check[i - 1] == 1) {
                continue;
            }
            if (check[i] == 0) {
                check[i] = 1;
                current.add(nums[i]);
                solution(result, current, nums, check, i + 1);
                current.remove(current.size() - 1);
                check[i] = 0;
            }
        }
    }
    
}
