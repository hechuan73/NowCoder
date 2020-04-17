package com.chuan.cmb.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Character, Character> map = new HashMap<>();
        map.put('1', '1');
        map.put('2', '5');
        map.put('3', '8');
        map.put('4', '7');
        map.put('5', '2');
        map.put('6', '9');
        map.put('7', '4');
        map.put('8', '3');
        map.put('9', '6');

        String tmp;
        while (scanner.hasNext()) {
            tmp = scanner.next();
            System.out.println(check(map, tmp));
        }

        scanner.close();
    }

    public static String check(Map<Character, Character> map, String string) {
        char[] chars = string.toCharArray();
        int start = 0, end = chars.length-1;
        while (start < end) {
            if (chars[end] != map.get(chars[start])) {
                return "NO";
            }
            start++;
            end--;
        }

        return "YES";
    }
}
