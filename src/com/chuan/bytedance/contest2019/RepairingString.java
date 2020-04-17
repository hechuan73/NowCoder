package com.chuan.bytedance.contest2019;

import java.util.Scanner;

/**
 * @author hechuan
 */
public class RepairingString {

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str;
        for (int i = 0; i < n; i++) {
            str = scanner.next();
            System.out.println(repair(str));
        }
        scanner.close();
    }

    private static String repair(String str) {
        if (str.length() < 3) { return str; }
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder(str.substring(0,2));
        int index = 2;
        for (int i = 2; i < chars.length; i++) {
            if (sb.charAt(index-2) != sb.charAt(index-1) || sb.charAt(index-1) != chars[i]) {
                sb.append(chars[i]);
                index++;
            }

            if (index >= 4) {
                if (sb.charAt(index-4) == sb.charAt(index-3) && sb.charAt(index-2) == sb.charAt(index-1)
                        && sb.charAt(index-3) != sb.charAt(index-2)) {
                    sb.deleteCharAt(index-2);
                    index--;
                }
            }
        }
        return sb.toString();
    }
}
