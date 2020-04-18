package com.chuan.sword_offers;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hechuan
 */
public class ReOrderArrayForOddFirst_13 {

    public void reOrderArray1(int[] array) {
        int tmp, even = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                tmp = array[i];
                System.arraycopy(array, even, array, even + 1, i - even);
                array[even++] = tmp;
            }
        }
    }

    /**
     * Optimised with extra space.
     *
     * @param array input array
     */
    public void reOrderArray2(int[] array) {
        Queue<Integer> even = new ArrayDeque<>();
        Queue<Integer> odd = new ArrayDeque<>();
        for (int i : array) {
            if ((i & 1) == 0) { even.offer(i); }
            else { odd.offer(i); }
        }
        int index = 0;
        while (!odd.isEmpty()) { array[index++] = odd.poll(); }
        while (!even.isEmpty()) { array[index++] = even.poll(); }
    }
}
