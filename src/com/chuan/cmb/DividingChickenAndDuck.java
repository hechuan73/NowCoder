package com.chuan.cmb;

import java.util.Scanner;

/**
 * 问题：农场有n只鸡鸭排为一个队伍，鸡用“C”表示，鸭用“D”表示。当鸡鸭挨着时会产生矛盾。需要对所排的队伍进行调整，使鸡鸭各在一边。每次调整只能让相
 * 邻的鸡和鸭交换位置，现在需要尽快完成队伍调整，你需要计算出最少需要调整多少次可以让上述情况最少。例如：CCDCC->CCCDC->CCCCD这样就能使之前的两
 * 处鸡鸭相邻变为一处鸡鸭相邻，需要调整队形两次。
 *
 * 输入：输入一个长度为N，且只包含C和D的非空字符串。
 * 输出：使得最后仅有一对鸡鸭相邻，最少的交换次数。
 *
 * @author hechuan
 */
public class DividingChickenAndDuck {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.next().toCharArray();
        scanner.close();

        System.out.println(exchange(chars));
    }

    public static int exchange(char[] chars) {
        int cCount = 0, dCount = 0;
        int resC = 0, resD = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'C') {
                resC += i-cCount;
                // 记录出现前面出现多少个'C', 从第i个位置把C移动到第cCount个位置需要移动 i-cCount 次
                cCount++;
            }
            else {
                resD += i-dCount;
                // 记录出现前面出现多少个 'D'
                dCount++;
            }
        }

        return Math.min(resC, resD);
    }
}
