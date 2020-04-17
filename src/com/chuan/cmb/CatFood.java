package com.chuan.cmb;

import java.util.Scanner;

/**
 * 问题：小招喵喜欢吃喵粮。这里有 N 堆喵粮，第 i 堆中有 p[i] 粒喵粮。喵主人离开了，将在 H 小时后回来。小招喵可以决定她吃喵粮的速度 K 单位：
 * 粒/小时）。每个小时，她将会选择一堆喵粮，从中吃掉 K 粒。如果这堆喵粮少于 K 粒，她将吃掉这堆的所有喵粮，然后这一小时内不会再吃更多的喵粮。小招
 * 喵喜欢慢慢吃，但仍然想在喵主人回来前吃掉所有的喵粮。返回她可以在 H 小时内吃掉所有喵粮的最小速度 K（K 为整数）。
 *
 * 输入：第一行输入为喵粮数组，以空格分隔的N个整数，第二行输入为H小时数。
 * 输出：最小速度K
 *
 * @author hechuan
 */
public class CatFood {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int h = scanner.nextInt();
        scanner.close();

        int maxSpeed = Integer.MIN_VALUE, minSpeed, total = 0;
        int[] data = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            data[i] = Integer.parseInt(strings[i]);
            maxSpeed = Math.max(maxSpeed, data[i]);
            total += data[i];
        }

        minSpeed = total%h == 0 ? total / h : total/h+1;
        int mid = 0;
        while (minSpeed <= maxSpeed) {
            mid = minSpeed + ((maxSpeed-minSpeed)>>1);
            if (getHour(data, mid, h)) {
                maxSpeed = mid-1;
            }
            else {
                minSpeed = mid+1;
            }
        }

        System.out.println(minSpeed);
    }

    public static boolean getHour(int[] data, int k, int h) {
        int sum = 0;
        for (int val : data) {
            sum += val % k == 0? val/k : val/k+1;
        }

        return sum <= h;
    }
}
