package com.chuan.sword_offers;

/**
 * @author hechuan
 */
public class MinimumNumberInRotatedAndSortedArray_6 {

    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) { return 0; }

        int low = 0, high = array.length-1, mid;
        while (low < high) {
            mid = ((high-low) >> 1) + low;
            if (array[mid] > array[high]) { low = mid+1; }
            else if (array[mid] < array[high]) { high = mid; }
            // 两者相等时，无法判定，可能包含左边的数字一直是一样的这种情况，所以只能让high减小
            else { high--; }
        }

        return array[low];
    }
}
