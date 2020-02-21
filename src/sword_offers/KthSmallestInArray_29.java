package sword_offers;

import java.util.ArrayList;

/**
 * @author hechuan
 */
public class KthSmallestInArray_29 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (k > input.length  || k < 0) { return res; }
        int start = 0, end = input.length-1, pivot;
        k = k-1;
        while (start < end) {
            pivot = partition(input, start, end);
            if (pivot == k) { break; }
            else if (pivot > k) { end = pivot-1; }
            else { start = pivot + 1; }
        }


        for (int i = 0; i <= k; i++) { res.add(input[i]); }
        return res;
    }

    private int partition(int[] array, int start, int end) {
        int index = start, tmp;
        for (int i = start; i < end; i++) {
            if (array[i] < array[end]) {
                tmp = array[index];
                array[index++] = array[i];
                array[i] = tmp;
            }
        }

        tmp = array[end];
        array[end] = array[index];
        array[index] = tmp;
        return index;
    }
}
