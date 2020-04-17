package com.chuan.cmb;

import java.util.Scanner;

/**
 * 问题：我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 *      如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方；6 和
 *      9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 *
 * 输入：输入正整数N
 * 输出：输出1到N中好数个数
 *
 * @author hechuan
 */
public class GoodNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        int res = 0;
        String str;
        boolean good, bad;
        for (int i = 0; i <= n; i++) {
            str = String.valueOf(i);
            good = str.contains("2") || str.contains("5") || str.contains("6") || str.contains("9");
            bad = str.contains("3") || str.contains("4") || str.contains("7");
            if (good && !bad) {
                res++;
            }
        }

        System.out.println(res);
    }
}
