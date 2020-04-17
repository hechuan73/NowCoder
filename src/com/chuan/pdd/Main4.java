package com.chuan.pdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author hechuan
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long[] nums = new long[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        long res = 1;
        long left = -1, last = nums[0];
        List<Integer> keys = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != last) {
                if (keys.size() < k) {
                    keys.add(i);
                }
                else {
                    res = Math.max(res, i-left-keys.size()-1);
                    if (!keys.isEmpty()) {
                        keys.remove(0);
                        keys.add(i);
                        left = keys.get(0);
                    }
                    else {
                        left = i;
                    }
                }
            }
            else {
                last = nums[i];
            }
        }

        System.out.println(res);
    }
}
