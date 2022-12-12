package al.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class problem_0046 {

    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] check = new int[nums.length];
        solution(result, new ArrayList<>(), nums, check, 0);
        return result;
    }

    public void solution(List<List<Integer>> result, List<Integer> current, int[] nums, int[] check, int index) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
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
