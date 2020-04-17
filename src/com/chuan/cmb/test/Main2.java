package com.chuan.cmb.test;

import java.util.List;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        String[] strings;
        for (int i = 0; i < t; i++) {
            strings = scanner.nextLine().split(" ");
            System.out.println(calculate(strings[0], Integer.parseInt(strings[1])));
        }
    }

    private int res;
    public static int calculate(String string, int k) {
        return 0;
    }

    private static void backtracking(String string) {

    }

    private static int[] getNums(String string) {
        return null;
    }
}
