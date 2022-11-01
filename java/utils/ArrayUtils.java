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

}
