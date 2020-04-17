package com.chuan.pdd;

import java.util.Scanner;

/**
 * @author hechuan
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            calculate(nums, n, m, i);
        }

        System.out.println(res);
    }

    private static int res = 0;
    public static void calculate(int[] nums, int n, int m, int len) {
        long sum = 0;
        int count = 0, left = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            count++;
            if (count == len) {
                res += sum % m == 0 ? 1 : 0;
                sum -= nums[left];
                left++;
                count--;
            }
        }
    }
}
