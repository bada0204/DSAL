package al.sort;

public class MergeSort {

    public static int[] sort(int[] A) {
        sort(A, 0, A.length - 1);
        return A;
    }

    private static void sort(int[] A, int start, int end) {
        // do nothing if the end index is less than the start index
        if (start >= end)
            return;
        // get the mid index
        int mid = start + (end - start) / 2;
        // divide array half
        sort(A, start, mid);
        sort(A, mid + 1, end);
        // sort array while merging two divided arrays
        merge(A, start, mid, end);
    }

    private static void merge(int[] A, int start, int mid, int end) {
        // create temp array that will be sorted
        int[] sorted = new int[end - start + 1];
        // index for sorted array
        int i = 0;
        // indices to compare left part and right part
        int l = start;
        int r = mid + 1;
        // sort and merge
        while(l <= mid && r <= end) {
            if (A[l] < A[r]) {
                sorted[i++] = A[l++];
            } else {
                sorted[i++] = A[r++];
            }
        }
        while(l <= mid) {
            sorted[i++] = A[l++];
        }
        while(r <= end) {
            sorted[i++] = A[r++];
        }
        // the array is sorted now
        // copy over to original array
        for (int j = start; j <= end; j++) {
            A[j] = sorted[j - start];
        }
    }

}