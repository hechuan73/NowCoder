package com.chuan.pdd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hechuan
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] products = new int[n];
        for (int i = 0; i < n; i++) {
            products[i] = scanner.nextInt();
        }
        scanner.close();

        Arrays.sort(products);
        long res = 0, count = 1;
        for (int i = products.length - 1; i >= 0; i--) {
            if (count++ % 3 != 0) {
                res += products[i];
            }
        }

        System.out.println(res);
    }
}
