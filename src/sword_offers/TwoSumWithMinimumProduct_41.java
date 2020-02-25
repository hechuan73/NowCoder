package sword_offers;

import java.util.ArrayList;

/**
 * @author hechuan
 */
public class TwoSumWithMinimumProduct_41 {

    /**
     * Simple solution with one loop and binary searching.
     *
     * @param array input array
     * @param sum   target sum
     * @return the two numbers with minimum product
     */
    public ArrayList<Integer> FindNumbersWithSum1(int[] array, int sum) {
        int maxProduct = Integer.MAX_VALUE;
        ArrayList<Integer> res = new ArrayList<>();
        int start, end, mid, tmpSum;
        for (int i = 0; i < array.length - 1; i++) {
            start = i + 1;
            end = array.length - 1;
            tmpSum = sum - array[i];
            while (start <= end) {
                mid = ((end - start) >> 1) + start;
                if (array[mid] == tmpSum) {
                    if (array[i] * array[mid] < maxProduct) {
                        if (res.isEmpty()) {
                            res.add(array[i]);
                            res.add(array[mid]);
                        } else {
                            res.set(0, array[i]);
                            res.set(1, array[mid]);
                        }
                    }
                    break;
                } else if (array[mid] > tmpSum) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return res;
    }

    /**
     * Optimised solution with one loop:
     *
     * 数列满足递增，设两个头尾两个指针i和j，
     * 若ai + aj == sum，就是答案（相差越远乘积越小）
     * 若ai + aj > sum，aj肯定不是答案之一（前面已得出 i 前面的数已是不可能），j -= 1
     * 若ai + aj < sum，ai肯定不是答案之一（前面已得出 j 后面的数已是不可能），i += 1
     *
     * @param array input array
     * @param sum   target sum
     * @return the two numbers with minimum product
     */
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int start = 0, end = array.length - 1;
        while (start < end) {
            if (array[start] + array[end] == sum) {
                res.add(array[start]);
                res.add(array[end]);
                break;
            }
            while (start < end && array[start] + array[end] < sum) { start++; }
            while (start < end && array[start] + array[end] > sum) { end--; }
        }

        return res;
    }

}