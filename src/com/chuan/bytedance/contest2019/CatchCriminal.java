package com.chuan.bytedance.contest2019;

import java.util.Scanner;

/**
 * @author hechuan
 */
public class CatchCriminal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int maxDist = scanner.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solve(arr, maxDist));
        scanner.close();
    }

    private static int solve(int[] arr, int maxDist) {
        if (arr.length < 3) { return 0; }
        long res = 0;
        int left, right;
        left = 0; right = 2;
        while (right < arr.length) {
            if (right-left < 2) { right++; }
            else if (arr[right] - arr[left] > maxDist) { left++; }
            else {
                // 每次固定right，在[left, right)间选两个
                long num = right-left;
                res += num*(num-1)/2;
                right++;
            }
        }

        return (int) (res % 99997867);
    }
}
