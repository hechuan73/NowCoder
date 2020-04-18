package com.chuan.sword_offers;


/**
 * @author hechuan
 */
public class SearchInASortedMatrix_1 {

    /**
     * Simple solution.
     *
     * @param target target number
     * @param array input arry
     * @return whether there is a number equal to the target number in the matrix
     */
    public boolean Find1(int target, int [][] array) {
        if (array.length == 0 || array[0].length == 0) { return false; }
        for (int[] ints : array) {
            for (int j = 0; j < array[0].length; j++) {
                if (ints[j] == target) { return true; }
                if (ints[j] > target) { break; }
            }

        }

        return false;
    }

    /**
     * Optimised solution with searching from left-bottom to right-up.
     *
     * @param target target number
     * @param array input arry
     * @return whether there is a number equal to the target number in the matrix
     */
    public boolean Find2(int target, int [][] array) {
        if (array.length == 0 || array[0].length == 0) { return false; }
        int rows = array.length, cols = array[0].length;
        int row = rows-1, col=0;

        while (row >= 0 && col < cols) {
            if (array[row][col] < target) {
                col++;
            }
            else if (array[row][col] > target) {
                row--;
            }
            else {
                return true;
            }
        }

        return false;
    }
}
