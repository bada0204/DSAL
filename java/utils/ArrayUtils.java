package utils;

public class ArrayUtils {

    public static void print(int[] A) {
        StringBuilder print = new StringBuilder("[ ");
        for (int n : A) {
            print.append(n).append(" ");
        }
        print.append("]");
        System.out.println(print.toString());
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

}
