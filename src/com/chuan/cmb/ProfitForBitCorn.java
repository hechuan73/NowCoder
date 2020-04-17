package com.chuan.cmb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 问题：给定一个正整数数组，它的第 i 个元素是比特币第 i 天的价格。如果你最多只允许完成一笔交易（即买入和卖出一次），设计一个算法来计算你所能获取
 * 的最大利润。注意你不能在买入比特币前卖出。
 *
 * 输入：正整数数组，为以空格分隔的n个正整数。
 * 输出：最大利润。
 *
 * @author hechuan
 */
public class ProfitForBitCorn {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();
        while (scanner.hasNext()) {
            nums.add(scanner.nextInt());
        }
        scanner.close();

        System.out.println(calculate(nums));
    }

    public static int calculate(List<Integer> nums) {
        int size = nums.size(), num;
        int lastMax = nums.get(size-1);
        for (int i = size - 1; i >= 0; i--) {
            num = nums.get(i);
            lastMax = Math.max(lastMax, num);
            nums.set(i, lastMax - num);
        }

        int res = 0;
        for (Integer val : nums) {
            res = Math.max(res, val);
        }
        return res;
    }
}
