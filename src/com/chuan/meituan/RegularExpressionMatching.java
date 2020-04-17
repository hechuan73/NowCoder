package com.chuan.meituan;

import java.util.Scanner;

/**
 * 问题：给出两个字符串，分别是模式串P和目标串T，判断模式串和目标串是否匹配，匹配输出 1，不匹配输出 0。模式串中‘？’可以匹配目标串中的任何字符，
 * 模式串中的 ’*’可以匹配目标串中的任何长度的串，模式串的其它字符必须和目标串的字符匹配。例如P=a?b，T=acb，则P 和 T 匹配。
 *
 * 输入：输入第一行包含一个字符串p， (1 ≤ |p| ≤ 20)。输入第二行包含一个字符串t， (1 ≤ |t| ≤ 20)。
 * 输出：输出仅包含0和1的整数，0表示p和t不匹配，1表示p和t匹配。
 *
 * @author hechuan
 */
public class RegularExpressionMatching {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine();
        String target = scanner.nextLine();
        System.out.println(doMatch(pattern.toCharArray(), target.toCharArray()) ? 1 : 0);
        scanner.close();
    }

    private static boolean doMatch(char[] pattern, char[] target) {
        // dp[i][j]表示模式串的前i个字符能够与目标串的前j个字符匹配
        boolean[][] dp = new boolean[pattern.length+1][target.length+1];
        dp[0][0] = true;
        // 初始化当pattern不为空，target为空字符串的情况
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i-1][0] && pattern[i-1] == '*';
        }

        for (int i = 0; i < pattern.length; i++) {
            for (int j = 0; j < target.length; j++) {
                // 两者匹配或者模式串为?的情形
                if (pattern[i] == target[j] || pattern[i] == '?') {
                    dp[i+1][j+1] = dp[i][j];
                }
                // 模式串为*时，表示目标串中的该字符可以匹配，也可以不匹配
                if (pattern[i] == '*') {
                    dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j];
                }
            }
        }

        return dp[pattern.length][target.length];
    }
}
