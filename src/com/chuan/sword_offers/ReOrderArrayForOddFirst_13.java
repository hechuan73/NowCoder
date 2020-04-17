package com.chuan.sword_offers;

/**
 * @author hechuan
 */
public class ReOrderArrayForOddFirst_13 {

    public void reOrderArray(int[] array) {
        int tmp, even = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                tmp = array[i];
                System.arraycopy(array, even, array, even + 1, i - even);
                array[even++] = tmp;
            }
        }
    }
}
