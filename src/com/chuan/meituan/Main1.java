package com.chuan.meituan;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hechuan
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();
        Arrays.sort(nums);
        int left = 0, right = 0;

        int maxWinLen = 0;
        while (right < nums.length) {
            if (nums[right] - nums[left] <= x) {
                maxWinLen = Math.max(maxWinLen, right-left+1);
                right++;
            }
            else {
                left++;
            }
        }
        System.out.println(n - maxWinLen);
    }
}
