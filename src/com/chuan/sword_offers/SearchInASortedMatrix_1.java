package com.chuan.sword_offers;


/**
 * @author hechuan
 */
public class SearchInASortedMatrix_1 {

    public boolean Find(int target, int [][] array) {
        if (array.length == 0 || array[0].length == 0) { return false; }
        for (int[] ints : array) {
            for (int j = 0; j < array[0].length; j++) {
                if (ints[j] == target) { return true; }
                if (ints[j] > target) { break; }
            }

        }

        return false;
    }
}
