package al.leetcode.easy;

public class problem_0069 {

    public int solution(int x) {
        if (x < 2) return x;
        if (x < 4) return 1;
        int start = 0;
        int end = x;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int curr = x / mid;
            if (curr == mid) {
                return mid;
            } else if (curr < mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (start > (x / start))
            start--;
        return start;
    }

}
